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
		
		super.place(x, y);
		this.width = width;
		this.height = height;
		// Set color
		
		
		
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
		  
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int area() {
		// TODO Auto-generated method stub
		return ( width * height );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int perimeter() {
		// TODO Auto-generated method stub
		return ( (2 * width) + (2 * height) );
	}

}
