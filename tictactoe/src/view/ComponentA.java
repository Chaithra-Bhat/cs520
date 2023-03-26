package view;

import javax.swing.JButton;

import model.RowGameModel;

public class ComponentA implements View {
	public JButton[][] blocks = null;
	
	public ComponentA(JButton[][] gameBlocks) {
		blocks = gameBlocks;
	}

	@Override
	public void update(RowGameModel model) {
		// TODO Auto-generated method stub
		int row = model.getUpdatedBlockRowNum();
		int column = model.getUpdatedBlockColNum();
		blocks[row][column].setText(model.blocksData[row][column].getContents());
		blocks[row][column].setEnabled(model.blocksData[row][column].getIsLegalMove());
	}

}
