package eg.edu.guc.yugioh.exceptions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MultipleMonsterAdditionException extends RuntimeException {
	private static String Message="Only one monster is allowed to added per turn";

	public MultipleMonsterAdditionException(){
			Label();
			throw this;
	}
	public String getMessage() {
		return Message;
	}

	public void Label(){
		JFrame f=new JFrame();
		JOptionPane.showMessageDialog(f,getMessage()); 
		}
	
}


