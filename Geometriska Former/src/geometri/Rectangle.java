package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends GeometricalShape {
	
	/** Width and height of the rectangle */
	private int width;
	private int height;
	
	/**
	 * Construct a rectangle from a position, 
	 * width, height and color.
	 * 
	 * @param x Horizontal position of the rectangle.
	 * @param y Vertical position of the rectangle.
	 * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
	 * @param c The color of the rectangle.
	 * @throws IllegalPositionException if any coordinate 
	 * 									is negative.
	 */
	public Rectangle( int x, int y, int width, int height, Color c )
	           throws IllegalPositionException {
		super(x, y, c);
		this.width = width;
		this.height = height;		
	}
	  
	/**
	 * Construct a rectangle from a GeometricalForm, 
	 * width, height and color.
	 * 
	 * @param f Form with coordinates for the rectangle.
	 * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
	 * @param c The color of the rectangle.
	 */
	public Rectangle( GeometricalForm f, int width, int height, Color c ) {
		  super(f, c);
		  this.width = width;
		  this.height = height;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int area() {
		return ( width * height );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor( super.getColor() );
		g.fillRect( super.getX(), super.getY(), width, height );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int perimeter() {
		return ( (2 * width) + (2 * height) );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + height;
		result = prime * result + width;
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + " Width: " + width + " Height: " + height;
	}

}
