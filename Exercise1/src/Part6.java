import javax.swing.JOptionPane;

public class Part6 {
	public static void main(String[] args){
		String myName;
		int userNum;
		myName = JOptionPane.showInputDialog("Enter your first name");
		try{
			userNum = Integer.parseInt(myName);
			enterNumber(myName);
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "Your name is " + myName);
		}
		
	}
	
	public static void enterNumber(String input){
		int userNum = Integer.parseInt(input);
		userNum = userNum + 20;
		JOptionPane.showMessageDialog(null, "Your number plus 20 is " + userNum);	
	}
}
