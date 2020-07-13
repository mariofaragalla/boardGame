package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class MonsterReborn extends SpellCard{
	public MonsterReborn(String name,String description){
		super(name,description);
	}
	public void action(MonsterCard monster) {
		int maxAtt = 0;
		int maxIndex1 =-1;
		int maxIndex2=-1;
		ArrayList<Card> Grave1=getBoard().getActivePlayer().getField().getGraveyard() ;
		for(int i=0;i<Grave1.size();i++){
			if(Grave1.get(i) instanceof MonsterCard){
				MonsterCard t = (MonsterCard) Grave1.get(i);
				if(maxAtt<t.getAttackPoints()){
					maxAtt=t.getAttackPoints();
					maxIndex1=i;
				}
			}
		}
		ArrayList<Card> Grave2=getBoard().getOpponentPlayer().getField().getGraveyard() ;
		for(int i=0;i<Grave2.size();i++){
			if(Grave2.get(i) instanceof MonsterCard){
				MonsterCard t = (MonsterCard) Grave2.get(i);
				if(maxAtt<t.getAttackPoints()){
					maxAtt=t.getAttackPoints();
					maxIndex2=i;
				}
			}
		}
		if(maxIndex1 == -1){
			if(maxIndex2 !=-1){
				MonsterCard temp = (MonsterCard)Grave2.remove(maxIndex2);
				getBoard().getActivePlayer().getField().addMonsterToField(temp,temp.getMode(),temp.isHidden());
			}
			else{System.out.println("there are no MonsterCard in the 2 Graveyard");
				}
			}
		else{
			if(maxIndex2 == -1){
				MonsterCard temp = (MonsterCard)Grave1.remove(maxIndex1);
				getBoard().getActivePlayer().getField().addMonsterToField(temp,temp.getMode(),temp.isHidden());
			}
			else{
				if(((MonsterCard)Grave1.get(maxIndex1)).getAttackPoints()==maxAtt){
					MonsterCard temp = (MonsterCard)Grave1.remove(maxIndex1);
					getBoard().getActivePlayer().getField().addMonsterToField(temp,temp.getMode(),temp.isHidden());
				}
				else{
					MonsterCard temp = (MonsterCard)Grave2.remove(maxIndex2);
					getBoard().getActivePlayer().getField().addMonsterToField(temp,temp.getMode(),temp.isHidden());
				}
		}
				
		}
	}
}
