package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.listeners.HandListener;
import eg.edu.guc.yugioh.listeners.StartButtons;

public class CardHelp {
	static int screenWidth = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	static int screenHeight =(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	static int i = 0;
	public static JButton cardCreator(String s1,String s2){
		String s = "src/"+s1+"/"+s2+".png";
		JButton b = new JButton();
		if(s1.equals("v")){
			b.setSize(new Dimension(((80*screenWidth)/1366),((125*screenHeight)/768)));
		}else{
			b.setSize(new Dimension(((110*screenWidth)/1366),((75*screenHeight)/768)));
		}
		b.setText(s2);
		ImageIcon i = new ImageIcon(s);
		i.setImage(i.getImage().getScaledInstance(b.getWidth(),b.getHeight(),0));
		JLabel l = new JLabel(i);
		l.setPreferredSize(new Dimension(b.getWidth(),b.getHeight()));
		b.add(l);
		b.setContentAreaFilled(false);
		System.out.println(b.getBounds());
		return b;
	}
	public static void fromDeckToHand(Card c){
		if((i%2)==0){
			c.setButton(cardCreator("v",c.getName()));
			GameBoard.getHand1().add(c.getButton());
			i++;
		}
		else {
			c.setButton(cardCreator("v",c.getName()));
			GameBoard.getHand2().add(c.getButton());
			i++;
		}
		c.getButton().addActionListener(new HandListener());
		}
	public static void MoveCard(Card c,String s,JLabel from,JLabel to){
		from.remove(c.getButton());
		c.setButton(cardCreator(s,c.getName()));
		to.add(c.getButton());
	}
	public static void MoveCardI(Card c,String s,JLabel from,JLabel to){
		from.remove(c.getButton());
		c.setButton(cardCreator(s,"Inv"));
		to.add(c.getButton());
	}
	public static void summonMonster(Card c){
			if(Card.getBoard().getActivePlayer()==TheGame.getP1()){
				MoveCard(c,c.getName(),GameBoard.getHand1(),GameBoard.getMonster1());
			}
			else{
				MoveCard(c,c.getName(),GameBoard.getHand2(),GameBoard.getMonster2());
			}
	}
	public static void setMonster(Card c){
			if(Card.getBoard().getActivePlayer()==TheGame.getP1()){
				MoveCardI(c,"h",GameBoard.getHand1(),GameBoard.getMonster1());
			}
			else{
				MoveCardI(c,"h",GameBoard.getHand2(),GameBoard.getMonster2());
			}
	}
	public static void setSpell(Card c){
		if(Card.getBoard().getActivePlayer()==TheGame.getP1()){
			MoveCard(c,"h",GameBoard.getHand1(),GameBoard.getSpell1());
		}
		else{
			MoveCard(c,"h",GameBoard.getHand1(),GameBoard.getSpell1());
		}
	}

}
