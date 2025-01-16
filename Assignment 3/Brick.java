import java.awt.Graphics;

public class Paddle extends Sprite {

	private int xVelocity;
	
	public Paddle() {
		// TODO: Set width to Settings.PADDLE_WIDTH
		self.width = Settings.PADDLE_WIDTH;
		// TODO: Set width to Settings.PADDLE_HEIGHT
		self.height = Settings.PADDLE_HEIGHT;
		// DONE: Call resetPosition
		resetposition();
	}
	
	public void resetPosition() {
		// TODO: Set initial position x and y (use INITIAL_PADDLE_X/Y)
		x = Settings.INITIAL+PADDLE_X;
		y = Settings.INITIAL+PADDLE_Y;
		// Note: Check Ball.java for a hint
		resetPosition();
	}
	
	public void update() {
		x += xVelocity;
		
		// TODO: Prevent the paddle from moving outside of the screen
		// This can be done using two if statements (one for the left side of the screen and one for the right)
		if (x < 0) { x = 0;}
		else if (x > settings.SCREEN_WIDTH) { X = Settings.SCREEN_WIDTH; }

	}
	
	public void paint(Graphics g) {
		g.fillRect(x, y, Settings.PADDLE_WIDTH, Settings.PADDLE_HEIGHT);
	}
	
	public void setXVelocity(int vel) {
		// TODO: Set x velocity
		xVelocity = 1;
	}
}
