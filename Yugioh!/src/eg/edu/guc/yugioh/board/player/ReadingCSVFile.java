package eg.edu.guc.yugioh.board.player;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;








import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.CardDestruction;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.DarkHole;
import eg.edu.guc.yugioh.cards.spells.GracefulDice;
import eg.edu.guc.yugioh.cards.spells.HarpieFeatherDuster;
import eg.edu.guc.yugioh.cards.spells.HeavyStorm;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.PotOfGreed;
import eg.edu.guc.yugioh.cards.spells.Raigeki;
import eg.edu.guc.yugioh.exceptions.*;

  
  public class ReadingCSVFile {
	  /*public static ArrayList<Card> readSpellCard(String path) throws IOException{
		  ArrayList<Card> r=new ArrayList<Card>();
			String currentLine = "";
			FileReader fileReader= new FileReader(path);
			BufferedReader br = new BufferedReader(fileReader);
			while ((currentLine = br.readLine()) != null) {
				String[] s= currentLine.split(",");
				if(s[0].equals("Spell"))
				r.add((SpellCard)new SpellCard(s[1],s[2]));
				
			}
			br.close();
			return r;
	  }
	  
	  public static ArrayList<Card> readMonsterCard(String path) throws IOException{
		ArrayList<Card> r=new ArrayList<Card>();
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		while ((currentLine = br.readLine()) != null) {
			String[] s= currentLine.split(",");
			if(s[0].equals("Monster"))
			r.add((MonsterCard)new MonsterCard(s[1],s[2],Integer.parseInt(s[5]),Integer.parseInt(s[3]),Integer.parseInt(s[4])));
		}
		br.close();
		return r;
	   }/*/
	  public static ArrayList<Card> readCards(String path) throws IOException, UnexpectedFormatException{
			ArrayList<Card> r=new ArrayList<Card>();
			String currentLine = "";
			FileReader fileReader= new FileReader(path);
			BufferedReader br = new BufferedReader(fileReader);
			int c = 0;
			while ((currentLine = br.readLine()) != null) {
				c++;
				String[] s= currentLine.split(",");
				HEmptyFieldException(s,path,c,br);
				if(s[0].equals("Monster")){
					if(s.length != 6) {
						br.close();
						throw new MissingFieldException(path,c);
					}
					r.add(new MonsterCard(s[1],s[2],Integer.parseInt(s[5]),Integer.parseInt(s[3]),Integer.parseInt(s[4])));
				}
				else if((s[0].equals("Spell"))){
						if(s.length != 3) {br.close();
						throw new MissingFieldException(path,c);
						}
						switch(s[1]){
						case"Card Destruction": r.add(new CardDestruction(s[1],s[2]));break;
						case"Change Of Heart" : r.add(new ChangeOfHeart(s[1],s[2]));break;
						case"Dark Hole"       : r.add(new DarkHole(s[1],s[2]));break;
						case"Graceful Dice"   : r.add(new GracefulDice(s[1],s[2]));break;
						case"Harpie's Feather Duster":r.add(new HarpieFeatherDuster(s[1],s[2]));break;
						case"Heavy Storm"     : r.add(new HeavyStorm(s[1],s[2]));break;
						case"Mage Power"      : r.add(new MagePower(s[1],s[2]));break;
						case"Monster Reborn"  : r.add(new MonsterReborn(s[1],s[2]));break;
						case"Pot of Greed"    : r.add(new PotOfGreed(s[1],s[2]));break;
						case"Raigeki"         : r.add(new Raigeki(s[1],s[2]));break;
						default               : throw new UnknownSpellCardException(path,c,s[1]);
						}
					}
				else{ br.close(); throw new UnknownCardTypeException(path,c,s[0]);
				}
			}
			br.close();
			return r;
  }
	  public static void HEmptyFieldException(String[] s,String path,int c,BufferedReader br) throws EmptyFieldException, IOException {
		  for(int i=0;i<s.length;i++){
			if(s[i].equals("")) {br.close();
			throw new EmptyFieldException(path,c,i+1);}
			else{
				
				String[] spaces = s[i].split(" ");
				if(spaces.length == 0){
					br.close();
					throw new EmptyFieldException(path,c,i+1);
				}
			}
		}
	 }
}
  

