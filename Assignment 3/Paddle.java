import java.awt.Graphics;

public class Paddle extends Sprite {

	private int xVelocity;
	
	public Paddle() {
		// TODO: Set width to Settings.PADDLE_WIDTH
		this.width = Settings.PADDLE_WIDTH;
		// TODO: Set width to Settings.PADDLE_HEIGHT
		this.height = Settings.PADDLE_HEIGHT;
		// DONE: Call resetPosition
		resetPosition();
	}
	
	public void resetPosition() {
		// TODO: Set initial position x and y (use INITIAL_PADDLE_X/Y)
		// Note: Check Ball.java for a hint
		this.x = Settings.INITIAL_PADDLE_X;
		this.y = Settings.INITIAL_PADDLE_Y;		
	}
	
	public void update() {
		x += xVelocity;
		
		// TODO: Prevent the paddle from moving outside of the screen
		// This can be done using two if statements (one for the left side of the screen and one for the right)
		// Stop on left side of screen
		if(x <= 0 ) {
			// DONE: Set x to 0 so it does not leave the screen
			x = 0 ;//  - (Settings.PADDLE_WIDTH )
		}
		
		// Stop on right side of screen
		if(x >= Settings.WINDOW_WIDTH - (Settings.PADDLE_WIDTH) ) {
			// DONE: Set x to the right edge of the screen (see the above if condition)
			x = Settings.WINDOW_WIDTH -  (Settings.PADDLE_WIDTH);
		}

	}
	
	public void paint(Graphics g) {
		g.fillRect(x, y, Settings.PADDLE_WIDTH, Settings.PADDLE_HEIGHT);
	}
	
	public void setXVelocity(int vel) {
		// TODO: Set x velocity
		this.xVelocity = vel;
	}
}
