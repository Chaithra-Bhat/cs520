package controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import model.UndoHistory;
import model.Player;
import view.BlockIndex;
import view.RowGameGUI;
import view.UndoView;

public class RowGameController {
    public RowGameModel gameModel;
    public RowGameGUI gameView;
    UndoHistory undoMove = new UndoHistory();

    /**
     * Creates a new game initializing the GUI.
     */
    public RowGameController() {
	gameModel = new RowGameModel();
	gameView = new RowGameGUI(this);

        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
		        gameModel.blocksData[row][column].setContents("");
		        gameModel.blocksData[row][column].setIsLegalMove(true);
            }
        }

	gameView.update(gameModel);
    }

    /**
     * Moves the current player into the given block.
     *
     * @param block The block to be moved to by the current player
     */
    public void move(JButton block) {
	// The Controller first manipulates the Model.
	gameModel.movesLeft--;
	gameView.undoView.enableUndo();

	BlockIndex blockIndex = gameView.getBlockIndex(block);
	if(gameModel.getPlayer().equals(Player.PLAYER_1)) {
	    // Check whether player 1 won
	    if(blockIndex.matches(0, 0)) {
		gameModel.blocksData[0][0].setContents("X");
		undoMove.pushToStack(new int[]{0, 0, 1});
		gameModel.blocksData[0][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(0, 1)) {
		gameModel.blocksData[0][1].setContents("X");
		undoMove.pushToStack(new int[]{0, 1, 1});
		gameModel.blocksData[0][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
		} else if(blockIndex.matches(0, 2)) {
		gameModel.blocksData[0][2].setContents("X");
		undoMove.pushToStack(new int[]{0, 2, 1});
		gameModel.blocksData[0][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(1, 0)) {
		gameModel.blocksData[1][0].setContents("X");
		undoMove.pushToStack(new int[]{1, 0, 1});
		gameModel.blocksData[1][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(1, 1)) {
		gameModel.blocksData[1][1].setContents("X");
		undoMove.pushToStack(new int[]{1, 1, 1});
		gameModel.blocksData[1][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(1, 2)) {
		gameModel.blocksData[1][2].setContents("X");
		undoMove.pushToStack(new int[]{1, 2, 1});
		gameModel.blocksData[1][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(2, 0)) {
		gameModel.blocksData[2][0].setContents("X");
		undoMove.pushToStack(new int[]{2, 0, 1});
		gameModel.blocksData[2][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(2, 1)) {
		gameModel.blocksData[2][1].setContents("X");
		undoMove.pushToStack(new int[]{2, 1, 1});
		gameModel.blocksData[2][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(2, 2)) {
		gameModel.blocksData[2][2].setContents("X");
		undoMove.pushToStack(new int[]{2, 2, 1});
		gameModel.blocksData[2][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_2);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_1 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    }
	} else {
	    // Check whether player 2 won
	    if(blockIndex.matches(0, 0)) {
		gameModel.blocksData[0][0].setContents("O");
		undoMove.pushToStack(new int[]{0, 0, 2});
		gameModel.blocksData[0][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(0, 1)) {
		gameModel.blocksData[0][1].setContents("O");
		undoMove.pushToStack(new int[]{0, 1, 2});
		gameModel.blocksData[0][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(0, 2)) {
		gameModel.blocksData[0][2].setContents("O");
		undoMove.pushToStack(new int[]{0, 2, 2});
		gameModel.blocksData[0][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(1, 0)) {
		gameModel.blocksData[1][0].setContents("O");
		undoMove.pushToStack(new int[]{1, 0, 2});
		gameModel.blocksData[1][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(1, 1)) {
		gameModel.blocksData[1][1].setContents("O");
		undoMove.pushToStack(new int[]{1, 1, 2});
		gameModel.blocksData[1][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(1, 2)) {
		gameModel.blocksData[1][2].setContents("O");
		undoMove.pushToStack(new int[]{1, 2, 2});
		gameModel.blocksData[1][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(2, 0)) {
		gameModel.blocksData[2][0].setContents("O");
		undoMove.pushToStack(new int[]{2, 0, 2});
		gameModel.blocksData[2][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(2, 1)) {
		gameModel.blocksData[2][1].setContents("O");
		undoMove.pushToStack(new int[]{2, 1, 2});
		gameModel.blocksData[2][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    } else if(blockIndex.matches(2, 2)) {
		gameModel.blocksData[2][2].setContents("O");
		undoMove.pushToStack(new int[]{2, 2, 2});
		gameModel.blocksData[2][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER_1);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
			gameModel.setFinalResult("Player " + Player.PLAYER_2 + " wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.undoView.disableUndo();
		    }
		}
	    }
	}

	// The Controller then updates the View.
	gameView.update(gameModel);
    }

    /**
     * Ends the game disallowing further player turns.
     */
    public void endGame() {
	// The Controller first manipulates the Model.
	for(int row = 0;row<3;row++) {
	    for(int column = 0;column<3;column++) {
		gameModel.blocksData[row][column].setIsLegalMove(false);
	    }
	}
	
	gameView.undoView.disableUndo();
	// The Controller then updates the View.
	gameView.update(gameModel);
    }

    /**
     * Resets the game to be able to start playing again.
     */
    public void resetGame() {
    	undoMove.clearStack();
	// The Controller first manipulates the Model.
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                gameModel.blocksData[row][column].reset();
                gameModel.blocksData[row][column].setIsLegalMove(true);
            }
        }
        gameModel.setPlayer(Player.PLAYER_1);
        gameModel.movesLeft = 9;
		gameModel.setFinalResult(null);
	
		// The Controller then updates the View.
		gameView.update(gameModel);
    }
    
    /**
     * Undo the previous move of the player who played their turn
     */
    public void undoPlayerMove() {
    	// Here the Controller manipulates the Model first and then the View
    	if(!undoMove.isStackEmpty()) {
    		if(gameModel.getPlayer().equals(Player.PLAYER_1)) {
    			if(undoMove.stackPeek()[2] == 2) {
    				int[] cell = undoMove.popFromStack();
    				gameModel.blocksData[cell[0]][cell[1]].setContents("");
    				gameModel.blocksData[cell[0]][cell[1]].setIsLegalMove(true);
    				gameModel.movesLeft++;
    				gameModel.setPlayer(Player.PLAYER_2);
    				gameView.undoView.disableUndo();
    				gameView.update(gameModel);
    			}
    			else {
    				System.out.println("Not played a move in this turn. Undo not allowed");
    			}
    		}
    		else {
    			if(undoMove.stackPeek()[2] == 1) {
    				int[] cell = undoMove.popFromStack();
    				gameModel.blocksData[cell[0]][cell[1]].setContents("");
    				gameModel.blocksData[cell[0]][cell[1]].setIsLegalMove(true);
    				gameModel.movesLeft++;
    				gameModel.setPlayer(Player.PLAYER_1);
    				gameView.undoView.disableUndo();
    				gameView.update(gameModel);
    			}
    			else {
    				System.out.println("Not played a move in this turn. Undo not allowed");
    			}
    		}
    	}
    }
}
