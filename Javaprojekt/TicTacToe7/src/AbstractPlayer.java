import javax.swing.JButton;

public abstract class AbstractPlayer {
	// declaring a String and an integer
	public String player1;
	public String player2;
	// declaring player1 and 2 scores for the game.
	public static int playerOneScore;
	public static int playerTwoScore;
	
	// setters and getters player 1 and 2 score variables
	public static int getPlayerTwoScore() {
		return playerTwoScore;
	}

	public static void setPlayerTwoScore(int playerTwoScore) {
		AbstractPlayer.playerTwoScore = playerTwoScore;
	}

	public static int getPlayerOneScore() {
		return playerOneScore;
	}

	public static void setPlayerOneScore(int playerOneScore) {
		AbstractPlayer.playerOneScore = playerOneScore;
	}
	
	
	// abstract method for the scoreCounter method
	public abstract void scoreCounter(JButton [][] gameBoard, String player, boolean winner);
	
}
