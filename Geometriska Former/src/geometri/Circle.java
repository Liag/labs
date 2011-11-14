package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements GeometricalForm {

	private Point position;
	
	private Color color;
	
	private int radius;
	
	/**
	 * Construct a circle from a position, 
	 * radius and colour.
	 * 
	 * @param x Horizontal position of the circle.
	 * @param y Vertical position of the circle.
	 * @param radius The radius of the circle.
	 * @param c The colour of the circle.
	 * @throws IllegalPositionException if any coordinate 
	 * 									is negative.
	 */
	 public Circle( int x, int y, int radius, Color c )
	           throws IllegalPositionException {
		 
	 }
	  
	/**
	 * Construct a rectangle from a position, 
	 * width, height and colour.
	 * 
	 * @param f Form with coordinates for the circle.
	 * @param radius The radius of the circle.
	 * @param c The colour of the circle.
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
	public int compareTo(GeometricalForm f) {
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
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void place(int x, int y) throws IllegalPositionException {
		// TODO Auto-generated method stub

	}

}
