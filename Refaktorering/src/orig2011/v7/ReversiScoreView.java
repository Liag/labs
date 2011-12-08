package orig2011.v7;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReversiScoreView implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if ( evt.getSource() instanceof ReversiModel ) {			
			if ( evt.getPropertyName() == "turned") {
				ReversiModel reversi = (ReversiModel) evt.getSource();
				
				System.out.println( "Blackscore: " + reversi.getBlackScore() + 
						" Whitescore: " + reversi.getWhiteScore() );
				System.out.println( "This turn: " + reversi.getTurnColor() );
			}
		}
	}

}
