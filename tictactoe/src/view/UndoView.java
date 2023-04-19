package view;

import javax.swing.JButton;

public class UndoView {
    // creates a JButton for the undo functionality
	private JButton undoMove;
	
	public UndoView(JButton undoButton) {
		this.undoMove = undoButton;
	}

	public JButton getUndoMove() {
		return undoMove;
	}

	public void setUndoMove(JButton undoMove) {
		this.undoMove = undoMove;
	}
	
	public void disableUndo() {
		this.undoMove.setEnabled(false);
	}
	
	public void enableUndo() {
		this.undoMove.setEnabled(true);
	}
	
	public boolean buttonState() {
		return this.undoMove.isEnabled();
	}
}
