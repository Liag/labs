package orig2011.v2;

import java.awt.Dimension;
import orig2011.v0.*;

/**
 * Common superclass for all game model classes.
 * 
 * Constructors of subclasses should initiate matrix elements and additional,
 * game-dependent fields.
 */
public class GameUtils {

	/** The size of the state matrix. */
	//private final Dimension gameboardSize = Constants.getGameSize();

	/**
	 * Create a new game model. As GameModel is an abstract class, this is only
	 * intended for subclasses.
	 */
	/*protected GameUtils() {
		this.gameboardState =
				new GameTile[this.gameboardSize.width][this.gameboardSize.height];
	}*/

	/**
	 * Returns the size of the gameboard.
	 */
	public Dimension getGameboardSize() {
		return Constants.getGameSize();
	}
}
