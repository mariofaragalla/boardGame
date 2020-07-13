package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class ActivateSpellfromHand implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		 Card.getBoard().getActivePlayer().activateSpell((SpellCard)HandListener.getC1(),(MonsterCard)findHand(e.getActionCommand()));
	}
	public static Card findHand(String s){
		for(int i=0;i<Card.getBoard().getOpponentPlayer().getField().getMonstersArea().size();i++){
			if(Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(i).getName().equals(s)){
				return Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(i);
			}
		}
		return null;
	}

}
