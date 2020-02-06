package flightclock;

import java.util.Date;
import java.util.Calendar; 
import java.util.TimeZone;


public class ClockWorks {

	public static void main(String[] args) {
		
	}
	
	public static Date returnTime() {
//		System.out.println(System.currentTimeMillis());
		
		//MAKE SURE YOUR PC IS SET IN DESTINATION TIMEZONE WHILE RUNNING THIS PROGRAM!!!
		
		//FIRST WE SET DEPARTURE TIMEZONE
				TimeZone depTZ = TimeZone.getTimeZone("GMT+4:00");
				//NO, WE DON'T! WE ASSUME WE ARE ALREADY IN SAID TIMEZONE AT DEP TIME AND "DILATE" OUR WAY IN!
				Calendar departure = Calendar.getInstance();
				
				//SET DEPARTURE TIME
				departure.set(2019, 7, 1, 3, 30, 00);
//				System.out.println(departure.getTime());
				
				
				//SAME STUFF FOR ARRIVAL!
				Calendar arrival = Calendar.getInstance();
				arrival.set(2019, 7, 1, 17, 30, 00);
//				System.out.println(arrival.getTime());
			
				
				double flightDur = 14.0;
		
		
		//now, find percentage of flight completed! 
		long apparentDiff = arrival.getTimeInMillis() - departure.getTimeInMillis();
		
//		System.out.println(apparentDiff);
		long fDs = Math.round(flightDur*3600*1000);
//		System.out.println(fDs);
		
		double newSecondLength = Math.round(1000*fDs/apparentDiff);
		newSecondLength /= 1000;
//		System.out.println(newSecondLength);
		
		//IF NSL < 1 CLOCK WILL TICK *SLOWER* THAN USUAL
		//IF NSL > 1 CLOCK WILL TICK *FASTER* THAN USUAL
		
		//AND NOW...
		
		Calendar now = Calendar.getInstance();
		
		//status: seconds (real) elapsed since beginning of flight!
		
//		System.out.println(now.getTime());
		Calendar realDepTime = Calendar.getInstance(depTZ);
		realDepTime.set(2019, 6, 10, 22, 45, 00);
		
		long msElapsed = now.getTimeInMillis() - realDepTime.getTimeInMillis();
//		System.out.println(msElapsed);
		double virtualMSelapsed = msElapsed/newSecondLength;
//		System.out.println(virtualMSelapsed);
		long vmse = Math.round(virtualMSelapsed);
//		System.out.println(vmse);
		
		long virtualTime = departure.getTimeInMillis() + vmse;
		
		Calendar virtual = Calendar.getInstance();
		virtual.setTimeInMillis(virtualTime);
//		System.out.println();
//		System.out.println(virtual.getTime());
		return virtual.getTime();
	}

}
