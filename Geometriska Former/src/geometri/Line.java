package geometri;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends GeometricalShape{

	/** Ending point of line (x2, y2) */
	private int x2;
	private int y2;

	/** The inclination of the line */
	private double inclination;
	
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
		super(x1, y1, c);
		this.x2 = x2;
		this.y2 = y2;
		this.inclination = ( ( this.y2 - super.getY() ) / ( this.x2 - super.getX() ) );
	}
	  
	/**
	 * Construct a line from two GeometricalForms and a color. 
	 * 
	 * @param f1 Form with coordinates for first position.
	 * @param f2 Form with coordinates for second position.
	 * @param c The color of the line.
	 */
	public Line( GeometricalForm f1, GeometricalForm f2, Color c ) {
		  super(f1, c);
		  this.x2 = f2.getX();
		  this.y2 = f2.getY();
		  this.inclination = ( ( this.y2 - super.getY() ) / ( this.x2 - super.getX() ) );
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
		g.setColor( super.getColor() );
		g.drawLine( super.getX(), super.getY(), x2, y2 );
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
		// TODO Auto-generated method stub
		super.move(dx, dy);
		this.x2 += dx;
		this.y2 += dy;
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		int xDiff = this.x2 - super.getX();
		int yDiff = this.y2 - super.getY();
		
		int sideLength =  (int) Math.round( Math.sqrt( Math.pow(xDiff, 2) + Math.pow(yDiff, 2) ) );
		
		return sideLength;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) inclination;
		result = prime * result + x2;
		result = prime * result + y2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (inclination != other.inclination)
			return false;
		if (x2 != other.x2)
			return false;
		if (y2 != other.y2)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "X1: " + super.getX() + " Y1: " + super.getY() + " X2: " + x2 + " Y2: " + y2;
	}

}
