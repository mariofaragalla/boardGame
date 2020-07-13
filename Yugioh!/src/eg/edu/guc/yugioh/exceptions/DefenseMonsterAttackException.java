package eg.edu.guc.yugioh.exceptions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DefenseMonsterAttackException extends RuntimeException {
		private static String Message="Your monster must be in attack mode in order to be able to attack";

		public String getMessage() {
			return Message;
		}
		public DefenseMonsterAttackException(){
			Label();
			throw this;
		}

		public void Label(){
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,getMessage()); 
			
		}
}
