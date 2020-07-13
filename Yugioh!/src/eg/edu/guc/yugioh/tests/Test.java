package eg.edu.guc.yugioh.tests;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.gui.GameBoard;

public class Test implements ActionListener{
public void HelperYabny(){
	}

	
	public void actionPerformed(ActionEvent e) {
		Card c=findBattle(e.getActionCommand());
		if(!(c == null)){
			if(c.getLocation()==Location.FIELD){
				if(c instanceof MonsterCard){
					// summon set
				}else{
					// set 
				}
			}else{
				if(c.getLocation()==Location.HAND){
					if(c instanceof MonsterCard){
						
					}else{
						
					}
				}
			}
		}else{
			//2l card mesh fe 2y 7eta 3ndk yb2a lazemm 3nd 2l opponent
		}
	}
	public static Card findBattle(String s){
		for(int i=0;i<Card.getBoard().getActivePlayer().getField().getMonstersArea().size();i++){
			if(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getName().equals(s)){
				return Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i);
			}
		}
		for(int i=0;i<Card.getBoard().getActivePlayer().getField().getSpellArea().size();i++){
			if(Card.getBoard().getActivePlayer().getField().getSpellArea().get(i).getName().equals(s)){
				return Card.getBoard().getActivePlayer().getField().getSpellArea().get(i);
			}
		}
		for(int i=0;i<Card.getBoard().getActivePlayer().getField().getHand().size();i++){
			if(Card.getBoard().getActivePlayer().getField().getHand().get(i).getName().equals(s)){
				return Card.getBoard().getActivePlayer().getField().getHand().get(i);
			}
		}
		return null;
	}
	public static Card findMain(){
		return null;
		
	}
public static void main(String[] args) {

}
}
