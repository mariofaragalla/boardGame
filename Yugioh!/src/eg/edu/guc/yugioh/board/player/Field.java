package eg.edu.guc.yugioh.board.player;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.*;
import eg.edu.guc.yugioh.exceptions.*;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;

import java.io.IOException;
import java.util.ArrayList;
	public class Field {
			    
		private Phase phase;
		private ArrayList<MonsterCard> monstersArea;
		private ArrayList<SpellCard> spellArea;
		private ArrayList<Card> hand;
		private ArrayList<Card> graveyard;
		private Deck deck;
		
		public Field() throws IOException , UnexpectedFormatException {
				phase = Phase.MAIN1;
				this.monstersArea = new ArrayList<MonsterCard>();
				spellArea = new ArrayList<SpellCard>();
				hand =new ArrayList<Card>();
				graveyard = new ArrayList<Card>();
				deck=new Deck();	
		}
		
		public void addMonsterToField(MonsterCard monster, Mode m, boolean isHidden){
			if(monstersArea.size()<5){
				monster.setAttacked(false);
				monster.setChangOfMode(false);
				monster.setMode(m);
				Card.getBoard().getActivePlayer().setOnField(true);
				monster.setHidden(isHidden);
				monster.setLocation(Location.FIELD);
				hand.remove(monster);
				monstersArea.add(monster);
				}
			else throw new NoMonsterSpaceException();
		}
		public void addMonsterToField(MonsterCard monster, Mode mode, ArrayList<MonsterCard> sacrifices){
			if((monster.getLevel()>6 && sacrifices.size()==2)||(monster.getLevel()>4 && sacrifices.size()==1)||(monster.getLevel()<=4 && sacrifices.size()==0)){
				removeMonsterToGraveyard(sacrifices);
				addMonsterToField(monster, mode,  monster.isHidden());
			}
		}
		public void removeMonsterToGraveyard(MonsterCard monster){
			if(monstersArea.contains(monster)){
				graveyard.add(monster);
				monster.setLocation(Location.GRAVEYARD);
				monstersArea.remove(monster);
			}
		}
		public void removeMonsterToGraveyard(ArrayList<MonsterCard> monsters){
			while(monsters.size()>0)
				removeMonsterToGraveyard(monsters.remove(0));
			}
		public void addSpellToField(SpellCard action,MonsterCard monster, boolean hidden){
			if(spellArea.size()<5){
				spellArea.add(action);		
				action.setLocation(Location.FIELD);
				hand.remove(action);
				if(!(hidden))
					this.activateSetSpell(action,monster);
			}
			else throw new NoSpellSpaceException();
		}
		public void activateSetSpell(SpellCard action, MonsterCard monster){
			action.action(monster);
			removeSpellToGraveyard(action);
		}
		public void removeSpellToGraveyard(SpellCard spell){
			if(spellArea.contains(spell)){
				spellArea.remove(spell);
				spell.setLocation(Location.GRAVEYARD);
				graveyard.add(spell);
			}
		}
		public void removeSpellToGraveyard(ArrayList<SpellCard> spells){
			while(spells.size()>0){
				removeSpellToGraveyard(spells.remove(0));
		}
		}
		public void addCardToHand(){
			if(Card.getBoard().getWinner()==null){
			    hand.add(deck.drawOneCard());
			    hand.get(hand.size()-1).setLocation(Location.HAND);
			}
		}		
		public void addNCardsToHand(int n){
			if(Card.getBoard().getWinner()==null){
				hand.addAll(deck.drawNCards(n));
				for(int i=0;i<hand.size();i++)
					hand.get(i).setLocation(Location.HAND);
			}	
		}
		

		
		public Phase getPhase() {
			return phase;
		}
		public void setPhase(Phase phase) {
			this.phase = phase;
		}
		public Deck getDeck() {
			return deck;
		}
		public ArrayList<MonsterCard> getMonstersArea() {
			return monstersArea;
		}
		public ArrayList<SpellCard> getSpellArea() {
			return spellArea;
		}
		public ArrayList<Card> getHand() {
			return hand;
		}
		public ArrayList<Card> getGraveyard() {
			return graveyard;
		}
		
		
		
		
		public void removeMonsterFromHand(MonsterCard m){
			graveyard.add(m);
			m.setLocation(Location.GRAVEYARD);
			hand.remove(m);
		}
		public void removeSpellFromHand(SpellCard s){
			graveyard.add(s);
			s.setLocation(Location.GRAVEYARD);
			hand.remove(s);
		}
		
		
	}
