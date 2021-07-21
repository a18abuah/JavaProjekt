import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Winner {

	
	private int playerOneInteger;
	private int playerTwoInteger;

	// calculates the winner of every round
	// method that checks for every possible combination on the board
	public boolean score(JButton[][] gameBoard, String player, boolean winner) {
		// if getText is equal to the current player
		// also comparing indexes
		if (gameBoard[0][0].getText().equals(player) && gameBoard[1][0].getText().equals(player)
				&& gameBoard[2][0].getText().equals(player)) {
			JOptionPane.showMessageDialog(null, "Player " + player + " has won this round");
			playerIntCalculator( player,  winner);
			winner = true;
			

		} else if (gameBoard[0][1].getText().equals(player) && gameBoard[1][1].getText().equals(player)
				&& gameBoard[2][1].getText().equals(player)) {
			JOptionPane.showMessageDialog(null, "Player " + player + " has won this round");
			playerIntCalculator( player,  winner);
			winner = true;
		

		} else if (gameBoard[0][2].getText().equals(player) && gameBoard[1][2].getText().equals(player)
				&& gameBoard[2][2].getText().equals(player)) {
			JOptionPane.showMessageDialog(null, "Player " + player + " has won this round");
			playerIntCalculator( player,  winner);
			winner = true;
			

		} else if (gameBoard[0][0].getText().equals(player) && gameBoard[0][1].getText().equals(player)
				&& gameBoard[0][2].getText().equals(player)) {
			JOptionPane.showMessageDialog(null, "Player " + player + " has won this round");
			playerIntCalculator( player,  winner);
			winner = true;
			
		} else if (gameBoard[1][0].getText().equals(player) && gameBoard[1][1].getText().equals(player)
				&& gameBoard[1][2].getText().equals(player)) {
			JOptionPane.showMessageDialog(null, "Player " + player + " has won this round");
			playerIntCalculator( player,  winner);
			winner = true;
			

		} else if (gameBoard[2][0].getText().equals(player) && gameBoard[2][1].getText().equals(player)
				&& gameBoard[2][2].getText().equals(player)) {
			JOptionPane.showMessageDialog(null, "Player " + player + " has won this round");
			playerIntCalculator( player,  winner);
			winner = true;
			

		} else if (gameBoard[0][0].getText().equals(player) && gameBoard[1][1].getText().equals(player)
				&& gameBoard[2][2].getText().equals(player)) {
			JOptionPane.showMessageDialog(null, "Player " + player + " has won this round");
			playerIntCalculator( player,  winner);
			winner = true;
			
			
		} else if (gameBoard[0][2].getText().equals(player) && gameBoard[1][1].getText().equals(player)
				&& gameBoard[2][0].getText().equals(player)) {
			JOptionPane.showMessageDialog(null, "Player " + player + " has won this round");
			playerIntCalculator( player,  winner);
			winner = true;
			
		}	
		System.out.println("Playerone"+getPlayerOneInteger());

		return winner;

	}

	// method that resets the board when a player wants to play again or start over
	public boolean resetBoard(String player, boolean winner, JButton[][] gameBoard) {
		player = "X";
		winner = false;
		// nested for-loop that clears the board with the use of an empty value
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j].setText("");
			}
		}
		return winner;
	}
	
	public void playerIntCalculator(String player, boolean winner) {
		// if player is O give one point to player 1
		if (player == "O") {
			playerOneInteger++;
		}
		// if player is X give one point to player 2
		else if (player == "X" ) {
			playerTwoInteger++;
		}
	}

// setters and getters for the score of the game for player 1 and player 2.
	public int getPlayerOneInteger() {
		return playerOneInteger;
	}

	public void setPlayerOneInteger(int playerOneInteger) {
		this.playerOneInteger = playerOneInteger;
	}

	public int getPlayerTwoInteger() {
		return playerTwoInteger;
	}

	public void setPlayerTwoInteger(int playerTwoInteger) {
		this.playerTwoInteger = playerTwoInteger;
	}

}
