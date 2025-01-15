/* 
what pong needs to do:
display:
two paddles 
line
score for each player
ball

players
Control paddle 
 Paddle moves up and down (speed)
 place on paddel determines angle of return
 length
 show paddle

Ball
 bounce (change direction and angle)  
 bounce off paddle 
 has speed, and direction (angle)
 display ball
 
Court
 ball bounced off top and bottom of screen
 spawn at (particular or random spot, going a random speed and angle) fromt he centre line
 display mid line
 display score
 if the ball goes out the end, increment player score by one
 if it reaches 11, the player wins
  
 mainclass: Pong
 PongPanel controls the game loop + drawing
 Paddle and Ball classes, children of Sprite classes 
 */

 import javax.swing.JFrame;
 
 public class Pong extends JFrame {

    private final static String WINDOW_TITLE = "Pong";
    private final static  int WINDOW_WIDTH = 800;
    private final static  int WINDOW_HEIGHT = 600;
   
     // creates a new pong class.
     public Pong() {        

             setTitle(WINDOW_TITLE);
             setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
             setResizable(false);
             // adds the panel to the frame
             add(new PongPanel());
             setVisible(true);
             // what happens when the user click the clsoe button
             setDefaultCloseOperation(EXIT_ON_CLOSE);             
     }
  
     public static void main(String[] args) {
        // the invokelater delays the GUI atsk unit the initial threads tasks have
        // been completed
        javax.swing.SwingUtilities.invokeLater(new Runnable() { 
            public void run() {   
                   new Pong();   
            }   
          });
     }  
 }
