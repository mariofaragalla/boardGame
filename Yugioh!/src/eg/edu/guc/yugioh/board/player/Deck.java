package eg.edu.guc.yugioh.board.player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.gui.CardHelp;
import eg.edu.guc.yugioh.board.player.ReadingCSVFile;
public class Deck {
	private static  ArrayList<Card> monsters;
	private static ArrayList<Card> spells;
	private	ArrayList<Card> deck;
	private static String monstersPath="src/Database-Monsters.csv";
	private static String spellsPath="src/Database-Spells.csv";
	

public Deck() throws IOException , UnexpectedFormatException{
		monsters=this.loadCardsFromFile(monstersPath);
		spells=this.loadCardsFromFile(spellsPath);
		this.buildDeck(monsters,spells);
	    this.shuffleDeck();
}

public ArrayList<Card> loadCardsFromFile(String path) throws IOException, UnexpectedFormatException{
	Scanner sc=new Scanner(System.in);
	String x;
	try{
		return ReadingCSVFile.readCards(path);
	}catch (Exception e){
		System.out.println("PLease enter a correct file");
		 x=sc.nextLine();
	}try{
		return ReadingCSVFile.readCards(x);
	}catch(FileNotFoundException e1){
		System.out.println("File not Found");
		System.out.println("PLease enter a correct file");
		 x=sc.nextLine();
	}catch(UnexpectedFormatException e1){
		System.out.println("Unexpected Format Found");
		System.out.println("PLease enter a correct file");
		 x=sc.nextLine();
	}try{
		return ReadingCSVFile.readCards(x);
		}catch(FileNotFoundException e2){
			System.out.println("File not Found");
			System.out.println("PLease enter a correct file");
			 x=sc.nextLine();
		}catch(UnexpectedFormatException e2){
			System.out.println("Unexpected Format Found");
			System.out.println("PLease enter a correct file");
			 x=sc.nextLine();
	}try{
		return ReadingCSVFile.readCards(x);
		}catch(FileNotFoundException e2){
			throw e2;
		}catch(UnexpectedFormatException e2){
			throw e2;
			 }
	}
	/*}catch(Exception e){
		if(e instanceof FileNotFoundException){
			System.out.println("PLease enter a correct file");
			 x=sc.nextLine();
		 try{
			 return ReadingCSVFile.readCards(x);
			 }catch(Exception e1){//Blue-Eyes White Dragon
				 
		 	if (e1 instanceof FileNotFoundException){
				 System.out.println("File is not found");
				 System.out.println("PLease enter a correct path");
				 x=sc.nextLine();}
				 else if(e1 instanceof UnexpectedFormatException){
			 			System.out.println("Unexpected Format Found");
			 			System.out.println("PLease enter a correct path");
			 			x=sc.nextLine();}	
				 	}
				 try{
					 return ReadingCSVFile.readCards(x);
					 }catch(Exception e2){
				 	if (e2 instanceof FileNotFoundException){
						 System.out.println("File is not found");
						 System.out.println("PLease enter a correct path");
						 x=sc.nextLine();
						 }
				 	else if(e2 instanceof UnexpectedFormatException){
			 			System.out.println("Unexpected Format Found");
			 			System.out.println("PLease enter a correct path");
			 			x=sc.nextLine();}
				 		try{
				 			return ReadingCSVFile.readCards(x);
				 		}catch(Exception e3){
				 		throw e3;
				 			
				 		}
					}
				}else return ReadingCSVFile.readCards(path);
			}		
		 }
		

	
		
		
//	try{
//		return ReadingCSVFile.readCards(path);
//	}catch(Exception e){
//		for(int i=0;i<2;i++){
//			System.out.print("Please enter a correct path:");
//			String x = sc.nextLine();
//			try{
//				return ReadingCSVFile.readCards(x);
//			}catch(Exception q){
//				System.out.println("File is not found");
//			}
//		}
//		System.out.print("Please enter a correct path:");
//		String x = sc.nextLine();
//		try{
//			return ReadingCSVFile.readCards(x);
//		}catch(Exception q){
//			throw e;
//		}
	
	/*try{
		return ReadingCSVFile.readCards(path);
	}catch(Exception e){
		if(e instanceof FileNotFoundException){
		System.out.print("Please enter a correct path:");
		String x = sc.nextLine();
		return HloadCardsFromFile(x, 2);
	}else
		if(e instanceof MissingFieldException ){
		System.out.print("Please enter a correct path:");
		String x = sc.nextLine();
		return HloadCardsFromFile(x, 2);
	}else
		if(e instanceof EmptyFieldException ){
		System.out.print("Please enter a correct path:");
		String x = sc.nextLine();
		return HloadCardsFromFile(x, 2);
	}else
		if(e instanceof UnknownCardTypeException ){
		System.out.print("Please enter a correct path:");
		String x = sc.nextLine();
		return HloadCardsFromFile(x, 2);
	}else{
		System.out.print("Please enter a correct path:");
		String x = sc.nextLine();
		return HloadCardsFromFile(x, 2);
	}
	}
	
	
	/*Scanner sc=new Scanner(System.in);
	try{
		return ReadingCSVFile.readCards(path);
	}catch(FileNotFoundException e1){
		System.out.print("Please enter a correct path:");
		String x = sc.nextLine();
		try{
			return ReadingCSVFile.readCards(x);
		}catch(FileNotFoundException e2){
			System.out.print("Please enter a correct path:");
			x = sc.nextLine();
			try{
				return ReadingCSVFile.readCards(x);
			}catch(FileNotFoundException e3){
				System.out.print("Please enter a correct path:");
				x = sc.nextLine();
				try{
					return ReadingCSVFile.readCards(x);
				}catch(FileNotFoundException e4){
					throw e4;
				}
			}
		}
	}catch(UnexpectedFormatException e){
		for(int i=0;i<3;i++){
			System.out.print("Please enter a correct path:");
			String x = sc.nextLine();
			try{
				return ReadingCSVFile.readCards(x);
			}catch(FileNotFoundException q){
				if(i<2){
					System.out.println("The Format is not correct");
				}else{
					throw e;
				}

			}
		}
		throw e;
	}*/
//	public ArrayList<Card> HloadCardsFromFile(String path,int c) throws UnexpectedFormatException, IOException{
//		Scanner sc=new Scanner(System.in);
//		if(c<=0){
//			try{
//				return ReadingCSVFile.readCards(path);
//			}catch(Exception e){
//				throw e;
//			}
//		}
//		else{
//			try{
//				return ReadingCSVFile.readCards(path);
//			}catch(Exception e){
//				if(e instanceof FileNotFoundException){
//					System.out.println("File is not found");
//					System.out.print("Please enter a correct path:");
//					String x = sc.nextLine();
//					return HloadCardsFromFile(x, --c);
//				}else
//					if(e instanceof MissingFieldException ){
//						System.out.println("The Format is not correct");
//						System.out.print("Please enter a correct path:");
//						String x = sc.nextLine();
//						return HloadCardsFromFile(x, --c);
//					}else
//						if(e instanceof EmptyFieldException ){
//							System.out.println("The Format is not correct");
//							System.out.print("Please enter a correct path:");
//							String x = sc.nextLine();
//							return HloadCardsFromFile(x, --c);
//						}else
//							if(e instanceof UnknownCardTypeException ){
//								System.out.println("The Format is not correct");
//								System.out.print("Please enter a correct path:");
//								String x = sc.nextLine();
//								return HloadCardsFromFile(x, --c);
//							}else{
//								System.out.println("The Format is not correct");
//								System.out.print("Please enter a correct path:");
//								String x = sc.nextLine();
//								return HloadCardsFromFile(x, --c);
//								}
//				}
//		}
//	}
	/*finally{
		return ReadingCSVFile.readCards(path);
	}*/
	/*if(path.equals("src/Database-Monsters.csv"))
		return ReadingCSVFile.readMonsterCard(path);
	else
		return ReadingCSVFile.readSpellCard(path);*/
	



private void buildDeck(ArrayList<Card> monsters, ArrayList<Card> spells){
	deck=new ArrayList<Card>();
	for(int i=0;i<15;i++){
		int q = (int) (Math.random()*monsters.size());
		Card temp = monsters.get(q).clone();
		temp.setLocation(Location.DECK);
		this.deck.add(temp);
	}
	for(int i=0;i<5;i++){
		int q = (int) (Math.random()*spells.size());
		Card temp = spells.get(q).clone();
		temp.setLocation(Location.DECK);
		this.deck.add(temp);
	}
	
}
private void shuffleDeck (){
	for(int i=0;i<30;i++){
		int q = (int) (Math.random()*20);
		this.deck.add(deck.remove(q));
	}
}
public ArrayList<Card> drawNCards(int n){
	ArrayList<Card> NCards=new ArrayList<Card>(n) ;
   	for(int i=0;i<n;i++){
   		Card temp = deck.remove(0);
   		NCards.add(temp);
   		System.out.println(deck.size());
   		CardHelp.fromDeckToHand(temp);
   	}
   	 return NCards;
}
public Card drawOneCard(){
	Card temp = deck.remove(0);
	CardHelp.fromDeckToHand(temp);
	return temp;
}
public ArrayList<Card> getDeck() {
	return deck;
}

public static ArrayList<Card> getMonsters() {
	return monsters;
}

public static void setMonsters(ArrayList<Card> monsters) {
	Deck.monsters = monsters;
}

public static ArrayList<Card> getSpells() {
	return spells;
}

public static void setSpells(ArrayList<Card> spells) {
	Deck.spells = spells;
}
public static String getMonstersPath() {
	return monstersPath;
}

public static void setMonstersPath(String monstersPath) {
	Deck.monstersPath = monstersPath;
}

public static String getSpellsPath() {
	return spellsPath;
}

public static void setSpellsPath(String spellsPath) {
	Deck.spellsPath = spellsPath;
}

/*public static void main(String[] args) throws IOException {
  	Deck d=new Deck();
  	System.out.println(d.getMonsters().size());
  }*/
/*public static void main(String[] args) throws IOException {
	Deck d=new Deck();
	d.loadCardsFromFile("src/Database-Monsters.csv");

}*/
//public static void main(String[] args) throws IOException, UnexpectedFormatException {
//	Deck d=new Deck();//Blue-Eyes White Dragon
//	d.loadCardsFromFile("gf");
//}
}

