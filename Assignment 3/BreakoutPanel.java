import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BreakoutPanel extends JPanel implements ActionListener, KeyListener {
	
	static final long serialVersionUID = 2L;

	private boolean gameRunning = true;
	private int livesLeft = Settings.NUM_LIVES;
	private int level = Settings.START_LEVEL;
	private String screenMessage = "";
	private Ball ball;
	private Paddle paddle;
	private Brick bricks[];
	
	public BreakoutPanel(Breakout game) {
		
		addKeyListener(this);
		setFocusable(true);
		
		Timer timer = new Timer(5, this);
		timer.start();
		
		// Create a new ball object and assign it to the appropriate variable
		ball = new Ball();
		// Create a new paddle object and assign it to the appropriate variable
		paddle = new Paddle();
		// Create a new bricks array (Use Settings.TOTAL_BRICKS)
		bricks = new Brick[Settings.TOTAL_BRICKS];		
		// Call the createBricks() method
		createBricks();
	}
	
	// create the wall of bricks
	private void createBricks() {
		int counter = 0;
		int x_space = 0;
		int y_space = 0;
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 5; y++) {
				bricks[counter] = new Brick((x * Settings.BRICK_WIDTH) + Settings.BRICK_HORI_PADDING + x_space, (y * Settings.BRICK_HEIGHT) + Settings.BRICK_VERT_PADDING + y_space);								
				counter++;
				y_space++;
			}
			x_space++;
			y_space = 0;
		}
	}
	
	// draw the bricks
	private void paintBricks(Graphics g) {
		// Loop through the bricks and call the paint() method
		int counter = 0;
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 5; y++) {
				bricks[counter].paint(g);
				counter++;
			}			
		}
	}
	
	// update the screen
	private void update() {
		if(gameRunning) {
			// Update the ball and paddle
			ball.update();
			paddle.update();
			collisions();
			repaint();
		}
	}
	
	
	private void gameOver() {
		// Set screen message
		// this.screenMessage = "Game over! Play again? Y/N";
		this.screenMessage = "Game over";
		stopGame();		
	}
	
	private void gameWon() {
		// Set screen message
		this.screenMessage = "You won.";
		stopGame();
	}
	
	private void stopGame() {
		gameRunning = false;
	}
	
	private void restartGame() {
		livesLeft = Settings.NUM_LIVES;
		ball.resetPosition();
		ball.setYVelocity(Settings.BALL_Y_VELOCITY * -1);
	}
		
	private void collisions() {
		// Check for loss
		if(ball.y > Settings.WINDOW_HEIGHT - 30) { //falls out the bottom
			// Game over
			livesLeft--;
			if(livesLeft <= 0) {
				gameOver();
				return;
			} else {
				// reset and start over
				ball.resetPosition();
				ball.setYVelocity(Settings.BALL_Y_VELOCITY * -1);
			}
		}
		
		// Check for win
		boolean bricksLeft = false;
		
		for(int i = 0; i < bricks.length; i++) {
			// Check if there are any bricks left
			if(!bricks[i].isBroken()) {
				// Brick was found, close loop
				bricksLeft = true;
				break;
			}
		}
		if(!bricksLeft) {
			gameWon();
			return;
		}
		
		// Check collisions
		if(ball.getRectangle().intersects(paddle.getRectangle())) {
			// Simplified touching of paddle and change of angle/velocity depending on 
			// where the ball hits on the paddle
			
			// get the middle of the paddle (so the X location)
			// and the location of the ball
			if ( ball.getX() > paddle.getX() ) {
				
				float ballx = ball.getX();
				float paddlex = paddle.getX() + 100;
				// angle is not really an angle
				float angle = ballx / paddlex;
				// reset the velocity
				// System.out.println(angle);
				ball.setXVelocity( (angle + 1) * -1  );
				ball.setYVelocity( (1 - angle) * - 1 );
				}
			
			else if ( ball.getX() < paddle.getX() ) {
					float ballx = ball.getX();
					float paddlex = paddle.getX() - 100;
					float angle = ballx / paddlex;
					//System.out.println(angle);
					ball.setXVelocity( (angle + 1) * -1 );
					ball.setYVelocity( (1 - angle) * - 1 );
					}
		}
		
		for(int i = 0; i < bricks.length; i++) {
			if (ball.getRectangle().intersects(bricks[i].getRectangle())) {
				int ballLeft = (int) ball.getRectangle().getMinX();
	            int ballHeight = (int) ball.getRectangle().getHeight();
	            int ballWidth = (int) ball.getRectangle().getWidth();
	            int ballTop = (int) ball.getRectangle().getMinY();

	            Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
	            Point pointLeft = new Point(ballLeft - 1, ballTop);
	            Point pointTop = new Point(ballLeft, ballTop - 1);
	            Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);
	            
	            // bounces the ball depending on where it hits the brick
	            // this uses the velocity of the ball, so we could potentially
	            // make it faster/slower depending on the brick that gets hit
	            if (!bricks[i].isBroken()) {
	                if (bricks[i].getRectangle().contains(pointRight)) {
	                    ball.setXVelocity(Settings.BALL_X_VELOCITY * -1);
	                	//ball.setXVelocity(ball.getXVelocity() * -1);
	                } else if (bricks[i].getRectangle().contains(pointLeft)) {
	                    ball.setXVelocity(Settings.BALL_X_VELOCITY * 1);
	                	//ball.setXVelocity(ball.getXVelocity() * 1);
	                }

	                if (bricks[i].getRectangle().contains(pointTop)) {
	                    ball.setYVelocity(Settings.BALL_Y_VELOCITY);
	                	//ball.setYVelocity(ball.getYVelocity() * 1);
	                } else if (bricks[i].getRectangle().contains(pointBottom)) {
	                    ball.setYVelocity(Settings.BALL_Y_VELOCITY * -1);
	                	//ball.setYVelocity(ball.getYVelocity() * 1);
	                }
	                bricks[i].setBroken(true);
	            }
			}
		}
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ball.paint(g);
        paddle.paint(g);
        paintBricks(g);
        
        // Draw lives left         
        g.setFont(new Font("Arial", Font.BOLD, 18));
        String stringLivesLeft = "Lives: " + Integer.toString(livesLeft);
        g.drawString(stringLivesLeft, 10, 20 );

    	        
        // Draw screen message
        if(screenMessage != null) {
        	g.setFont(new Font("Arial", Font.BOLD, 18));
        	int messageWidth = g.getFontMetrics().stringWidth(screenMessage);
        	g.drawString(screenMessage, (Settings.WINDOW_WIDTH / 2) - (messageWidth / 2), Settings.MESSAGE_POSITION);
        }
    }

	@Override
	public void keyPressed(KeyEvent event) {
		// press the A key or left arrow to move the paddle left, and the D key or right arrow for right.
        if (event.getKeyCode() == KeyEvent.VK_A || event.getKeyCode() == KeyEvent.VK_LEFT ) {
        	paddle.setXVelocity(Settings.PADDLE_VELOCITY * - 1);
           } else if (event.getKeyCode() == KeyEvent.VK_D || event.getKeyCode() == KeyEvent.VK_RIGHT) {
        	paddle.setXVelocity(Settings.PADDLE_VELOCITY);
        }
        
        // restart game on keypress
        /*
        if (event.getKeyCode() == KeyEvent.VK_Y && livesLeft <= 0 ) {
        	System.out.println("key pressed");
        	restartGame();
        }*/
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO: Set the velocity of the paddle after the player has released the keys
		paddle.setXVelocity(0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
	}

}
