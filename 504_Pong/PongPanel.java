 
//This class handles the game logic and anything related to the game, such as the score, ball and paddles. It also needs to handle what happens when the user presses a key to move the paddle up and down. 

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class PongPanel extends JPanel implements ActionListener, KeyListener {
    
    private final static String BACKGROUND_COLOUR = Color.BLACK;

    public PongPanel(){
        setBackground(BACKGROUND_COLOUR);
    }

    public void keyTyped(KeyEvent event) {}
    public void keyPressed(KeyEvent) {}
    public void keyReleased(KeyEvent) {}
    public void actionPerformed(ActionEvent) {}
    public void keyTyped(KeyEvent) {}

}

