package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import model.RowGameModel;
import controller.RowGameController;

/**
 * The RowGameGUI class is applying the Composite design pattern.
 * This class is the Composite. The class also is-a Component (i.e. View).
 */
public class RowGameGUI implements View {
    public JFrame gui = new JFrame("Tic Tac Toe");
    public RowGameModel gameModel = new RowGameModel();
    private GameBoardView gameBoardView;
    /** For the Composite design pattern, the RowGameGUI is the Composite */
    private List<View> viewList = new ArrayList<View>();
    public JButton reset = new JButton("Reset");
    
    // creates a JButton for the undo functionality
    public JButton undoMove = new JButton("Undo");


    /**
     * Creates a new game initializing the GUI.
     */
    public RowGameGUI(RowGameController controller) {
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);

        JPanel gamePanel = new JPanel(new FlowLayout());
        JPanel game = new JPanel(new GridLayout(3,3));
        gamePanel.add(game, BorderLayout.CENTER);

        JPanel options = new JPanel(new FlowLayout());
        // The undo button is initially disabled
        undoMove.setEnabled(false);
        options.add(undoMove);
        options.add(reset);
        JPanel messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);

        gui.add(gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);

		GameStatusView gameStatusView = new GameStatusView(messages);
		addView(gameStatusView);
		
		/* Click listener for undo */
		undoMove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.undoPlayerMove();
            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.resetGame();
            }
        });

		this.gameBoardView = new GameBoardView(game, controller);
		addView(this.gameBoardView);
    }

    public BlockIndex getBlockIndex(JButton block) {
	return this.gameBoardView.getBlockIndex(block);
    }

    public void addView(View view) {
	// For the Composite API
	
	// Perform input validation
	if (view == null) {
	    throw new IllegalArgumentException("The view must be non-null.");
	}

	this.viewList.add(view);
    }

    public void update(RowGameModel model) {
	// For the Composite API
	
	for (View currentView : this.viewList) {
	    currentView.update(model);
	} // end for currentView
    }
}
