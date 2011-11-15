package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends GeometricalShape {
	
	/** Sidelenght of the square */
	private int side;
	
	/**
	 * Construct a square from a position, 
	 * a side length and a color.
	 * 
	 * @param x Horizontal position of the square.
	 * @param y Vertical position of the square.
	 * @param side The length of each side.
	 * @param c The color of the square.
	 * @throws IllegalPositionException if any coordinate 
	 * 									is negative.
	 */
	public Square( int x, int y, int side, Color c )
	           throws IllegalPositionException {
		  
	}
	
	/**
	 * Construct a square from a GeometricalForm, 
	 * a side length and a color.
	 * 
	 * @param f Form with coordinates for the square.
	 * @param side The length of each side.
	 * @param c The color of the square.
	 */
	public Square( GeometricalForm f, int side, Color c ) {
		  
	}
	
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
