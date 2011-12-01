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
		super(x, y, c);
		// if any coordinate is negative
		this.side = side;
		  
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
		  super(f, c);
		  this.side = side;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int area() {
		return ( side * side );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor( super.getColor() );
		g.fillRect( super.getX(), super.getY(), side, side );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int perimeter() {
		return ( 4 * side );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + side;
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
		Square other = (Square) obj;
		if (side != other.side)
			return false;
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + " Side: " + side;
	}

}
