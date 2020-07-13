package eg.edu.guc.yugioh.listeners;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.gui.CardHelp;

	public class spellHandListener implements ActionListener{
		private JFrame f;
		public void actionPerformed(ActionEvent e) {
			HandListener.getF1().setVisible(false);
		if(e.getActionCommand()=="Activate"){
			f=new JFrame();
			f.setBounds(100,100,700,500);
			f.setLayout(new FlowLayout());
			for(int i=0;i<Card.getBoard().getOpponentPlayer().getField().getMonstersArea().size();i++){
			   JButton b= CardHelp.cardCreator("v", Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(i).getName());
			   b.addActionListener(new ActivateSpellfromHand());
			   f.add(b);
			}
			f.setVisible(true);
		}else{
			Card.getBoard().getActivePlayer().setSpell((SpellCard)HandListener.getC1());
		}
	}

}
