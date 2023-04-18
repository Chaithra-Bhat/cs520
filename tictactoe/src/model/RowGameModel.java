package model;
import java.util.Stack;


public class RowGameModel 
{
    public static final String GAME_END_NOWINNER = "Game ends in a draw";

    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];

    /**
     * The current player taking their turn
     */
    private Player player = Player.PLAYER_1;
    public int movesLeft = 9;

    private String finalResult = null;
    
    // initialize a stack to store the undo history
    private Stack<int[]> undoStack = new Stack<int[]>();


    public RowGameModel() {
	super();

	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
		blocksData[row][col] = new RowBlockModel(this);
	    } // end for col
	} // end for row
    }

    public Player getPlayer() {
	return this.player;
    }

    public void setPlayer(Player player) {
	// Perform input validation
	if (player == null) {
	    throw new IllegalArgumentException("The player must be non-null.");
	}

	this.player = player;
    }
    
    public String getFinalResult() {
	return this.finalResult;
    }

    public void setFinalResult(String finalResult) {
	this.finalResult = finalResult;
    }
    
    // check if stack is empty
    public boolean isStackEmpty() {
    	return this.undoStack.isEmpty();
    }
    
    // return the top element of the stack
    public int[] stackPeek() {
    	return this.undoStack.peek();
    }
    
    // empty stack
    public void clearStack() {
    	this.undoStack.clear();
    }
	
    // push an array to the stack
	public void pushToStack(int[] cell) {
		this.undoStack.push(cell);
	}
	
	// pop the topmost array from the stack
	public int[] popFromStack() {
		return this.undoStack.pop();
	}
	
}
