package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class ChangeOfHeart extends SpellCard{
	public ChangeOfHeart(String name,String description){
		super(name,description);
	}
	public void action(MonsterCard monster) {
		getBoard().getActivePlayer().getField().addMonsterToField(monster, monster.getMode(),monster.isHidden());
		getBoard().getOpponentPlayer().getField().getMonstersArea().remove(monster);
	}
}
