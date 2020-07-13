package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class less6MonsterHandListener implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {
		ArrayList<MonsterCard> sa = new ArrayList<MonsterCard>();
		sa.add((MonsterCard)findHand(e.getActionCommand()));
		if(MonsterHandListener.getS1().equals("Summon")){
			Card.getBoard().getActivePlayer().summonMonster((MonsterCard)HandListener.getC1(), sa);
		}else
			Card.getBoard().getActivePlayer().setMonster((MonsterCard)HandListener.getC1(), sa);
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
