import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.JButton;

import model.Player;
import model.RowBlockModel;
import view.GameBoardView;
import view.RowGameGUI;
import controller.RowGameController;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {
    private RowGameController gameController;
    private RowGameGUI gameGUI;
    private JButton[][] gBlocks;
    private GameBoardView boardView;

    @Before
    public void setUp() {
		gameController = new RowGameController();
		gameGUI = gameController.getGameView();
		boardView = gameGUI.getGameBoardView();
    }

    @After
    public void tearDown() {
		gameController = null;
    }

    @Test
    public void testNewGame() {
        assertEquals (Player.PLAYER_1, gameController.gameModel.getPlayer());
        assertEquals (9, gameController.gameModel.movesLeft);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewBlockViolatesPrecondition() {
	RowBlockModel block = new RowBlockModel(null);
    }
    
    @Test
    public void testUndoInitial() {
    	// First checks if no moves have been made and then check if the button is disabled
    	 assertEquals(9, gameController.gameModel.movesLeft);
    	 assertEquals(false, gameGUI.undoView.buttonState());
    }
    
    @Test
    public void testUndoPermit() {
    	// First checks if the user has made a move and then checks if the button is enabled
        gBlocks = this.boardView.getBlock();
    	gameController.move(gBlocks[0][0]);
    	assertEquals(true, gameController.gameModel.movesLeft < 9);
    	assertEquals(true, gameGUI.undoView.buttonState());
    }
}
