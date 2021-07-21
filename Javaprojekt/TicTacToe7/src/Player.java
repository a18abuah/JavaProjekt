import javax.swing.JButton;

// PlayerOne extends from its parent class AbstractPlayer
public class Player extends AbstractPlayer {
	Winner gameScore = new Winner();
	


	// constructor for PlayerOne
	public Player() {
		// PlayerOne gets the name of X
		player1 = "O";
		player2 = "X";

	}

	// method that returns an integer of the score from PlayerOne
	public void scoreCounter(JButton[][] gameBoard, String player, boolean winner) {
		// creating an object of Winner
		
		winner = gameScore.score(gameBoard, player, winner);
		
		setPlayerOneScore(gameScore.getPlayerOneInteger()  );
		setPlayerTwoScore(gameScore.getPlayerTwoInteger()  );
		
		System.out.println("score1: " + getPlayerOneScore() + "score2:" + getPlayerTwoScore());
		
	}
	
}
