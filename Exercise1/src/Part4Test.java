import java.util.Scanner;

public class Part4Test {
	public static void main(String[] args) {

		int userNum;
		String userString;
		Scanner screen = new Scanner(System.in);
		System.out.print("Enter a number: ");
		userNum = screen.nextInt();
//		userString = screen.nextLine();
		userNum = userNum + 20;
		System.out.println("Your number plus 20 is "  + userNum);
		System.out.print("Enter a string: ");
		userString = screen.next();
		System.out.println("You typed: " + userString);
		System.out.println("Program is done!");
		screen.close();
	}
}
