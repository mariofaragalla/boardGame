package eg.edu.guc.yugioh.exceptions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NoMonsterSpaceException extends NoSpaceException {
	private static String Message="There is no space for more monsters in the field.";
	
	public NoMonsterSpaceException() {
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

	

