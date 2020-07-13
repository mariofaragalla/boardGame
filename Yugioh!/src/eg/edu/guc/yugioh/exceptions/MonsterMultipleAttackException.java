package eg.edu.guc.yugioh.exceptions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MonsterMultipleAttackException extends RuntimeException {
	private static String Message="You are only allowed to attack once with each monster on your field per turn.";

	public String getMessage() {
		return Message;
	}
	public  MonsterMultipleAttackException() {
		Label();
		throw this;
	}

	public void Label(){
		JFrame f=new JFrame();
		JOptionPane.showMessageDialog(f,getMessage()); 
		}
}

