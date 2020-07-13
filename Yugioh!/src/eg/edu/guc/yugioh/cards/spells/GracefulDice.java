package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class GracefulDice extends SpellCard{
	public GracefulDice(String name,String description){
super(name,description);
	}
public void action(MonsterCard monster){
	int x=((int)(Math.random()*10)+1)*100;
	ArrayList<MonsterCard> temp=getBoard().getActivePlayer().getField().getMonstersArea();
	for(int i=0;i<temp.size();i++){
		temp.get(i).setAttackPoints(temp.get(i).getAttackPoints()+x);
		temp.get(i).setDefensePoints(temp.get(i).getDefensePoints()+x);
	}
	
}
}
