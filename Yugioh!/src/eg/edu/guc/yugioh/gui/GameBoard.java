package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.listeners.StartButtons;

public class GameBoard {
	private static JFrame GameBoard;
	private static JPanel P1;
	private static JPanel P2;
	private static JTextField Player1;
	private static JTextField Player2;
	private static boolean [][] checkBoard ;
	
	private static JLabel Hand1;
	private static JLabel Hand2;
	private static JLabel Spell1;
	private static JLabel Spell2;
	private static JLabel Monster1;
	private static JLabel Monster2;
	
	private static int screenWidth = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static int screenHeight =(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	private static Board b;
	private static Player p1;
	private static Player p2;
	public static JPanel addP1(){
		P1=new JPanel();
		ImageIcon Im1=new ImageIcon("src/P.png");
		Im1.setImage(Im1.getImage().getScaledInstance(screenWidth, screenHeight, 0));
		
		JLabel ChoosePlayer =new JLabel(Im1);
		JButton StartGame=new JButton("S");
		
		ImageIcon Im2=new ImageIcon("src/Start3.png");
		JLabel StartGameImage= new JLabel(Im2);
		
		StartGame.add(StartGameImage);
		StartGame.setToolTipText("Start a new game");
		StartGame.addActionListener(new StartButtons());
		
		Player1 = new JTextField("");
		Player1.setToolTipText("Player1 please enter your name here");
	   
		Player2 = new JTextField("");
		Player2.setToolTipText("Player2 please enter your name here");
		
		ChoosePlayer.setBounds(0,0,screenWidth,screenHeight);
		Player1.setBounds(((int)(screenWidth*281.5)/1366), ((screenHeight*152)/768), (screenWidth*210)/1366, (screenHeight*30)/768);
		Player2.setBounds(((screenWidth*863)/1366), ((screenHeight*152)/768), (screenWidth*210)/1366,(screenHeight*30)/768);
		StartGame.setBounds(((screenWidth*466)/1366), ((screenHeight*468)/768),((screenWidth* 350)/1366),(screenHeight*200)/768);
		Im2.setImage(Im2.getImage().getScaledInstance(StartGame.getWidth()-50, StartGame.getHeight()-30, 0));
		
		StartGame.setBorderPainted(false);
		StartGame.setContentAreaFilled(false);
		StartGame.setCursor(new Cursor(12)); //12=Hand cursor
		StartGame.setContentAreaFilled(false);
		StartGame.setOpaque(false);
		
		
		ChoosePlayer.add(Player1);
		ChoosePlayer.add(Player2);
		ChoosePlayer.add(StartGame);
		P1.setLayout(null);
		P1.add(ChoosePlayer);
		
		P1.setBounds(0,0,ChoosePlayer.getWidth(),ChoosePlayer.getHeight());
		P1.setPreferredSize(new Dimension(GameBoard.getWidth(),GameBoard.getHeight()));
		
		return P1;
	}
	
	public static JPanel addP2(String x,String y){
		P2=new JPanel();
		JLabel Player1LifePoints=new JLabel(TheGame.getP1().getLifePoints()+"");
		JLabel Player2LifePoints=new JLabel(TheGame.getP2().getLifePoints()+"");
		
		checkBoard = new boolean [4][5];
		
		Hand1=new JLabel("Hand1");
		Hand2=new JLabel("Hand2");
		Monster1=new JLabel("Monster1");
		Monster2=new JLabel("Monster2");
		Spell1=new JLabel("Spell1");
		Spell2=new JLabel("Spell2");
		
		Hand1.setBounds((screenWidth*170)/1366, (screenHeight*669)/768, (screenWidth*1196)/1366, (screenHeight*156)/768);
		Hand2.setBounds((screenWidth*170)/1366, (screenHeight*-25)/768, (screenWidth*1196)/1366, (screenHeight*156)/768);
		Monster1.setBounds((screenWidth*745)/1366, (screenHeight*400)/768, (screenWidth*451)/1366, (screenHeight*156)/768);
		Monster2.setBounds((screenWidth*745)/1366, (screenHeight*243)/768, (screenWidth*451)/1366, (screenHeight*156)/768);
		Spell1.setBounds((screenWidth*745)/1366, (screenHeight*533)/768, (screenWidth*451)/1366, (screenHeight*156)/768);
		Spell2.setBounds((screenWidth*745)/1366, (screenHeight*110)/768, (screenWidth*451)/1366, (screenHeight*156)/768);
		
		/*Hand1.setSize(new Dimension((screenWidth*1196)/1366, (screenHeight*156)/768));
		Hand2.setSize(new Dimension((screenWidth*1196)/1366, (screenHeight*156)/768));
		Monster1.setSize(new Dimension((screenWidth*451)/1366, (screenHeight*156)/768));
		Monster2.setSize(new Dimension((screenWidth*451)/1366, (screenHeight*156)/768));
		Spell1.setSize(new Dimension((screenWidth*451)/1366, (screenHeight*156)/768));
		Spell2.setSize(new Dimension((screenWidth*451)/1366, (screenHeight*156)/768));*/
		
		
		JButton endTurn=new JButton("End Turn");
		JButton endPhase=new JButton("End Phase");
		JButton Exit=new JButton("Exit");
		Exit.addActionListener(new StartButtons());
		JLabel Deck1=new JLabel("Deck1");
		JLabel Deck2=new JLabel("Deck2");
		JButton trail=new JButton("trail");
		JButton trail2=new JButton("trail");
		
		endTurn.addActionListener(new StartButtons());
		endPhase.addActionListener(new StartButtons());
		
		endTurn.setBounds((screenWidth*618)/1366, (screenHeight*309)/768, (screenWidth*110)/1366,(screenHeight*154)/768);
		endPhase.setBounds((screenWidth*493)/1366, (screenHeight*309)/768, (screenWidth*110)/1366,(screenHeight*154)/768);
		Exit.setBounds((screenWidth*368)/1366, (screenHeight*309)/768, (screenWidth*110)/1366,(screenHeight*154)/768);
		Deck1.setBounds((screenWidth*528)/1366,(screenHeight*145)/768, (screenWidth*110)/1366,(screenHeight*160)/768);
		Deck2.setBounds((screenWidth*528)/1366, (screenHeight*469)/768, (screenWidth*110)/1366,(screenHeight*160)/768);
		trail.setPreferredSize(new Dimension(110,125));
		trail2.setPreferredSize(new Dimension(110,125));
		
		ImageIcon Im1 =new ImageIcon("src/kw.png");
		Im1.setImage(Im1.getImage().getScaledInstance(screenWidth, screenHeight, 0));
		JLabel Board= new JLabel(Im1);
		Board.setLayout(null);
		Board.setBounds(0,0,screenWidth,screenHeight);
		JLabel Player1=new JLabel(x);
		JLabel Player2=new JLabel(y);
		
		Player1.setBounds(20,20,150,80);
		Player1.setToolTipText("Player1 name");
		Player1.setFont(new Font( "Gota", Font.PLAIN, 25));
		Player1.setForeground(Color.ORANGE);
		Player1LifePoints.setToolTipText("Player1 lifePoints");
		Player1LifePoints.setFont(new Font( "Gota", Font.PLAIN, 25));
		Player1LifePoints.setForeground(Color.ORANGE);
		Player1LifePoints.setBounds(20,40,150,150);
		
		Player2.setBounds(20,(screenHeight-150),150,80);
		Player2.setToolTipText("Player2 name");
		Player2.setFont(new Font("Gota", Font.PLAIN, 25));
		Player2.setForeground(Color.ORANGE);
		Player2LifePoints.setToolTipText("Player2 lifePoints");
		Player2LifePoints.setFont(new Font( "Gota", Font.PLAIN, 25));
		Player2LifePoints.setForeground(Color.ORANGE);
		Player2LifePoints.setBounds(20,screenHeight-150+20,150,150);
		
		
		P2.setLayout(null);
		P2.setBounds(0,0,Board.getWidth(),Board.getHeight());
		P2.setPreferredSize(new Dimension(GameBoard.getWidth(),GameBoard.getHeight()));
		
		FlowLayout s=new FlowLayout();
		FlowLayout s1=new FlowLayout();
		s.setHgap(-13);
		s1.setHgap(13);
		Hand1.setLayout(s);
		Hand2.setLayout(s);
		Monster1.setLayout(s1);
		Monster2.setLayout(s1);
		Spell1.setLayout(s1);
		Spell2.setLayout(s1);
		
		Board.add(Hand1);
		Board.add(Hand2);
		Board.add(Monster1);
		Board.add(Monster2);
		Board.add(Spell1);
		Board.add(Spell2);
		
		
		Board.add(Player1);
		Board.add(Player1LifePoints);
		Board.add(Player2);
		Board.add(Player2LifePoints);
		Board.add(endTurn);
		Board.add(endPhase);
		Board.add(Exit);
		Board.add(Deck1);
		Board.add(Deck2);
		
		//Board.add(trail);
		
		
		
		P2.add(Board);
		
		P2.setVisible(true);
		b=new Board();
		
		try{
		p1 =new Player(x);
		p2 =new Player(y);
		b.startGame(p1, p2);
		System.out.println("sjs");
		}catch(Exception e){
			e.printStackTrace();
		}
		return P2;
	}
	
	public static void main(String[] args) {
//		if(args==null){
	     GameBoard=new JFrame();
//		GameBoard.setSize(900, 900);
//		GameBoard.setResizable(true);
		GameBoard.setExtendedState(JFrame.MAXIMIZED_BOTH);
		GameBoard.setUndecorated(true);
		
//		GameBoard.setLayout(null);
//		GameBoard.add(P2);
		
		GameBoard.setLayout(null);
		GameBoard.add(addP1());
		
		GameBoard.setVisible(true);
		
		
	}
//		else{
//			JFrame GameBoard2=new JFrame();
////		GameBoard.setSize(900, 900);
////		GameBoard.setResizable(true);
//		GameBoard2.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		GameBoard2.setUndecorated(true);	
//		JPanel P2 =new JPanel();
//		P2.setBounds(0,0,GameBoard2.getWidth(),GameBoard2.getHeight());
//		GameBoard2.add(P2);
//	}
//}
	
	public static JPanel getP1() {
		return P1;
	}

	public static JTextField getPlayer1() {
		return Player1;
	}

	public static void setPlayer1(JTextField player1) {
		Player1 = player1;
	}

	public static JTextField getPlayer2() {
		return Player2;
	}

	public static void setPlayer2(JTextField player2) {
		Player2 = player2;
	}

	public static JFrame getGameBoard() {
		return GameBoard;
	}

	public static void setGameBoard(JFrame gameBoard) {
		GameBoard = gameBoard;
	}

	public static void setP1(JPanel p1) {
		P1 = p1;
	}

	public static JPanel getP2() {
		return P2;
	}

	public static void setP2(JPanel p2) {
		P2 = p2;
	}

	public static boolean[][] getCheckBoard() {
		return checkBoard;
	}

	public static JLabel getHand1() {
		return Hand1;
	}

	public static void setHand1(JLabel hand1) {
		Hand1 = hand1;
	}

	public static JLabel getHand2() {
		return Hand2;
	}

	public static void setHand2(JLabel hand2) {
		Hand2 = hand2;
	}

	public static JLabel getSpell1() {
		return Spell1;
	}

	public static void setSpell1(JLabel spell1) {
		Spell1 = spell1;
	}

	public static JLabel getSpell2() {
		return Spell2;
	}

	public static void setSpell2(JLabel spell2) {
		Spell2 = spell2;
	}

	public static JLabel getMonster1() {
		return Monster1;
	}

	public static void setMonster1(JLabel monster1) {
		Monster1 = monster1;
	}

	public static JLabel getMonster2() {
		return Monster2;
	}

	public static void setMonster2(JLabel monster2) {
		Monster2 = monster2;
	}


}
