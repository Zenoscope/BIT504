import java.awt.Color;

import javax.swing.JFrame;

public class Breakout extends JFrame{
	
	static final long serialVersionUID = 1L;
	
	private BreakoutPanel panel;
	
	public Breakout() {
		// Set the size of the screen		
        setSize(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);                
       	// adds the panel to the frame
		// FIXME this didn't work
        // add(new BreakoutPanel());		
		// DONE: Set the title
		setTitle(Settings.WINDOW_NAME);
		// DONE: Set the background colour to white		
		setBackground(Color.WHITE);
		// DONE: Set resizable to false
		setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new BreakoutPanel(this);
        add(panel);
		// Set window visible to true
		setVisible(true);
		}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 new Breakout();
	         }
		});

	}
}
