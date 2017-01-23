import java.util.Scanner;
import javax.swing.JOptionPane;

public class GameOfPig {
	// Declare Attributes - is this any better than using variables?
	private static int playerScore = 0;
	private static int turnValue = 0;
	private static int cpuScore = 0;
	private static boolean playersTurn = true;
	private static int firstDie = 0;
	private static int secondDie = 0;

	public static void main(String[] args) {

		while (playerScore < 100 && cpuScore < 100) {
			if (playersTurn) {
				if (!playerFirstChoice())//returns false if player wants to quit game
					break;
				displayScore();
				if (playersTurn){
					if (!playerSecondChoice())
						break;
				}
				playerScoreKeep(firstDie, secondDie);
				JOptionPane.showMessageDialog(null,"CPU - " + cpuScore + " | You - " + playerScore);
			} else {

			}
		}
	}
	
	private static void displayScore(){
		JOptionPane.showMessageDialog(null,"CPU - " + cpuScore + " | You - " + playerScore + "\nYour score for this hand (not yet added to total score) is " + (turnValue + firstDie));
		
	}

	private static void playerScoreKeep(int first, int second){
		if (first == 1 && second == 1){
			playerScore = 0;
			playersTurn = false;
			return;
		}
		if (first ==1 || second == 1){
			playersTurn = false;
			return;
		}
		if (first != second){
			turnValue = turnValue + first + second;
			return;
		}
		firstDie = 0; 
		secondDie = 0;
	}
	private static void cpuScoreKeep(int first, int second){
		if (first == 1 && second == 1){
			cpuScore = 0;
			playersTurn = true;
			return;
		}
		if (first ==1 || second == 1){
			playersTurn = true;
			return;
		}
		if (first != second){
			turnValue = turnValue + first + second;
			return;
		}
	}

	private static int rollDie() {
		int rand = (int) (Math.random() * 6) + 1;
		JOptionPane.showMessageDialog(null, "You have rolled a " + rand);
		return rand;
	}

	private static boolean playerFirstChoice() {
		Object[] options = { "Roll the Die!", "Finish Turn (Hold)", "Quit Game" };

		int n = JOptionPane.showOptionDialog(null, "It is your turn, would you like to roll your first die?", "Roll 1",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (n == JOptionPane.CLOSED_OPTION)
			return false;
		else {
			if (n == 0)
				firstDie = rollDie();
			else { // n ==1
				//playerScore = playerScore + turnValue;
				playersTurn = false;
			}
		}
		return true;
	}

	private static boolean playerSecondChoice() {
		Object[] options = { "Roll the Die!", "Finish Turn (Hold)", "Quit Game" };

		int n = JOptionPane.showOptionDialog(null,
				"You just rolled a " + firstDie + " would you like to roll your second die?", "Roll 2",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (n == JOptionPane.CLOSED_OPTION)
			return false;
		else {
			if (n == 0)
				secondDie = rollDie();
			else { // n ==1
				//playerScore = playerScore + turnValue;
				playersTurn = false;
				
			}
		}
		return true;
	}
	// note that closing the pop-up and hitting 'Quit Game' do the same thing.
}
