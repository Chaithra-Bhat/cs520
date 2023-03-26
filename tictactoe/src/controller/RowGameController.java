package controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import model.RowGameModel.PlayerField;
import view.RowGameGUI;

public class RowGameController {
    public RowGameModel gameModel;
    public RowGameGUI gameView;
    public boolean moveMade = true;
    public boolean gameEnded = false;

    /**
     * Creates a new game initializing the GUI.
     */
    public RowGameController() {
	gameModel = new RowGameModel();
	gameView = new RowGameGUI(this);
	gameModel.setPlayerStatusText("Player 1 to play 'X'");
	gameModel.setUpdateType("StatusText");
	gameView.update(gameModel);

        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
		        gameModel.blocksData[row][column].setContents("");
				gameModel.blocksData[row][column].setIsLegalMove(true);
				gameModel.setUpdatedBlockRowNum(row);
				gameModel.setUpdatedBlockColNum(column);
				gameModel.setUpdateType("GameBlock");
				gameView.update(gameModel);
            }
        }
    }

    /**
     * Moves the current player into the given block.
     *
     * @param block The block to be moved to by the current player
     */
    public void move(JButton block) {
	if(gameModel.getPlayer().equals(PlayerField.PLAYER_1)) {
	    // Check whether player 1 won
	    if(block==gameView.blocks[0][0]) {
	    	if(gameModel.blocksData[0][0].getContents().isEmpty()) {
	    		gameModel.blocksData[0][0].setContents("X");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(0);
	    		gameModel.setUpdatedBlockColNum(0);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_2);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
	    			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
	    		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
	    			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
	    		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
	    			gameModel.setFinalResult("Player 1 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    				gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    				gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[0][1]) {
	    	if(gameModel.blocksData[0][1].getContents().isEmpty()) {
	    		gameModel.blocksData[0][1].setContents("X");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(0);
	    		gameModel.setUpdatedBlockColNum(1);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_2);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
	    			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
	    		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
	    			gameModel.setFinalResult("Player 1 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[0][2]) {
	    	if(gameModel.blocksData[0][2].getContents().isEmpty()) {
	    		gameModel.blocksData[0][2].setContents("X");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(0);
	    		gameModel.setUpdatedBlockColNum(2);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_2);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
	    			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
	    		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
	    			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
	    		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
	    			gameModel.setFinalResult("Player 1 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[1][0]) {
	    	if(gameModel.blocksData[1][0].getContents().isEmpty()) {
	    		gameModel.blocksData[1][0].setContents("X");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(1);
	    		gameModel.setUpdatedBlockColNum(0);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_2);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
	    		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
	    			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
	    			gameModel.setFinalResult("Player 1 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[1][1]) {
	    	if(gameModel.blocksData[1][1].getContents().isEmpty()) {
	    		gameModel.blocksData[1][1].setContents("X");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(1);
	    		gameModel.setUpdatedBlockColNum(1);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_2);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
	    			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
	    		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
	    			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
	    		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
	    			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
	    		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
	    			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
	    			gameModel.setFinalResult("Player 1 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[1][2]) {
	    	if(gameModel.blocksData[1][2].getContents().isEmpty()) {
	    		gameModel.blocksData[1][2].setContents("X");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(1);
	    		gameModel.setUpdatedBlockColNum(2);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_2);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
	    			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
	    		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
	    			gameModel.setFinalResult("Player 1 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[2][0]) {
	    	if(gameModel.blocksData[2][0].getContents().isEmpty()) {
	    		gameModel.blocksData[2][0].setContents("X");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(2);
	    		gameModel.setUpdatedBlockColNum(0);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_2);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
	    			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
	    		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
	    			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
	    		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
	    			gameModel.setFinalResult("Player 1 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[2][1]) {
	    	if(gameModel.blocksData[2][1].getContents().isEmpty()) {
	    		gameModel.blocksData[2][1].setContents("X");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(2);
	    		gameModel.setUpdatedBlockColNum(1);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_2);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
	    			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
	    		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
	    			gameModel.setFinalResult("Player 1 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[2][2]) {
	    	if(gameModel.blocksData[2][2].getContents().isEmpty()) {
	    		gameModel.blocksData[2][2].setContents("X");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(2);
	    		gameModel.setUpdatedBlockColNum(2);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_2);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
	    			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
	    		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
	    			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
	    		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
	    			gameModel.setFinalResult("Player 1 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    }
	} else {
	    // Check whether player 2 won
	    if(block==gameView.blocks[0][0]) {
	    	if(gameModel.blocksData[0][0].getContents().isEmpty()) {
	    		gameModel.blocksData[0][0].setContents("O");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(0);
	    		gameModel.setUpdatedBlockColNum(0);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_1);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
	    			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
	    		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
	    			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
	    		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
	    			gameModel.setFinalResult("Player 2 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[0][1]) {
	    	if(gameModel.blocksData[0][1].getContents().isEmpty()) {
	    		gameModel.blocksData[0][1].setContents("O");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(0);
	    		gameModel.setUpdatedBlockColNum(1);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_1);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
	    			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
	    		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
	    			gameModel.setFinalResult("Player 2 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[0][2]) {
	    	if(gameModel.blocksData[0][2].getContents().isEmpty()) {
	    		gameModel.blocksData[0][2].setContents("O");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(0);
	    		gameModel.setUpdatedBlockColNum(2);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_1);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
	    			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
	    		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
	    			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
	    		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
	    			gameModel.setFinalResult("Player 2 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[1][0]) {
	    	if(gameModel.blocksData[1][0].getContents().isEmpty()) {
	    		gameModel.blocksData[1][0].setContents("O");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(1);
	    		gameModel.setUpdatedBlockColNum(0);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_1);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
	    		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
	    			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
	    			gameModel.setFinalResult("Player 2 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[1][1]) {
	    	if(gameModel.blocksData[1][1].getContents().isEmpty()) {
	    		gameModel.blocksData[1][1].setContents("O");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(1);
	    		gameModel.setUpdatedBlockColNum(1);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_1);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
	    			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
	    		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
	    			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
	    		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
	    			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
	    		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
	    			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
	    			gameModel.setFinalResult("Player 2 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[1][2]) {
	    	if(gameModel.blocksData[1][2].getContents().isEmpty()) {
	    		gameModel.blocksData[1][2].setContents("O");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(1);
	    		gameModel.setUpdatedBlockColNum(2);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_1);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
	    			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
	    		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
	    			gameModel.setFinalResult("Player 2 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[2][0]) {
	    	if(gameModel.blocksData[2][0].getContents().isEmpty()) {
	    		gameModel.blocksData[2][0].setContents("O");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(2);
	    		gameModel.setUpdatedBlockColNum(0);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_1);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
	    			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
	    		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
	    			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
	    		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
	    			gameModel.setFinalResult("Player 2 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[2][1]) {
	    	if(gameModel.blocksData[2][1].getContents().isEmpty()) {
	    		gameModel.blocksData[2][1].setContents("O");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(2);
	    		gameModel.setUpdatedBlockColNum(1);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_1);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
	    			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
	    		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
	    			gameModel.setFinalResult("Player 2 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    } else if(block==gameView.blocks[2][2]) {
	    	if(gameModel.blocksData[2][2].getContents().isEmpty()) {
	    		gameModel.blocksData[2][2].setContents("O");
	    		moveMade = true;
	    		gameModel.setUpdatedBlockRowNum(2);
	    		gameModel.setUpdatedBlockColNum(2);
	    		gameModel.setUpdateType("GameBlock");
	    		gameView.update(gameModel);
	    		gameModel.setPlayer(PlayerField.PLAYER_1);
	    		if(gameModel.movesLeft<7) {
	    		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
	    			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
	    		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
	    			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
	    		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
	    			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
	    			gameModel.setFinalResult("Player 2 wins!");
	    			endGame();
	    		    } else if(gameModel.movesLeft==0) {
	    			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
	    			endGame();
	    		    }
	    		    if (gameModel.getFinalResult() != null) {
	    		    	gameModel.setPlayerStatusText(gameModel.getFinalResult());
	    		    	gameModel.setUpdateType("StatusText");
	    				gameView.update(gameModel);
	    		    }
	    		}
	    	}
	    }
	}
	if(moveMade && !gameEnded) {
		gameModel.movesLeft--;
		moveMade = false;
		if(gameModel.movesLeft%2 == 1) {
			gameModel.setPlayerStatusText("'O': Player 2");
			gameModel.setUpdateType("StatusText");
			gameView.update(gameModel);
		} else{
			gameModel.setPlayerStatusText("'X': Player 1");
			gameModel.setUpdateType("StatusText");
			gameView.update(gameModel);
		}
	}
    }

    /**
     * Ends the game disallowing further player turns.
     */
    public void endGame() {
    	gameEnded = true;
		for(int row = 0;row<3;row++) {
		    for(int column = 0;column<3;column++) {
			gameView.blocks[row][column].setEnabled(false);
		    }
		}
    }

    /**
     * Resets the game to be able to start playing again.
     */
    public void resetGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                gameModel.blocksData[row][column].reset();
		gameModel.blocksData[row][column].setIsLegalMove(true);
		gameModel.setUpdatedBlockRowNum(row);
		gameModel.setUpdatedBlockColNum(column);
		gameModel.setUpdateType("GameBlock");
		gameView.update(gameModel);
            }
        }
        gameModel.setPlayer(PlayerField.PLAYER_1);
        gameModel.movesLeft = 8;
        gameModel.setFinalResult(null);
        gameModel.setPlayerStatusText("Player 1 to play 'X'");
        gameModel.setUpdateType("StatusText");
		gameView.update(gameModel);
		gameEnded = false;
    }
}
