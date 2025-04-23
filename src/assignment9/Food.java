package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		x = Math.random ();
		y = Math.random ();
	}
	

	public void draw() {
		
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
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
	public double getFOOD_SIZE ()
	{
		return FOOD_SIZE;
	}
}

