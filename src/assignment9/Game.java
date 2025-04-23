package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
	private Food food;
	private int score; 
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		this.snake = new Snake ();
		this.food = new Food ();
		
		
	}
	
	public void play() {
		while (snake.isInbounds()) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);
			snake.changeDirection(dir);
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
			snake.move();
			if (snake.eatFood(food)==true) {
				food = new Food ();
			
			} updateDrawing ();
			
		
		}
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear (); 
		food.draw();
		snake.draw();
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.text (0.08,0.05, this.toString()); 
		StdDraw.pause(50);
		StdDraw.show();
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}