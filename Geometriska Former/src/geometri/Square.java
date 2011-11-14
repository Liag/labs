package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Square implements GeometricalForm {
	
	private Point position;
	
	private Color color;
	
	private int side;
	
	/**
	 * Construct a square from a position, 
	 * a side length and a colour.
	 * 
	 * @param x Horizontal position of the square.
	 * @param y Vertical position of the square.
	 * @param side The length of each side.
	 * @param c The colour of the square.
	 * @throws IllegalPositionException if any coordinate 
	 * 									is negative.
	 */
	public Square( int x, int y, int side, Color c )
	           throws IllegalPositionException {
		  
	}
	
	/**
	 * Construct a square from a GeometricalForm, 
	 * a side length and a colour.
	 * 
	 * @param f Form with coordinates for the square.
	 * @param side The length of each side.
	 * @param c The colour of the square.
	 */
	public Square( GeometricalForm f, int side, Color c ) {
		  
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
