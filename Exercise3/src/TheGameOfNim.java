import java.util.Scanner;

public class TheGameOfNim {
	public static void main(String[] args) {
		Scanner screen = new Scanner(System.in);
		int numMarbles = randomIntBetween(10, 100);
		int marblesRemoved = 0;
		boolean cpuPlaysFirst = random5050();
		boolean cpuPlaysSmart = random5050();
		boolean cpuTurn = cpuPlaysFirst;

		displayStartingInformation(numMarbles, cpuPlaysFirst, cpuPlaysSmart);

		while (numMarbles > 1) {
			if (cpuTurn) {
				marblesRemoved = cpuMove(cpuPlaysSmart, numMarbles);
				numMarbles = numMarbles - marblesRemoved;
				System.out.println("\nThe computer chose to remove " + marblesRemoved + " marbles.");
				System.out.println("There are " + numMarbles + " marbles left.");
				cpuTurn = false;
			} else {
				marblesRemoved = playersMove(numMarbles, screen);
				numMarbles = numMarbles - marblesRemoved;
				System.out.println("\nYou chose to remove " + marblesRemoved + " marbles.");
				System.out.println("There are now " + numMarbles + " marbles left.");
				cpuTurn = true;

			}
		}
		screen.close();
		if (cpuTurn)//means that the player's turn just ended
			System.out.println("\nCongratulations! You Win!");
		else
			System.out.println("\nThe computer won that one, better luck next time.");
	}

	private static int randomIntBetween(int lower, int upper) {
		return lower + (int) ((upper-lower) * Math.random());
	}

	private static boolean random5050() {
		if (Math.random() < 0.5)
			return false;
		return true;
	}

	private static void displayStartingInformation(int marbles, boolean cpuPlaysFirst, boolean cpuPlaysSmart) {
		System.out.println("Starting with " + marbles + " marbles");
		if (cpuPlaysFirst)
			System.out.println("The computer is playing first.");
		else
			System.out.println("You get to play first.");
		if (cpuPlaysSmart)
			System.out.println("The computer is playing smart.");
		else
			System.out.println("The computer is playing randomly.");
	}

	private static int cpuMove(boolean cpuPlaysSmart, int marbles) {
		if (cpuPlaysSmart) {
			//find the lower power of two
			int lowerPower = 1;
			for (lowerPower++; lowerPower <marbles; lowerPower*=2){}
			lowerPower = lowerPower/2;
			
			if ((marbles - (lowerPower-1)) <= (int)(marbles/2) && (Math.random() < 0.8)) // the 0.75 factor is to reduce the computer's perfect game
				return (marbles - (lowerPower-1));
			else
				return randomIntBetween(1,marbles/2);
			

		} else {
			return randomIntBetween(1, marbles / 2);
		}
	}

	private static int playersMove(int numMarbles, Scanner input) {
		
		boolean inputOK = false;
		int marblesRemoved = 0;
		String dump = null;

		while (!inputOK) {
			System.out.println("\nPlease choose a number between 1 and " + (int) (numMarbles / 2) + " inclusive.");
			try {
				marblesRemoved = input.nextInt();
				dump = input.nextLine();
				if (marblesRemoved < 1 || marblesRemoved > (int) (numMarbles / 2)) {
					System.out.println("You entered a number outside the possible range!");
				} else
					inputOK = true;
			} catch (java.util.InputMismatchException e) {
				dump = input.nextLine();
				System.out.println("\nYou did not enter an integer!");
			}
		}
		return marblesRemoved;
	}
}
