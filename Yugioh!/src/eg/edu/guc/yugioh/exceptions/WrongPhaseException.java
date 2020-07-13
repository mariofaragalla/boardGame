package eg.edu.guc.yugioh.exceptions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WrongPhaseException extends RuntimeException{
	
	private static String Message="You are not allowed to perform this action in this phase.";
	public WrongPhaseException (){
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
	public static void main(String[] args) {
		WrongPhaseException e= new WrongPhaseException();
		
	}
}


