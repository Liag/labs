package orig2011.v3;


import orig2011.v0.Position;

// The dummy declaration below is not needed anymore since we have generalized
// the class to work for any reference type, not just GameTile.
// class GameTile {
//     dummy implementation to remove compile errors in this file
// }

public enum GameUtils {
	 // Enforce the singleton property by constructing an enum without
	// members. See Joshua Bloch's Effective Java, 2nd ed, item 3. 
	; // Marks end of enum members. 

	// 
	/*public static <T> T[][] newBoard(T baseTile, final int width, final int height) {
		// Generic array creation is somewhat tricky in Java.
		// See item 25 in Effective Java, 2nd ed.
		@SuppressWarnings("unchecked")
		T[][] a = (T[][]) java.lang.reflect.Array.
				newInstance(baseTile.getClass(), width, height);
		// Note that T[][] a = (T[][]) new Object[width][height] fails at
		// runtime for many cases.
		
		fillBoard(a, baseTile);
		
		return a;
	}*/
	
	public static <T> void fillBoard(final T[][] board,
			final T baseTile) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = baseTile;
			}
		}
	}
	
	public static void setGameboardState(final Position pos, final GameTile tile, 
			GameTile[][] tiles) {
		tiles[pos.getX()][pos.getY()] = tile;		
	}
	
	public static void setGameboardState(final int x, final int y,
			final GameTile tile, GameTile[][] tiles) {
		tiles[x][y] = tile;
		
	}

}