package view;

import javax.swing.JButton;

public class UndoView {
    // creates a JButton for the undo functionality
	private JButton undoMove;
	
	// Constructor
	public UndoView(JButton undoButton) {
		this.undoMove = undoButton;
	}

	// Getter for undo button
	public JButton getUndoMove() {
		return undoMove;
	}

	// Setter for undo button
	public void setUndoMove(JButton undoMove) {
		this.undoMove = undoMove;
	}
	
	// Method to disable the undo button
	public void disableUndo() {
		this.undoMove.setEnabled(false);
	}
	
	// Method to enable the undo button
	public void enableUndo() {
		this.undoMove.setEnabled(true);
	}
	
	// Method that returns the value of whether the undo button is enabled or not
	public boolean buttonState() {
		return this.undoMove.isEnabled();
	}
}
