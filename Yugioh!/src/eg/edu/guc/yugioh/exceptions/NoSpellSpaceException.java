package eg.edu.guc.yugioh.exceptions;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class NoSpellSpaceException extends NoSpaceException {
	private static String Message="there is no space for more spells in the field.";
	
	  public NoSpellSpaceException() {
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
