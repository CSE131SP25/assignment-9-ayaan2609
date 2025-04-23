package assignment9;

import java.util.LinkedList;

import edu.princeton.cs.introcs.StdDraw;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.05;
	public static final double FOOD_SIZE = 0.02;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
	  segments = new LinkedList < > ();
		segments.add (new BodySegment (0.5, 0.5, SEGMENT_SIZE));
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		for (int i = segments.size() - 1; i>0; i--) {
			
			BodySegment currSeg = segments.get(i);
			BodySegment prevSeg = segments.get(i-1);
			currSeg.setX (prevSeg.getX ());
			currSeg.setY (prevSeg.getY ());
		}
		BodySegment head = segments.get(0);
		head.setX(head.getX () + deltaX);
		head.setY(head.getY () + deltaY);
		//FIXME
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		int score = 0; 
		for (BodySegment seg: segments) {
			seg.draw();
			score ++;
		
		}
		String theScore = "The score:" +score;
		StdDraw.text (0.15, 0.05, theScore);
	
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	
	public boolean eatFood (Food f) {
		if (f==null)
		{
		return false;
	}
		
		BodySegment head = segments.get(0);
		double distance = Math.sqrt (Math.pow (head.getX() - f.getX(), 2) + (Math.pow (head.getY() - f.getY(), 2)));
		if (distance<FOOD_SIZE+ head.getSize()) 
		
		{
			segments.add(new BodySegment (segments.getLast().getX() - deltaX, segments.getLast().getY( ) - deltaY, SEGMENT_SIZE));
		
			return true; 
		}
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		
		
		if (segments.getFirst().getX() < 0)
		{
			return false; 
		}
		if (segments.getFirst().getY() < 0)
		{
			return false; 
		}
		if (segments.getFirst().getX() > 1)
		{
			return false; 
		}
		if (segments.getFirst().getY() > 1)
		{
			return false; 
		}
		return true;
	}
}