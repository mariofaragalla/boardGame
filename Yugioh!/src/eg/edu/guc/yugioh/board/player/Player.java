package eg.edu.guc.yugioh.board.player;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.*;
import eg.edu.guc.yugioh.gui.CardHelp;

public class Player implements Duelist {
	
	private String name;
	private int lifePoints;
	private Field field;
	private boolean onField;
	
	public Player(String name) throws Exception  {
		this.name = name;
		lifePoints=8000;
		field=new Field();
		onField = false;
	}
	
	
	public String getName() {
		return name;
	}
	public Field getField() {
		return field;
	}
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	public boolean isOnField() {
		return onField;
	}
	public void setOnField(boolean onField) {
		this.onField = onField;
	}
	public boolean summonMonster(MonsterCard monster) {
		if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()<5){
			if(getField().getPhase()==Phase.MAIN1 || getField().getPhase()==Phase.MAIN2){
				if(!onField){
					if(this == Card.getBoard().getActivePlayer() && monster.getLocation()==Location.HAND && Card.getBoard().getWinner()==null){
						monster.setHidden(false);
						onField = true;
						getField().addMonsterToField(monster, Mode.ATTACK,false);
						CardHelp.summonMonster(monster);
					}
				}else throw new MultipleMonsterAdditionException();
			}else throw new WrongPhaseException();
		}else throw new NoMonsterSpaceException();
		return getField().getMonstersArea().contains(monster);
	}
	public boolean summonMonster(MonsterCard monster,ArrayList<MonsterCard> sacrifices) {
		if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()<5){
			if(getField().getPhase()==Phase.MAIN1 || getField().getPhase()==Phase.MAIN2){
				if(!onField){
					if(this == Card.getBoard().getActivePlayer() && monster.getLocation()==Location.HAND && Card.getBoard().getWinner()==null){
						monster.setHidden(false);
						onField = true;
						getField().addMonsterToField(monster, Mode.ATTACK, sacrifices);
						CardHelp.summonMonster(monster);
					}
				}else throw new MultipleMonsterAdditionException();
			}else throw new WrongPhaseException();
		}else throw new NoMonsterSpaceException();
		return getField().getMonstersArea().contains(monster);
	}
	public boolean setMonster(MonsterCard monster) {
		if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()<5){
			if(getField().getPhase()==Phase.MAIN1 || getField().getPhase()==Phase.MAIN2){
				if(!onField){
					if(this == Card.getBoard().getActivePlayer() && monster.getLocation()==Location.HAND && Card.getBoard().getWinner()==null){
						monster.setHidden(true);
						onField = true;
						getField().addMonsterToField(monster, Mode.DEFENSE,true);
						CardHelp.setMonster(monster);
					}
				}else throw new MultipleMonsterAdditionException();
			}else throw new WrongPhaseException();
		}else throw new NoMonsterSpaceException();
		return getField().getMonstersArea().contains(monster);
	}
	public boolean setMonster(MonsterCard monster,ArrayList<MonsterCard> sacrifices) {
		if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()<5){
			if(getField().getPhase()==Phase.MAIN1 || getField().getPhase()==Phase.MAIN2){
				if(!onField){
					if(this == Card.getBoard().getActivePlayer() && monster.getLocation()==Location.HAND && Card.getBoard().getWinner()==null){
						monster.setHidden(true);
						onField = true;
						getField().addMonsterToField(monster, Mode.DEFENSE, sacrifices);
						CardHelp.setMonster(monster);
					}
				}else throw new MultipleMonsterAdditionException();
			}else throw new WrongPhaseException();
		}else throw new NoMonsterSpaceException();
		return getField().getMonstersArea().contains(monster);
	}
	public boolean setSpell(SpellCard spell) {
		int i = getField().getSpellArea().size();
		if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()<5){
			if(getField().getPhase()==Phase.MAIN1 || getField().getPhase()==Phase.MAIN2){
				if(this == Card.getBoard().getActivePlayer() && spell.getLocation()==Location.HAND && Card.getBoard().getWinner()==null){
					getField().addSpellToField(spell,null, true);
				}
			}else throw new WrongPhaseException();
		}else throw new NoSpellSpaceException();
		return getField().getSpellArea().size() == i+1;
	}
	public boolean activateSpell(SpellCard spell, MonsterCard monster) {
		int i = getField().getSpellArea().size();
		if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()<5){
			if(getField().getPhase()==Phase.MAIN1 || getField().getPhase()==Phase.MAIN2){
				if(this == Card.getBoard().getActivePlayer() && Card.getBoard().getWinner()==null){
					if(spell.getLocation()==Location.FIELD){
						i = getField().getSpellArea().size();
						getField().activateSetSpell(spell,monster);
						}
					else if(spell.getLocation()==Location.HAND){
						getField().addSpellToField(spell,monster,false);
						i = getField().getSpellArea().size() +1;
					}
				}
			}else throw new WrongPhaseException();
		}else throw new NoSpellSpaceException();
		return getField().getSpellArea().size() == i-1;
	}
	public boolean declareAttack(MonsterCard activeMonster,MonsterCard opponentMonster) {
		if(getField().getPhase()==Phase.BATTLE){
			if(!activeMonster.isAttacked()){
				if(activeMonster.getMode()==Mode.ATTACK){
					if(this == Card.getBoard().getActivePlayer() && Card.getBoard().getWinner()==null && Card.getBoard().getActivePlayer().getField().getMonstersArea().contains(activeMonster) && Card.getBoard().getOpponentPlayer().getField().getMonstersArea().contains(opponentMonster)){
						activeMonster.action(opponentMonster);
						return true;
					}
				}else throw new DefenseMonsterAttackException();
			}else throw new MonsterMultipleAttackException();
		}else throw new WrongPhaseException();
		return false;
	}
	public boolean declareAttack(MonsterCard activeMonster) {
		if(getField().getPhase()==Phase.BATTLE){
			if(!activeMonster.isAttacked()){
				if(activeMonster.getMode()==Mode.ATTACK){
					if(this == Card.getBoard().getActivePlayer() && Card.getBoard().getWinner()==null && Card.getBoard().getActivePlayer().getField().getMonstersArea().contains(activeMonster) && Card.getBoard().getOpponentPlayer().getField().getMonstersArea().size()==0){
						activeMonster.action();
						return true;
					}
				}else throw new DefenseMonsterAttackException();
			}else throw new MonsterMultipleAttackException();
		}else throw new WrongPhaseException();
		return false;
	}
	public void addCardToHand() {
		if(Card.getBoard().getWinner()==null){
			if(getField().getDeck().getDeck().size()==0){
				Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
			}
			else if(this == Card.getBoard().getActivePlayer()) Card.getBoard().getActivePlayer().getField().addCardToHand();
		}
	}
	public void addNCardsToHand(int n) {
		if(Card.getBoard().getWinner()==null){
			if(getField().getDeck().getDeck().size()<n ){
				Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
			}
			else if(this == Card.getBoard().getActivePlayer()) Card.getBoard().getActivePlayer().getField().addNCardsToHand(n);
		}
	}
	public void endPhase() {
		if(Card.getBoard().getWinner()==null){
				if(getField().getPhase()==Phase.MAIN1 && this == Card.getBoard().getActivePlayer()) getField().setPhase(Phase.BATTLE);
				else if(getField().getPhase()==Phase.BATTLE && this == Card.getBoard().getActivePlayer()) getField().setPhase(Phase.MAIN2);
				else if(getField().getPhase()==Phase.MAIN2 && this == Card.getBoard().getActivePlayer()) endTurn();
		}
	}
	public boolean endTurn(){
		if(Card.getBoard().getWinner()==null){
			if(Card.getBoard().getActivePlayer().getLifePoints()<=0){
				Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
				return false;
			}
			if(Card.getBoard().getOpponentPlayer().getLifePoints()<=0){
				Card.getBoard().setWinner(Card.getBoard().getActivePlayer());
				return false;
			}
			if(this == Card.getBoard().getActivePlayer()){
				onField = false;
				Card.getBoard().nextPlayer();
				return true;
			}
		}
		return false;
	}
	public boolean switchMonsterMode(MonsterCard monster) {
		if(getField().getPhase()==Phase.MAIN1 || getField().getPhase()==Phase.MAIN2){
			if(!monster.isChangOfMode() && this == Card.getBoard().getActivePlayer()&& Card.getBoard().getWinner()==null && Card.getBoard().getActivePlayer().getField().getMonstersArea().contains(monster)){
				monster.setChangOfMode(true);
				if(monster.getMode()==Mode.ATTACK) monster.setMode(Mode.DEFENSE);
				else if(monster.getMode()==Mode.DEFENSE) monster.setMode(Mode.ATTACK);
				return true;
			}
		}else throw new WrongPhaseException();
		return false;
	}
/*public static void main(String[] args) throws Exception {
	Board board = new Board();
	Player p1 = new Player("Yugi");
	Player p2 = new Player("Kaiba");
	MonsterCard m=new MonsterCard("s", "se", 6, 3000, 2000);
	m.setLocation(Location.HAND);
	board.setActivePlayer(p1);
	p1.getField().getHand().add(m);
	ArrayList <MonsterCard> sacri =new ArrayList<>();
	sacri.add(m);
	System.out.println(p1.setMonster(m,sacri ));
}*/
}
