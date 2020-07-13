package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class CardDestruction extends SpellCard{
	public CardDestruction(String name,String description){
		super(name,description);
	}
	public void action(MonsterCard monster){
		int c = 0;
		while(getBoard().getActivePlayer().getField().getHand().size()>0){
			if(getBoard().getActivePlayer().getField().getHand().get(0) instanceof MonsterCard)
				getBoard().getActivePlayer().getField().removeMonsterFromHand((MonsterCard) getBoard().getActivePlayer().getField().getHand().get(0)); 
			else getBoard().getActivePlayer().getField().removeSpellFromHand((SpellCard)getBoard().getActivePlayer().getField().getHand().get(0));
		c++;
		}
		getBoard().getActivePlayer().addNCardsToHand(c);
		c=0;
		while(getBoard().getOpponentPlayer().getField().getHand().size()>0){
			if(getBoard().getOpponentPlayer().getField().getHand().get(0) instanceof MonsterCard)
				getBoard().getOpponentPlayer().getField().removeMonsterFromHand((MonsterCard) getBoard().getOpponentPlayer().getField().getHand().get(0)); 
			else getBoard().getOpponentPlayer().getField().removeSpellFromHand((SpellCard)getBoard().getOpponentPlayer().getField().getHand().get(0));
		c++;
		}
		getBoard().getOpponentPlayer().getField().addNCardsToHand(c);
	}
/*public static void main(String[] args) throws Exception {
	Player p1 = new Player("Yugi");
	Player p2 = new Player("Kaiba");
	Board board = new Board();
	board.startGame(p1, p2);
	p1.addNCardsToHand(0);
	p2.addNCardsToHand(0);
	CardDestruction cd=new CardDestruction("cd", "l");
	cd.action(null);
	System.out.println(p1.getField().getHand().size());
	System.out.println(p2.getField().getHand().size());
	}*/
}
