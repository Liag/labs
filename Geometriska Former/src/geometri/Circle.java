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
		 super(x, y, c);
		 this.radius = radius;
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
		  super(f, c);
		  this.radius = radius;
	 }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int area() {
		return ( (int) ( Math.round( (radius * radius) * Math.PI )));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor( super.getColor() );
		g.fillOval( super.getX(), super.getY(), ( radius * 2 ) , ( radius * 2 ) );

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int perimeter() {
		return ( (int) ( Math.round( (2 * radius) * Math.PI )));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + radius;
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
		    return false;
		Circle other = (Circle) obj;
		if (radius != other.radius)
			return false;
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + " Radius: " + radius;
	}
}
