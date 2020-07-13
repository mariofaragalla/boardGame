package eg.edu.guc.yugioh.cards;
import javax.swing.JButton;

import  eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.cards.spells.*;

public abstract class Card {
	private String name;
	private String description;
	private boolean isHidden;
	private Location location;
	private static Board board;
	private JButton Button;
	
  public Card(String name, String description){
		this.name=name;
		this.description=description;
		isHidden=true;
		location=Location.DECK;
		Button =new JButton();
	}
   public abstract void action(MonsterCard monster);
	public Card clone(){
		if(this instanceof MonsterCard ){
			MonsterCard x = (MonsterCard) this;
			MonsterCard c=new MonsterCard(x.getName(),x.getDescription(),x.getLevel(),x.getAttackPoints(),x.getDefensePoints());
			return c;
		}
		else{
			switch(this.getName()){
			case"Card Destruction": return new CardDestruction(this.getName(),this.getDescription());
			case"Change Of Heart" : return new ChangeOfHeart(this.getName(),this.getDescription());
			case"Dark Hole"       : return new DarkHole(this.getName(),this.getDescription());
			case"Graceful Dice"   : return new GracefulDice(this.getName(),this.getDescription());
			case"Harpie's Feather Duster":return new HarpieFeatherDuster(this.getName(),this.getDescription());
			case"Heavy Storm"     : return new HeavyStorm(this.getName(),this.getDescription());
			case"Mage Power"      : return new MagePower(this.getName(),this.getDescription());
			case"Monster Reborn"  : return new MonsterReborn(this.getName(),this.getDescription());
			case"Pot of Greed"    : return new PotOfGreed(this.getName(),this.getDescription());
			case"Raigeki"         : return new Raigeki(this.getName(),this.getDescription());
			}
			return null;
		}
		}
	
	
	
	
	
	
	public boolean isHidden() {
		return isHidden;
	}
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public static void setBoard(Board board) {
		Card.board=board;
	}
	public static Board getBoard() {
		
		return board;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public JButton getButton() {
		return Button;
	}
	public void setButton(JButton button) {
		Button = button;
	}
	
	
}
