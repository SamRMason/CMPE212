import javax.swing.JOptionPane;
import java.util.Scanner;

public class Pig {
	private static int claimedPlayerScore = 0;
	private static int claimedCPUScore = 0;
	private static int unclaimedScore = 0;
	private static boolean playerTurn = true;
	private static int rollValue = 0;
	private static int turnTotal = 0;
	private static boolean quitGame = false;

	private static int firstRollPrompt() {
		Object[] options = { "Roll!", "Finish Turn (Hold)", "Quit Game" };

		int n = JOptionPane.showOptionDialog(null, "Roll? you have " + rollValue + " unclaimed points", "Roll 1",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		System.out.println(n);
		return n;

	}

	private static boolean playerFirstDecision(int num, int previousTotal) {
		switch (num) {
		case 0: // Player chose to roll
			rollDie();
			return true;
		case 1: // Player chose to hold
			playerTurn = !playerTurn;
			claimedPlayerScore = turnTotal + claimedPlayerScore;
			turnTotal = 0;
			return true;
		case 2:
			num = 3; // Player chose to quit from game
			quitGame = true;
			return false;
		case JOptionPane.CLOSED_OPTION: // Player exited from game
			quitGame = true;
			return false;
		default:
			System.out.println("ERROR!");
			return true;

		}
	}

	private static void showScore(int num) {
		JOptionPane.showMessageDialog(null, "Claimed Points: CPU - " + claimedCPUScore + " | You - "
				+ claimedPlayerScore + "\n Unclaimed Points: You - " + num);
	}

	private static int secondRollPrompt() {
		Object[] options = { "Roll the Die!", "Finish Turn (Hold)", "Quit Game" };

		int n = JOptionPane.showOptionDialog(null, "It is your turn, would you like to roll your first die?", "Roll 2",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		return n;
	}

	private static boolean playerSecondDecision(int num, int previousTotal) {
		switch (num) {
		case 0:
			num = 0; // Player chose to roll
			rollDie();
			return true;
		case 1:
			num = 1; // Player chose to hold
			playerTurn = !playerTurn;
			claimedPlayerScore = turnTotal + claimedPlayerScore;
			turnTotal = 0;
			return true;
		case 2:
			num = 3; // Player chose to quit from game
			quitGame = true;
			return false;
		case JOptionPane.CLOSED_OPTION: // Player exited from game
			quitGame = true;
			return false;
		default:
			System.out.println("Error!");
			return true;

		}
	}

	private static void rollDie() {
		int rand = (int) (Math.random() * 6) + 1;
		rollValue = rand;

	}

	public static void main(String[] args) {
		int firstDie = 0;
		int secondDie = 0;
		
		while (claimedPlayerScore < 100 && claimedCPUScore < 100 && !quitGame) { // Game	// quits
			rollValue = 0;
			while (playerTurn) {
				// showScore(turnTotal);
				int firstDecision = firstRollPrompt();
				if (!playerFirstDecision(firstDecision, turnTotal))
					break;
				
				firstDie = rollValue;
				JOptionPane.showMessageDialog(null, "You have rolled a " + rollValue + "!");
				int secondDecision = secondRollPrompt();
				if (!playerSecondDecision(secondDecision, turnTotal))
					break;
	
				secondDie = rollValue;
				JOptionPane.showMessageDialog(null, "You have rolled a " + rollValue + "!");
				turnTotal = firstDie + secondDie + turnTotal;
				firstDie = 0;
				secondDie = 0;
				showScore(turnTotal);	
			}
		}
	}
}
