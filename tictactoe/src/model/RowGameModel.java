package model;


public class RowGameModel 
{
    public static final String GAME_END_NOWINNER = "Game ends in a draw";

    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];

    /**
     * The current player taking their turn
     */
	// created an enumerator for player 1 and player 2
	public enum PlayerField {
		PLAYER_1, 
		PLAYER_2
	};
	
	// initialize value of private variable player to player 1
	private PlayerField player = PlayerField.PLAYER_1;

	// getter to access the private variable player
	public PlayerField getPlayer() {
		return player;
	}

	// setter to set the value of private variable player
	public void setPlayer(PlayerField player) {
		this.player = player;
	}

	public int movesLeft = 9;

    private String finalResult = null;


    public RowGameModel() {
	super();

	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
		blocksData[row][col] = new RowBlockModel(this);
	    } // end for col
	} // end for row
    }

    public String getFinalResult() {
	return this.finalResult;
    }

    public void setFinalResult(String finalResult) {
	this.finalResult = finalResult;
    }
}
