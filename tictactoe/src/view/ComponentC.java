package view;

import javax.swing.JTextArea;

import model.RowGameModel;

public class ComponentC implements View {
	public JTextArea playerturn = null;
	
	public ComponentC(JTextArea everyplayerturn) {
		playerturn = everyplayerturn;
	}

	@Override
	public void update(RowGameModel model) {
		// TODO Auto-generated method stub
		String statusText = model.getPlayerStatusText();
		playerturn.setText(statusText);
	}

}
