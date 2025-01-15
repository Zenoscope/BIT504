import java.awt.Color;

import javax.swing.JFrame;

public class Breakout extends JFrame{
	
	static final long serialVersionUID = 1L;
	
	private BreakoutPanel panel;
	
	public Breakout() {
		// TODO: Set the size of the screen (use Settings.WINDOW_WIDTH/HEIGHT)
		Settings.WINDOW_WIDTH = 800;
		Settings.HEIGHT = 600;
		// TODO: Set the title
		Settings.TITLE = "Arkanoid";
		// TODO: Set the background colour to white
		Settings.
		// TODO: Set resizable to false
		Settings.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new BreakoutPanel(this);
        add(panel);
		// TODO: Set visible to true
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 new Breakout();	
	         }
		});

	}
}
