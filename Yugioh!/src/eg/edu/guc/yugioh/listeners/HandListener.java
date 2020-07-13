package eg.edu.guc.yugioh.listeners;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class HandListener implements ActionListener{

	private static JFrame f1;
	private JButton b1;
	private JButton b2;
	private JLabel l;
	private static Card c1;
	
	public void actionPerformed(ActionEvent e) {
		Card c=findHand(e.getActionCommand());
		if(c!=null){
			if(c instanceof MonsterCard){
				c1=c;
				f1=new JFrame();
				f1.setLayout(new FlowLayout());
				f1.setBounds(200, 300, 700, 100);
				l=new JLabel("What do you want to do with the monster?");
				l.setVerticalAlignment(1);
				l.setPreferredSize(new Dimension(300,30));
				b1=new JButton("Summon");
				b1.addActionListener(new MonsterHandListener());
				b2=new JButton("Set");
				b2.addActionListener(new MonsterHandListener());
				b1.setPreferredSize(new Dimension(120,30));
				b2.setPreferredSize(new Dimension(100,30));
				f1.add(l);
				f1.add(b1);
				f1.add(b2);
				f1.setVisible(true);
				
			}else{
			c1=c;
			f1=new JFrame();
			f1=new JFrame();
			f1.setLayout(new FlowLayout());
			f1.setBounds(200, 300, 700, 100);
			l=new JLabel("What do you want to do with the spell?");
			l.setVerticalAlignment(1);
			l.setPreferredSize(new Dimension(300,30));
			b1=new JButton("Activate");
			b1.addActionListener(new spellHandListener());
			b2=new JButton("Set");
			b2.addActionListener(new spellHandListener());
			b1.setPreferredSize(new Dimension(120,30));
			b2.setPreferredSize(new Dimension(100,30));
			f1.add(l);
			f1.add(b1);
			f1.add(b2);
			f1.setVisible(true);
			}
		}
		
		
	}
		public static Card findHand(String s){
		for(int i=0;i<Card.getBoard().getActivePlayer().getField().getHand().size();i++){
			if(Card.getBoard().getActivePlayer().getField().getHand().get(i).getName().equals(s)){
				return Card.getBoard().getActivePlayer().getField().getHand().get(i);
			}
		}
		return null;
	}
		public static JFrame getF1() {
			return f1;
		}
		public static Card getC1() {
			return c1;
		}
		
}


