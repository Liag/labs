package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends GeometricalShape{

	/** Ending point of line (x2, y2) */
	private int x2;
	private int y2;

	/** The inclination of the line, if negative then true */
	private boolean negativeInclination;
	
	/**
	 * Construct a line from two positions and a color. 
	 * 
	 * @param x1 Horizontal first position of the line.
	 * @param y1 Vertical first position of the line.
	 * @param x2 Horizontal second position of the line.
	 * @param y2 Vertical second position of the line.
	 * @param c The color of the line.
	 * @throws IllegalPositionException if any coordinate 
	 * 									is negative.
	 */
	public Line( int x1, int y1, int x2, int y2, Color c )
	           throws IllegalPositionException {
		super( Math.min(x1, x2), Math.min(y1, y2), c );
		
		// if any coordinate is negative
		if(Math.max(x1, x2) < 0 || Math.max(y1, y2) < 0) {
			throw new IllegalPositionException();
		}
		
		this.x2 = Math.max(x1, x2);
		this.y2 = Math.max(y1, y2);
		
		System.out.println(toString());
		// check if line's inclination is negative
		this.negativeInclination = ( (double) ( y1 - y2 ) / ( x2 - x1 ) ) < 0 ? true : false;
	}
	  
	/**
	 * Construct a line from two GeometricalForms and a color. 
	 * 
	 * @param f1 Form with coordinates for first position.
	 * @param f2 Form with coordinates for second position.
	 * @param c The color of the line.
	 * @throws IllegalPositionException 
	 */
	public Line( GeometricalForm f1, GeometricalForm f2, Color c ) throws IllegalPositionException {
		  super( Math.min( f1.getX(), f2.getX()), Math.min(f1.getY(), f2.getY()), c);
		  this.x2 = Math.max( f1.getX(), f2.getX() );
		  this.y2 = Math.max( f1.getY(), f2.getY() );
		
		  // check if line's inclination is negative
		  this.negativeInclination = ( ( this.y2 - super.getY() ) / ( this.x2 - super.getX() ) ) < 0 ? true : false;
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
		// If the lines inclination is negative
		if ( this.negativeInclination ) {
			g.drawLine( super.getX(), super.getY(), x2, y2 );
		} else {
			// if the lines inclination is positive
			g.drawLine( super.getX(), this.y2, x2, super.getY() );
		}
	}
	
	/**
    * Move the line the given distances. 
    * Both the start and ending point of the line will be moved.
    * Check if the new coordinates are legal and
    * if they are, set the position to the new coordinates.
    * Otherwise an <tt>IllegalPositionException</tt> is thrown.
    * Origo is (0,0) and only positive coordinates are legal.
    *
    * @param dx move the form dx points to the right.
    * @param dy move the form dy points down.
    * @throws IllegalPositionException if any coordinate
    *                                  becomes negative.
    */
	@Override
	public void move(int dx, int dy) throws IllegalPositionException {
		place(super.getX() + dx, super.getY() + dy);
		/*super.move(dx, dy);
		//this.x2 += dx;
		this.y2 += dy;*/
		
		// not needed?
		/*// if x2 or y2 is negative
		if(x2 < 0 || y2 < 0) {
			throw new IllegalPositionException();
		}*/
	}
	
   /**
    * Place the form on given coordinates.
    * The starting point will be set according to the parameters and
    * the ending point will be placed relative to this position.
    * Check if the coordinates are legal.
    * Origo is (0,0) and only positive
    * coordinates are legal.
    * If they are legal, update the position with the new coordinates.
    * Otherwise an <tt>IllegalPositionException</tt> is thrown.
    *
    * @param x Distance right from origo.
    * @param y Distance down from origo.
    * @throws <tt>IllegalPositionException</tt> if any coordinate
    *                                           is negative.
    */
	@Override
	public void place(int x, int y) throws IllegalPositionException {		
		int x1 = super.getX();
		int y1 = super.getY();
		
		int xDiff = x2 - x1;
		int yDiff = y2 - y1;
		
		super.place(x, y);
		this.x2 = super.getX() + xDiff;
		this.y2 = super.getY() + yDiff;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int perimeter() {
		int xDiff = this.x2 - super.getX();
		int yDiff = this.y2 - super.getY();
		// the lines length
		int lineLength =  (int) Math.round( Math.sqrt( Math.pow(xDiff, 2) + Math.pow(yDiff, 2) ) );
		
		return lineLength;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (negativeInclination ? 1231 : 1237);
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
		Line other = (Line) obj;
		if (negativeInclination != other.negativeInclination)
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + " X2: " + x2 + " Y2: " + y2;
	}

}
