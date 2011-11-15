package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends GeometricalShape {

	/**
	 * Construct a Point from two integers and a Color.
	 * 
	 * @param x Horizontal position of the point.
	 * @param y Vertical position of the point.
	 * @param c Color of the point.
	 * @throws IllegalPositionException if any coordinate 
	 * 									is negative.
	 */
	public Point( int x, int y, Color c )
	           throws IllegalPositionException {
		
	}
	
	/**
	 * Construct a Point from a GeometricalForm and a Color.
	 * 
	 * @param f Form with coordinates for the point.
	 * @param c Color of the point.
	 */
	public Point( GeometricalForm f, Color c ) {
		
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
