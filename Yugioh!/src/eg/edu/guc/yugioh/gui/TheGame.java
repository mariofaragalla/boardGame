package eg.edu.guc.yugioh.gui;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class TheGame {
	private static Board b;
	private static Player p1;
	private static Player p2;
	
	public static void createBoardwithPlayers(String p1Name,String p2Name) throws Exception{
		// b=new Board();
		 p1 =new Player(p1Name);
		 p2 =new Player(p2Name);
		 GameBoard.addP2(p1Name,p2Name);
		// b.startGame(p1, p2);
//		 p1=Card.getBoard().getActivePlayer();
//		 p2=Card.getBoard().getOpponentPlayer();
	}
	
	
	
	
	
	
	
	
	
	public static Board getB() {
		return b;
	}
	public static void setB(Board b) {
		TheGame.b = b;
	}
	public static Player getP1() {
		return p1;
	}
	public static void setP1(Player p1) {
		TheGame.p1 = p1;
	}
	public static Player getP2() {
		return p2;
	}
	public static void setP2(Player p2) {
		TheGame.p2 = p2;
	}
	
	
}
