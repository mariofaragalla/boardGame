package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.gui.CardHelp;

public class more6MonsterHandListener implements ActionListener{
	JFrame f;
	private static Card c2;
	public void actionPerformed(ActionEvent e) {
		f=new JFrame();
		c2 = findHand(e.getActionCommand());
		for(int i=0;i<Card.getBoard().getActivePlayer().getField().getMonstersArea().size();i++){
			if(!( Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getName().equals(e.getActionCommand()))){
			   JButton b= CardHelp.cardCreator("v", Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getName());
			   b.addActionListener(new more6MonsterHandListener());
			   f.add(b);
			}
		}
		f.setVisible(true);
	}
	public static Card getC2() {
		return c2;
	}
	public static Card findHand(String s){
		for(int i=0;i<Card.getBoard().getActivePlayer().getField().getMonstersArea().size();i++){
			if(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getName().equals(s)){
				return Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i);
			}
		}
		return null;
	}

}
