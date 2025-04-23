package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		this.x=x;
		this.y=y;
		this.size=size;
		color=Color.BLUE;
		draw ();
		//See ColorUtils for some color options (or choose your own)
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() 
	{
		StdDraw.setPenColor(this.color);
		StdDraw.filledCircle(this.x, this.y, this.size);
	}
	
	public void setX (double x) {
		this.x=x;
	}
	
	public double getX () {
		return  this.x;
	}
	public void setY (double y) {
		this.y=y;
	}
	
	public double getY () {
		return  this.y;
	}
	public double getSize () {
		return  this.size;
	}
}