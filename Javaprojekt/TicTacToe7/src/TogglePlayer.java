import javax.swing.JButton;

public class TogglePlayer {

	// method that shifts between X and O for every turn and returns a String value
	public String switchPlayer(String player, JButton[][] gameBoard, boolean winner) {
		// parent class creating objects of the child classes Player1 and Player2
		AbstractPlayer players = new Player();


		if (player == players.player1) {
			player = players.player2;
		} else {
			player = players.player1;
		}

		return player;
	}

}
