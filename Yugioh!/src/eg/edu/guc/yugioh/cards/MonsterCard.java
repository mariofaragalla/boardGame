package eg.edu.guc.yugioh.cards;

import javax.swing.JButton;

public class MonsterCard extends Card{
	    private int level;
	    private	int defensePoints;
	    private	int attackPoints;
	    private	Mode mode;
	    private boolean Attacked;
	    private boolean changOfMode;
	    
	public MonsterCard(String name, String description, int level, int attack, int defense){
		super(name,description);
		this.level=level;
		attackPoints=attack;
		defensePoints=defense;
	    mode=Mode.DEFENSE;
	    Attacked = false;
	    changOfMode = false;
	}
	public void action(MonsterCard monster) {
		
		if(!Attacked){
			Attacked=true;
			if(monster.getMode()==Mode.DEFENSE){
				monster.setHidden(false);
				if(attackPoints> monster.getDefensePoints())
					getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
				if(attackPoints< monster.getDefensePoints())
					getBoard().getActivePlayer().setLifePoints(getBoard().getActivePlayer().getLifePoints()-(monster.getDefensePoints()-attackPoints));
			}
			else{
				if(attackPoints> monster.getAttackPoints()){
					getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
					getBoard().getOpponentPlayer().setLifePoints(getBoard().getOpponentPlayer().getLifePoints()-(attackPoints-monster.getAttackPoints()));
				}
				if(attackPoints< monster.getAttackPoints()){
					getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
					getBoard().getActivePlayer().setLifePoints(getBoard().getActivePlayer().getLifePoints()-(monster.getAttackPoints()-attackPoints));
				}
				if(attackPoints== monster.getAttackPoints()){
					getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
					getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
				}
			}
	
			if(getBoard().getActivePlayer().getLifePoints()<=0){
				getBoard().setWinner(getBoard().getOpponentPlayer());
			}
			if(getBoard().getOpponentPlayer().getLifePoints()<=0){
				getBoard().setWinner(getBoard().getActivePlayer());
			}
		}
	} 
	/*public static void main(String[] args) throws Exception {
		Board board = new Board();
		Player p1 = new Player("Yugi");
		Player p2 = new Player("Kaiba");
		board.startGame(p1, p2);
		
		MonsterCard m1 = new MonsterCard("dssds", "dsd",3, 3000, 3000);
		MonsterCard m2 = new MonsterCard("dssds", "dsd",3, 3000, 3000);
		m1.setMode(Mode.ATTACK);
		m2.setMode(Mode.ATTACK);
		
		board.getActivePlayer().summonMonster(m1);
		board.getOpponentPlayer().summonMonster(m2);
		
		m1.action(m2);
		}*/
	public void action(){
		if(!Attacked){
			Attacked=true;
			getBoard().getOpponentPlayer().setLifePoints(getBoard().getOpponentPlayer().getLifePoints()-(attackPoints));
			if(getBoard().getActivePlayer().getLifePoints()<=0){
				getBoard().setWinner(getBoard().getOpponentPlayer());
			}
			if(getBoard().getOpponentPlayer().getLifePoints()<=0){
				getBoard().setWinner(getBoard().getActivePlayer());
			}
		}
	}
	public int getLevel() {
		return level;
	}
	public int getDefensePoints() {
		return defensePoints;
	}
	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}
	public int getAttackPoints() {
		return attackPoints;
	}
	public boolean isChangOfMode() {
		return changOfMode;
	}
	public void setChangOfMode(boolean changOfMode) {
		this.changOfMode = changOfMode;
	}
	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}
	public Mode getMode() {
		return mode;
	}
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	public boolean isAttacked() {
		return Attacked;
	}
	public void setAttacked(boolean attacked) {
		Attacked = attacked;
	}
	
}
