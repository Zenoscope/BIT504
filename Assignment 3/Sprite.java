import java.awt.Rectangle;

public class Sprite {
	
	protected int x,y,width,height;
	
	// Note: This should only set a single value, they can be done in a single statement
	// sets the x and y  location of the sprite
	public void setX(int x) {
		// TODO
		this.x = x;
	}
	public void setY(int y) { 
		// TODO
		this.y = y;
	}
	// set the width and height of the sprite
	public void setWidth(int width) { 
		// TODO
		this.width = width;
	}
	public void setHeight(int height) { 
		// TODO
		this.height = height;
	}
	
	// return the X adnd Y location
	public int getX() { 
		return x;	// TODO: Return correct value
	}
	public int getY() { 
		return y;	// TODO: Return correct value
	}
	// retun the width and height
	public int getWidth() { 
		return width;	// TODO: Return correct value
	}
	public int getHeight() { 
		return height;	// TODO: Return correct value
	}
	
	// get the rectangle of the sprite
	Rectangle getRectangle() {
		//System.out.print(Integer.toString(height));
		return new Rectangle(x, y, width, height);
	}
}
