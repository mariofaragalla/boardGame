package eg.edu.guc.yugioh.board;

import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class Board {
	private Player activePlayer;	
	private Player opponentPlayer;
	private Player winner;
    
public Board(){
	Card.setBoard(this);
	}
public void whoStarts(Player p1, Player p2) throws Exception{
     
     if(Math.random()*2<1){
    	 activePlayer=p1;
    	 opponentPlayer=p2;
     }
     else{ 
     	activePlayer=p2;
     	opponentPlayer=p1;
     }
}
public void startGame(Player p1, Player p2) throws Exception{
	p1.getField().addNCardsToHand(5);
	p2.getField().addNCardsToHand(5);
	whoStarts(p1,p2);
	activePlayer.getField().addCardToHand();
	activePlayer.getField().setPhase(Phase.MAIN1);
}
public void nextPlayer(){
	Player temp =  activePlayer;
	activePlayer = opponentPlayer;
	opponentPlayer = temp;
	activePlayer.getField().addCardToHand();
	activePlayer.getField().setPhase(Phase.MAIN1);
	for(int i=0;i<activePlayer.getField().getMonstersArea().size();i++){
		activePlayer.getField().getMonstersArea().get(i).setAttacked(false);
		activePlayer.getField().getMonstersArea().get(i).setChangOfMode(false);
	}
}

public Player getActivePlayer() {
	return activePlayer;
}
public void setActivePlayer(Player activePlayer) {
	this.activePlayer = activePlayer;
}
public Player getOpponentPlayer() {
	return opponentPlayer;
}
public void setOpponentPlayer(Player opponentPlayer) {
	this.opponentPlayer = opponentPlayer;
}
public Player getWinner() {
	return winner;
}
public void setWinner(Player winner) {
	this.winner = winner;
}
}
