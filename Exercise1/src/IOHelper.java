import javax.swing.JOptionPane;

public class IOHelper {
	
	public static int getInt(int low, String prompt, int high){
		int myNum = 0;
		boolean passFlag = false;
		while(!passFlag){
			try{
				myNum = Integer.parseInt(JOptionPane.showInputDialog(prompt));
				if (myNum < high && myNum > low)
					passFlag = true;
			} catch(Exception e){
			JOptionPane.showMessageDialog(null, "Your entry was not a valid number, please try again.");
			}
		}
		return myNum;
	}
	public static int getInt(int low, String prompt){
		boolean passFlag = false;
		int myNum = 0;
		while (!passFlag){
			try{
				myNum = Integer.parseInt(JOptionPane.showInputDialog(prompt));
				if (myNum > low){
					passFlag = true;
				}
			} catch(Exception e){
			JOptionPane.showMessageDialog(null, "Your entry was not a valid number, please try again.");
			}
		}
		return myNum;
	}
	public static int getInt(String prompt, int high){
		boolean passFlag = false;
		int myNum = 0;
		while (!passFlag){
			try{
				myNum = Integer.parseInt(JOptionPane.showInputDialog(prompt));
				if (myNum < high){
					passFlag = true;
				}
			} catch(Exception e){
			JOptionPane.showMessageDialog(null, "Your entry was not a valid number, please try again.");
			}
		}
		return myNum;
	}
	public static int getInt(String prompt){
		boolean passFlag = false;
		int myNum = 0;
		while (!passFlag){
			try{
				myNum = Integer.parseInt(JOptionPane.showInputDialog(prompt));
				passFlag = true;
			} catch(Exception e){
			JOptionPane.showMessageDialog(null, "Your entry was not a valid number, please try again.");
			}
		}
		return myNum;
	}
	public static int getInt(){
		int minimum = -10000;
		int maximum = 10000;
		int myNum = minimum + (int)(Math.random() * maximum);
		return myNum;
	}
	
	public static double getDouble(double low, String prompt, double high){
		boolean passFlag = false;
		double myNum = 0;
		while (!passFlag){
			try{
				myNum = Double.parseDouble(JOptionPane.showInputDialog(prompt));
				if (myNum < high && myNum > low){
					passFlag = true;
				}
			} catch(Exception e){
			JOptionPane.showMessageDialog(null, "Your entry was not a valid number, please try again.");
			}
		}
		return myNum;
	}
	public static double getDouble(double low, String prompt){
		boolean passFlag = false;
		double myNum = 0;
		while (!passFlag){
			try{
				myNum = Double.parseDouble(JOptionPane.showInputDialog(prompt));
				if (myNum > low){
					passFlag = true;
				}
			} catch(Exception e){
			JOptionPane.showMessageDialog(null, "Your entry was not a valid number, please try again.");
			}
		}
		return myNum;
	}
	public static double getDouble(String prompt, double high){
		boolean passFlag = false;
		double myNum = 0;
		while (!passFlag){
			try{
				myNum = Double.parseDouble(JOptionPane.showInputDialog(prompt));
				if (myNum < high){
					passFlag = true;
				}
			} catch(Exception e){
			JOptionPane.showMessageDialog(null, "Your entry was not a valid number, please try again.");
			}
		}
		return myNum;
	}
	public static double getDouble(String prompt){
		boolean passFlag = false;
		double myNum = 0;
		while (!passFlag){
			try{
				myNum = Double.parseDouble(JOptionPane.showInputDialog(prompt));
				passFlag = true;
			} catch(Exception e){
			JOptionPane.showMessageDialog(null, "Your entry was not a valid number, please try again.");
			}
		}
		return myNum;
	}
	public static double getDouble(){
		int minimum = -10000;
		int maximum = 10000;
		double myNum = minimum + (double)(Math.random() * maximum);
		return myNum;
	}
}
