package lab1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class SnakeTile extends GameTile
{
	/** The color of the tile */
	private final Color strokeColor;
	private final Color fillColor;
	private final Stroke stroke;
	
	/**
	 * Creates a rectangular snake tile with a stroke around it.
	 * 
	 * @param strokeColor
	 *            the color of the stroke around the rectangle.
	 * @param fillColor
	 *            the color of the interior of the rectangle.
	 * @param thickness
	 *            the thickness of the stroke.
	 */
	public SnakeTile(final Color strokeColor, final Color fillColor,
			final double thickness) {
		this.strokeColor = strokeColor;
		this.fillColor = fillColor;
		this.stroke = new BasicStroke((float) thickness);
	}
	
	/**
	 * Draws itself in a given graphics context, position and size.
	 * 
	 * @param g
	 *            graphics context to draw on.
	 * @param x
	 *            pixel x coordinate of the tile to be drawn.
	 * @param y
	 *            pixel y coordinate of the tile to be drawn.
	 * @param d
	 *            size of this object in pixels.
	 */
	@Override
	public void draw(final Graphics g, final int x, final int y,
			final Dimension d) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.fillColor);
		double xOffset = (d.width) / 2.0;
		double yOffset = (d.height) / 2.0;
		g2.fillRect((int) (x), (int) (y),
				(int) (d.width),
				(int) (d.height));
		g2.setStroke(this.stroke);
		g2.setColor(this.strokeColor);

		
		g2.drawRect((int) (x), (int) (y), (int) (d.width), (int) (d.height));
	}

}
