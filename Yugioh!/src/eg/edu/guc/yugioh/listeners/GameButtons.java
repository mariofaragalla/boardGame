package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameButtons implements ActionListener {
	JFrame f;
	public void actionPerformed(ActionEvent e) {
		String s= e.getActionCommand();
	//	if(enta fl battle phase )
		sacrificesCheck(s);
		
	 
		
	}
	public void sacrificesCheck(String s){
	switch(s){
	case("Summoned Skull"):;
	case("Fence Guard Magician"):;
	case("Dark Magician Girl"):;
	case("Curse Of Dragon"):;
	case("Fence Guard Dragon"):;
	default: f=new JFrame();
	/* hanetcheck 3la kol el we7oosh elli fl field we 
	 * n7otohom kolohom fe buttons wl buttons no7otaha 
	 * fl frame wl frame 3ala el 
	 *
	*/
	
	
	}
	}
  }

