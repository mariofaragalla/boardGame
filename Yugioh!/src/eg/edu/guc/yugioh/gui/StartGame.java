package eg.edu.guc.yugioh.gui;
import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.*;

import eg.edu.guc.yugioh.listeners.StartButtons;

public class StartGame {
	public static void main(String[] args) throws FontFormatException, IOException {
		JFrame GameStart =new JFrame();
		
		
		GameStart.setSize(280, 400);
		GameStart.setLocation((int)(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-150,(int)(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-200);
		
		JPanel Open =new JPanel();
		
		JButton NewGame=new JButton("New Game");
		NewGame.setBounds(75,140,150,45);
		
		JButton Options=new JButton("Options");
		Options.setBounds(75,190,150,45);
		
		JButton Exit=new JButton("Exit");
		Exit.setBounds(75,240,150,45);
		GameStart.setUndecorated(true);
		Exit.addActionListener(new StartButtons());

           
            
           
            
//		Font yfont=new Font("",0,20);
//		File f=new File("src/Gota.ttf");
//		yfont.createFont(0,f);
		
//		NewGame.setOpaque(false);
//		NewGame.setContentAreaFilled(false);
//		NewGame.setBorderPainted(false);
//		NewGame.setFocusPainted(false);
//		NewGame.setFont(yfont);
		NewGame.addActionListener(new StartButtons());
//		Open.add(NewGame);
//		Open.add(Options);
//		Open.add(Exit);
    	Open.setLayout(null);
		
		JLabel StartLabel= new JLabel(new ImageIcon("src/Start2.jpg"));
		StartLabel.setBounds(-8,-20,300,400);
		Open.setBackground(Color.BLACK);
		
		
		StartLabel.setLayout(null);
		StartLabel.add(NewGame);
		StartLabel.add(Options);
		StartLabel.add(Exit);
		
		Open.add(StartLabel);
		
		GameStart.add(Open);
		//StartLabel.setVisible(true);
		//Open.setVisible(true);
		GameStart.setVisible(true);
	} 
	
}



