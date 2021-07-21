import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

// GUI extends JFrame
public class GUI extends JFrame {
	// container that holds the ContentPane
	private Container pane;
	private String player;
	private JButton[][] gameBoard;
	private boolean winner;
	private JMenuBar menuBar;
	private JMenuItem startNewGame;
	private JMenuItem exitGame;
	private JMenuItem rulesForGame;
	private JMenuItem gameScore;
	// the parent class AbstractPlayer creates objects of the child classes Player1
	// and Player2
	AbstractPlayer players = new Player();
	// creating object of Winner
	Winner toggle = new Winner();
	// creating object of PlayerMachine
	TogglePlayer machine = new TogglePlayer();

	// GUI constructor
	public GUI() {
		// calling the parent class with the keyword super
		super();
		pane = getContentPane();
		pane.setLayout(new GridLayout(3, 3));
		setTitle("TIC TAC TOE - THREE IN A ROW");
		setSize(450, 450);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setBoard(new JButton[3][3]);
		winner = false;
		// calls the methods createBoard and createMenuBar
		createBoard();
		createMenuBar();
	}

	// creates a JMenuBar containing a JMenuItem
	private void createMenuBar() {
		menuBar = new JMenuBar();
		// JMenuItem for restarting the board
		startNewGame = new JMenuItem("New Game");
		startNewGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// calling the resetBoard method from Winner that resets the board and gives the
				// return value of the boolean to winner boolean
				winner = toggle.resetBoard(player, winner, getBoard());
				System.out.println("new game  " + winner);
			}
		});
		// JMenuItem for exiting the game
		exitGame = new JMenuItem("Quit Game");
		exitGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// JMenuItem for the rules of the game
		rulesForGame = new JMenuItem("Rules");
		rulesForGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// message dialog containing rules and explanation
				JOptionPane.showMessageDialog(null,
						"Rules For The Game \n \n" + "To win you have to get three in a row.\n"
								+ "You win if you fill the board Vertically, Horizontally or Diagonally. \n"
								+ "For every win you will get one point.\n"
								+ "The loser of the round begins the next round.");

			}
		});
		// JMenuItem for the counter that keeps the score
		gameScore = new JMenuItem("Score");
		gameScore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// message dialog that contains the current score
				JOptionPane.showMessageDialog(null,
						"Player O: " + players.getPlayerOneScore() + "\nPlayer X: " + players.getPlayerTwoScore());

			}
		});

		// adds all the menu items to the menuBar
		menuBar.add(startNewGame);
		menuBar.add(exitGame);
		menuBar.add(rulesForGame);
		menuBar.add(gameScore);
		setJMenuBar(menuBar);
	}

	// method with a nested for-loop that creates a playing field containing 3x3
	// buttons
	private void createBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton button = new JButton();
				button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 80));
				button.setBackground(Color.black);
				button.setForeground(Color.red);
				setLocationRelativeTo(null);
				// the board gets the button values
				getBoard()[i][j] = button;
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						// giving the return value of the method Score in the Winner class to the winner
						// boolean
						// this method call is making sure that we don't play if someone has won the round
						winner = toggle.score(getBoard(), player, winner);
						System.out.println("toggle  " + winner);
						// getSource returns the click and checks who made the click
						// testing if it's an empty string in order to check if the next move is valid
						if (((JButton) e.getSource()).getText().equals("") && winner == false) {

							// giving the return value of the method machine to the player string
							player = machine.switchPlayer(player, gameBoard, winner);
							// setting the value of the player string to the JButton
							button.setText(player);

							// calling the method that calculates the score and gives it to player1 and player2
							players.scoreCounter(getBoard(), player, winner);
						}

					}
				});
				// adding buttons to the pane
				pane.add(button);
			}
		}
	}

	// setters and getters for the value of the board
	public JButton[][] getBoard() {
		return gameBoard;
	}

	public void setBoard(JButton[][] board) {
		this.gameBoard = board;
	}
}
