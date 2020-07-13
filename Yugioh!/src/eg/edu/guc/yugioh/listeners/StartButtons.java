package eg.edu.guc.yugioh.listeners;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.awt.Color;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.gui.GameBoard;
import eg.edu.guc.yugioh.gui.TheGame;


public class StartButtons implements ActionListener  {
	AudioInputStream audioInputStream1;
	AudioInputStream audioInputStream2;
	Clip clip ;
	JLabel sureExit;
	 static int i=0;
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Exit"){
			/*
		JFrame exit=new JFrame();
		exit.setVisible(true);
		exit.setResizable(false);
		exit.setAutoRequestFocus(true);
		JButton Yes =new JButton("Yes");
		JButton No =new JButton("No");
		JLabel exitPicture =new JLabel(new ImageIcon("src/Exit.jpg"));
		sureExit=new JLabel("Are you sure you want to exit?");
		
		exit.setTitle("Exit");
		exit.setBounds((int)Math.random()*100, (int)Math.random()*100, 400, 220);
		exit.setLayout(null);
		
		exitPicture.setBounds(exit.getX(),exit.getY(),exit.getWidth(),exit.getHeight());
		sureExit.setBounds(0,0,exit.getWidth(),30);
		sureExit.setFont(new Font( "Gota", Font.PLAIN, 20));
		Yes.setBounds(20,150, 60, 30);
		No.setBounds(320,150, 60, 30);
		No.setFocusable(false);
		
		exitPicture.add(sureExit);
		exit.add(exitPicture);
		exit.add(No);
		exit.add(Yes);
		Yes.addActionListener(this);
		No.addActionListener(this);
		
		
		if(e.getActionCommand()=="Yes")
			System.exit(0);
		else if(e.getActionCommand()=="No")
			exit.setVisible(false);
			*/
			System.exit(0);
			
			}
		else if(e.getActionCommand()=="New Game") {
				GameBoard.main(null);
			try {
				audioInputStream1 = AudioSystem.getAudioInputStream(new File("src/Start1.wav"));
	            clip = AudioSystem.getClip( );
//	            AudioPlayer.player.start(audioInputStream1);
	            clip.open(audioInputStream1);
	            clip.start();
	            clip.loop(Clip.LOOP_CONTINUOUSLY);	            
	        }
	        catch(Exception e1)  {
	            e1.printStackTrace( );
	        }
			
		
			}
			else if(e.getActionCommand()=="S"){
			  
			  
			  if(GameBoard.getPlayer1().getText().length()==0 || GameBoard.getPlayer2().getText().length()==0){
				  	 	JFrame f =new JFrame();
				  	 	JOptionPane.showMessageDialog(f,"Both Players must enter their names"); 
				}else if(GameBoard.getPlayer1().getText().charAt(0)==(' ')||GameBoard.getPlayer1().getText().charAt(0)==(' ')){
						JFrame f =new JFrame();
						JOptionPane.showMessageDialog(f,"You can not add space as the first character in the player name"); 
			}else{ 
				/*  try {
				  	
//				  		clip.stop();
					  	audioInputStream1 = AudioSystem.getAudioInputStream(new File("src/Match(1).wav"));
					  	clip = AudioSystem.getClip( );
			            AudioPlayer.player.start(audioInputStream2);  
			            clip.open(audioInputStream1);
			            clip.start();
			         	clip.loop(Clip.LOOP_CONTINUOUSLY);
			            
			        }
			        catch(Exception e1)  {
				  e1.printStackTrace( );
			        }
				 */ 
				  GameBoard.getP1().setVisible(false); 
				  
				  try {
					TheGame.createBoardwithPlayers(GameBoard.getPlayer1().getText(), GameBoard.getPlayer2().getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  GameBoard.getGameBoard().add(GameBoard.addP2(GameBoard.getPlayer1().getText(), GameBoard.getPlayer2().getText()));
			  
			  }
			 
		
			}else if(e.getActionCommand().equals("End Turn")){
				Card.getBoard().getActivePlayer().endTurn();
				if(i<=18){
				if((i%2)==0){
				JFrame f =new JFrame();
				JOptionPane.showMessageDialog(f,"Player1 turn"); 
				i++;
				f.setVisible(true);}
				else{ JFrame f =new JFrame();
				JOptionPane.showMessageDialog(f,"Player2 turn"); 
				i++;
				f.setVisible(true);}
				}
				else if(i>=18){
					JFrame f =new JFrame();
					f.setLayout(new FlowLayout());
					f.setBounds(300, 300, 400, 400);
					JButton b= new JButton("S");
					b.addActionListener(this);
					b.setSize(30,30);
					b.setPreferredSize(new Dimension(100,60));
					JButton b1= new JButton("Exit");
					b1.addActionListener(this);
					b1.setSize(30,30);
					b1.setPreferredSize(new Dimension(100,60));
					f.add(b);
					f.add(b1);
					f.setVisible(true);
				}
			}
			else if(e.getActionCommand().equals("End Phase")){
				Card.getBoard().getActivePlayer().endPhase();
				JFrame f =new JFrame();
				if(Card.getBoard().getActivePlayer().getField().getPhase()==Phase.BATTLE)
				JOptionPane.showMessageDialog(f,"Battle phase"); 
				 if(Card.getBoard().getActivePlayer().getField().getPhase()==Phase.MAIN1)
					JOptionPane.showMessageDialog(f,"MAIN1 phase"); 
				if(Card.getBoard().getActivePlayer().getField().getPhase()==Phase.MAIN2)
					JOptionPane.showMessageDialog(f,"MAIN2 phase"); 
				f.setVisible(true);
			}
		}
	}
		
	


