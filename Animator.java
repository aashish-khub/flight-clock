package flightclock;


import processing.core.PApplet;
import java.util.Date;
@SuppressWarnings("serial")
public class Animator extends PApplet{
	int DIMX = 400;
	int DIMY = 100;
	
	public void setup() {
		size(DIMX, DIMY);
		smooth();
		super.frameRate(24);
	}

	public void draw() {
		background(102, 204, 255);
		Date d = ClockWorks.returnTime();
		textSize(35);
		String str = d.toString().substring(0, 20);
		text(str, 25, 50);
	}
	
}

