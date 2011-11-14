package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle implements GeometricalForm {

	private Point position;
	
	private Color color;
	
	private int width;
	private int height;
	
	/**
	 * Construct a rectangle from a position, 
	 * width, height and colour.
	 * 
	 * @param x Horizontal position of the rectangle.
	 * @param y Vertical position of the rectangle.
	 * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
	 * @param c The colour of the rectangle.
	 * @throws IllegalPositionException if any coordinate 
	 * 									is negative.
	 */
	public Rectangle( int x, int y, int width, int height, Color c )
	           throws IllegalPositionException {
		
	}
	  
	/**
	 * Construct a rectangle from a GeometricalForm, 
	 * width, height and colour.
	 * 
	 * @param f Form with coordinates for the rectangle.
	 * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
	 * @param c The colour of the rectangle.
	 */
	public Rectangle( GeometricalForm f, int width, int height, Color c ) {
		  
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
