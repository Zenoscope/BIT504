import java.awt.Graphics;

public class Ball extends Sprite {

	private int xVelocity = 1, yVelocity = -1;
	
	// Constructor
	public Ball() {
		// DONE: Set width to Settings.BALL_WIDTH
		int width = Settings.BALL_WIDTH;
		// DONE: Set width to Settings.BALL_HEIGHT
		int height = Settings.BALL_HEIGHT;
		// DONE: Call resetPosition
		resetPosition();
	}
	
	/**
	 * Resets the ball to the initial position
	 * Uses Settings.INITIAL_BALL_X/Y to set the position of the ball
	 */
	public void resetPosition() {
		setX(Settings.INITIAL_BALL_X);
		// DONE: Set the balls y by using the INITIAL_BALL_Y (see above)
		setY(Settings.INITIAL_BALL_Y);
	}
	
	public void update() {
		x += xVelocity;
		// DONE: Increase the y variable by yVelocity (see above)
		y += yVelocity;
		
		// Bounce off left side of screen
		if(x <= 0) {
			// DONE: Set x to 0 so it does not leave the screen
			x = 0;
			// TODO: Change the x velocity to make the ball go right
			xVelocity = xVelocity * -1;
		}
		
		// Bounce off right side of screen
		if(x >= Settings.WINDOW_WIDTH - Settings.BALL_WIDTH) {
			// DONE: Set x to the right edge of the screen (see the above if condition)
			x = Settings.WINDOW_WIDTH - Settings.BALL_WIDTH;
			// DONE: Change the x velocity to make the ball go left
			xVelocity = xVelocity * -1;
		}
		
		// Bounce off top of screen
		if(y <= 0) {
			// DONE: Set y to 0 so it does not leave the screen
			y = 0;
			// DONE: Change the y velocity to make the ball go downward
			yVelocity = yVelocity * -1;
		}
		
	}
	
	public void setXVelocity(int x) {
		// TODO: Set the x velocity
		xVelocity = 1;
	}
	public void setYVelocity(int y) {
		// TODO: Set the y velocity
		yVelocity = 1;
	}
	
	public int getXVelocity() {		
		return xVelocity;	// DONE: Return the x velocity
	}
	public int getYVelocity() {
		return yVelocity;	// DONE: Return the y velocity
	}
	
	public void paint(Graphics g) {
		g.fillOval(x, y, Settings.BALL_WIDTH, Settings.BALL_HEIGHT);
	}
}
