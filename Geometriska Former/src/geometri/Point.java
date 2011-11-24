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
		super(x, y, c);
		
	}
	
	/**
	 * Construct a Point from a GeometricalForm and a Color.
	 * 
	 * @param f Form with coordinates for the point.
	 * @param c Color of the point.
	 */
	public Point( GeometricalForm f, Color c ) {
		super(f, c);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int area() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor( super.getColor() );
		g.fillRect( super.getX(), super.getY(), 1, 1 );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int perimeter() {
		return 0;
	}

}
