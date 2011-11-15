package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends GeometricalShape {
	
	/** Radius of the circle */
	private int radius;
	
	/**
	 * Construct a circle from a position, 
	 * radius and color.
	 * 
	 * @param x Horizontal position of the circle.
	 * @param y Vertical position of the circle.
	 * @param radius The radius of the circle.
	 * @param c The color of the circle.
	 * @throws IllegalPositionException if any coordinate 
	 * 									is negative.
	 */
	 public Circle( int x, int y, int radius, Color c )
	           throws IllegalPositionException {
		 
	 }
	  
	/**
	 * Construct a rectangle from a position, 
	 * width, height and color.
	 * 
	 * @param f Form with coordinates for the circle.
	 * @param radius The radius of the circle.
	 * @param c The color of the circle.
	 */
	 public Circle( GeometricalForm f, int radius, Color c ) {
		  
	 }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int area() {
		// TODO Auto-generated method stub
		return 0;
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
		return 0;
	}



}
