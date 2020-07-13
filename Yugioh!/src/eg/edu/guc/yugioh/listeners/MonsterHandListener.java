package eg.edu.guc.yugioh.listeners;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.gui.CardHelp;

public class MonsterHandListener implements ActionListener{
	private JFrame f;
	private static String s1;
	
	public void actionPerformed(ActionEvent e) {
		f = new JFrame();
		f.setBounds(100,100,700,500);
		f.setLayout(new FlowLayout());
		s1=e.getActionCommand();
		if(((MonsterCard) HandListener.getC1()).getLevel()<=4){
			if(e.getActionCommand().equals("Summon")){
				Card.getBoard().getActivePlayer().summonMonster((MonsterCard)HandListener.getC1());
			}
			else if(e.getActionCommand().equals("Set")){
					Card.getBoard().getActivePlayer().setMonster((MonsterCard)HandListener.getC1());
			}
		}else{
		if(((MonsterCard) HandListener.getC1()).getLevel()<=6){
			for(int i=0;i<Card.getBoard().getActivePlayer().getField().getMonstersArea().size();i++){
				   JButton b= CardHelp.cardCreator("v", Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getName());
				   b.addActionListener(new less6MonsterHandListener());
				   f.add(b);
				}
			f.setVisible(true);
		}else{
		if(((MonsterCard) HandListener.getC1()).getLevel()>6){
			for(int i=0;i<Card.getBoard().getActivePlayer().getField().getMonstersArea().size();i++){
				   JButton b= CardHelp.cardCreator("v", Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getName());
				   b.addActionListener(new more6MonsterHandListener());
				   f.add(b);
				}
			f.setVisible(true);
		}
		}
		}
	}
	public static String getS1() {
		return s1;
	}
	
}
