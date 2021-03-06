import java.util.Scanner;
import java.util.InputMismatchException;

public class Part4 {
	public static void main(String[] args) {
		int userNum = 0;
		Scanner screen = new Scanner(System.in);
		boolean inputOK = false;
		String dump = null;
		while (!inputOK) {
			System.out.print("Enter a number: ");
			try {
				userNum = screen.nextInt();
				dump = screen.nextLine();
				inputOK = true;
			} catch (InputMismatchException e) {
				dump = screen.nextLine();
				System.out.println("\"" + dump + "\" is not a legal integer, please try again");
			}
		}
		screen.close();
		userNum = userNum + 20;
		System.out.println("Your number plus 20 is " + userNum);
	} // end of main method
} // end of Class Part 4


