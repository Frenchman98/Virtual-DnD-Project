package dnd.software;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.*;

import dnd.character.*;
import dnd.players.*;



public class DnDGUI extends JFrame{
	private Game game;
	private JMenuBar menuBar;
	//Menu Bar Menus
	private JMenu fileMenu;
	private JMenu dmMenu;
	private JMenu playersMenu;
	//Menu- submenus
	//File Menu
	// private JMenuItem fileNewGame; //Is this needed?
	private JMenuItem fileLoad;
	private JMenuItem fileSave;
	private JMenuItem fileExit;
	//DM Menu
	private JMenuItem dmLogIn;
	private JMenuItem dmNewDM;
	private JMenuItem dmGiveXP;
	private JMenuItem dmGiveMoney;
	private JMenuItem dmCreateNPC;
	private JMenuItem dmDeleteNPC;
	private JMenuItem dmPrintAllInfo;
	private JMenuItem dmLogOut;
	//Players Menu
	private JMenuItem playerLogIn;
	private JMenuItem playerNewPlayer;
	private JMenuItem playerCreateChar;
	private JMenuItem playerXPTrans;
	private JMenuItem playerResourceTrans;
	private JMenuItem playerPrintInfo;
	private JMenuItem playerLogOut;
	
	public DnDGUI(String windowTitle, Game myGame) {
		super(windowTitle);
		game = myGame;
		setSize(550, 100);
		setLayout(new FlowLayout(FlowLayout.LEFT)); ////means going to read left to right
		add(new JLabel("<HTML><center>Welcome to the digital Dungeons and Dragons Character Creator and Transactions" +
				"<BR>Choose an action from the above menus.</center></HTML>")); //This is HTML form
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true); //Have to set it every time, default is false
		
	}
	
	public void buildGUI() {
		menuBar = new JMenuBar();
		
		//Menus
		fileMenu = new JMenu("File");
		dmMenu = new JMenu("Dungeon Master");
		playersMenu = new JMenu("Players");
		
		//Submenus
		//File menuitems
	//	fileNewGame = new JMenuItem("New Game");
		fileLoad = new JMenuItem("Load");
		fileSave = new JMenuItem("Save");
		fileExit = new JMenuItem("Exit");
		
	//	fileNewGame.addActionListener(new MenuListener());
		fileSave.addActionListener(new MenuListener());
		fileLoad.addActionListener(new MenuListener());
		fileExit.addActionListener(new MenuListener());
		
		//add to File Menu
		//fileMenu.add(fileNewGame);
		fileMenu.add(fileLoad);
		fileMenu.add(fileSave);
		fileMenu.add(fileExit);
		
		//DM menuitems
		dmLogIn = new JMenuItem("Log In");
		dmNewDM = new JMenuItem("New DM");
		dmGiveXP = new JMenuItem("Give Experience");
		dmGiveMoney = new JMenuItem("Give Money");
		dmCreateNPC = new JMenuItem("Create NPC");
		dmDeleteNPC = new JMenuItem("Delete NPC");
		dmPrintAllInfo = new JMenuItem("Print All Information");
		dmLogOut = new JMenuItem("Log Out");
		
		dmLogIn.addActionListener(new MenuListener());
		dmNewDM.addActionListener(new MenuListener());
		dmGiveXP.addActionListener(new MenuListener());
		dmGiveMoney.addActionListener(new MenuListener());
		dmCreateNPC.addActionListener(new MenuListener());
		dmDeleteNPC.addActionListener(new MenuListener());
		dmPrintAllInfo.addActionListener(new MenuListener());
		dmLogOut.addActionListener(new MenuListener());
		
		dmMenu.add(dmLogIn);
		dmMenu.add(dmNewDM);
		dmMenu.add(dmGiveXP);
		dmMenu.add(dmGiveMoney);
		dmMenu.add(dmCreateNPC);
		dmMenu.add(dmDeleteNPC);
		dmMenu.add(dmPrintAllInfo);
		dmMenu.add(dmLogOut);
		
		//Player MenuItems
		playerLogIn = new JMenuItem("Log In");
		playerNewPlayer = new JMenuItem("New Player");
		playerCreateChar = new JMenuItem("Create Character");
		playerXPTrans = new JMenuItem("Make XP Transaction");
		playerResourceTrans = new JMenuItem("Make Resource Transaction");
		playerPrintInfo = new JMenuItem("Print Player Information");
		playerLogOut = new JMenuItem("Log Out");
		
		playerLogIn.addActionListener(new MenuListener());
		playerNewPlayer.addActionListener(new MenuListener());
		playerCreateChar.addActionListener(new MenuListener());
		playerXPTrans.addActionListener(new MenuListener());
		playerResourceTrans.addActionListener(new MenuListener());
		playerPrintInfo.addActionListener(new MenuListener());
		playerLogOut.addActionListener(new MenuListener());
		
		playersMenu.add(playerLogIn);
		playersMenu.add(playerNewPlayer);
		playersMenu.add(playerCreateChar);
		playersMenu.add(playerXPTrans);
		playersMenu.add(playerResourceTrans);
		playersMenu.add(playerPrintInfo);
		playersMenu.add(playerLogOut);
		
		menuBar.add(fileMenu);
		menuBar.add(playersMenu);
		menuBar.add(dmMenu);
		
		setJMenuBar(menuBar);

		
	}
	
	private class MenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Find the source of the event (AKA which submenu got selected
			JMenuItem source = (JMenuItem)(e.getSource());
			if(source.equals(fileLoad)) {
				handleLoadFile();
				
			}
			else if(source.equals(fileSave)) {
				handleSaveFile();
				
			}
			else if(source.equals(fileExit)) {
				handleExitFile();
				
			}
			else if(source.equals(dmLogIn)) {
				handleDMLogIn();
			}
			else if(source.equals(dmLogOut)) {
				handleDMLogOut();
			}
			else if(source.equals(dmGiveMoney)) {
				handleDMMoney();
			}
			else if(source.equals(dmGiveXP)) {
				handleDMXP();
			}
			else if(source.equals(dmCreateNPC)) {
				handleCreateNPC();
			}
			else if(source.equals(dmDeleteNPC)) {
			//	handleDeleteNPC;
			}
			else if(source.equals(dmPrintAllInfo)) {
				handleDMPrint();
			}
			else if(source.equals(dmNewDM)) {
				handleDMCreation();
			}
			else if(source.equals(playerLogIn)) {
				handlePlayerLogIn();
			}
			else if(source.equals(playerLogOut)) {
				handlePlayerLogOut();
			}
			else if(source.equals(playerNewPlayer)) {
				handlePlayerCreation();
			}
			else if(source.equals(playerCreateChar)) {
				handleCharacterCreation();
			}
			else if(source.equals(playerPrintInfo)) {
				handlePlayerPrint();
			}
			
		}
		
		//Within MenuListener class, define methods that should be called in actionPerformed
		
		//Method for save Data in file menu
		private void handleSaveFile() {
			if(game != null) {
				Game.saveData(game);
			}
		}
				
		//Method of load data in file menu
		private void handleLoadFile() {
			game = Game.loadData();
		}
				
		//Method for exiting
		private void handleExitFile() {
			System.exit(0);
		}
		
		
		//Method of DM logging in
		//Prompts for a username and password
		private void handleDMLogIn() {
			JTextField dmUsername = new JTextField();
			JTextField dmPassword = new JTextField();
			String usernameSel;
			String passwordSel;	
			
			Object[]fields = {
				"Username:", dmUsername,
				"Password:", dmPassword
				
			};
										//Text&JText Fields, header title, OK CANCEL Options 
			JOptionPane.showConfirmDialog(null, fields, "Dungeon Master Log In", JOptionPane.OK_CANCEL_OPTION);
			usernameSel = dmUsername.getText();
			passwordSel = dmPassword.getText();
			
			//If there is a conflict want to have a popup
			//Use CustomPrintStream to have System.out.println (NOT PRINT) go to JOptionPanes
			CustomPrintStream printStream = new CustomPrintStream(); 
			PrintStream standard = System.out; //IMPORTANT FOR RESETING PRINT BACK TO CONSOLE
	        System.setOut(printStream); 
	        //Call DM log in
			game.logInDM(usernameSel, passwordSel);
	        System.setOut(standard);
		}
		
		private void handleDMLogOut() {
			//If there is a conflict want to have a popup
			//Use CustomPrintStream to have System.out.println (NOT PRINT) go to JOptionPanes
			CustomPrintStream printStream = new CustomPrintStream(); 
			PrintStream standard = System.out; //IMPORTANT FOR RESETING PRINT BACK TO CONSOLE
	        System.setOut(printStream); 
	        //Call DM log in
			game.logOutDM();
	        System.setOut(standard);
		}
		
		private void handleDMMoney() {
			if(game.dmLoggedIn) {
				JTextField playerUsername = new JTextField();
				JTextField amount = new JTextField();
				String usernameSel;
				int amountSel;	
				
				Object[]fields = {
					"Player Username:", playerUsername,
					"Amount:", amount
					
				};
											//Text&JText Fields, header title, OK CANCEL Options 
				JOptionPane.showConfirmDialog(null, fields, "Select Player and Amount", JOptionPane.OK_CANCEL_OPTION);
				usernameSel = playerUsername.getText();
				amountSel = Integer.parseInt(amount.getText());
				Player chosenPlayer = findPlayer(usernameSel);
				if(chosenPlayer == null) {
					JOptionPane.showMessageDialog(null, "Chosen player does not exist. Cannot give money to a player", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				else{
					//If there is a conflict want to have a popup
					//Use CustomPrintStream to have System.out.println (NOT PRINT) go to JOptionPanes
					CustomPrintStream printStream = new CustomPrintStream(); 
					PrintStream standard = System.out; //IMPORTANT FOR RESETING PRINT BACK TO CONSOLE
			        System.setOut(printStream); 
			        //Call player log in
					game.getTheDM().giveMoney(amountSel, chosenPlayer);
			        System.setOut(standard);
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "DM is not logged in. Cannot give money to a player", "Error", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handleDMXP() {
			if(game.dmLoggedIn) {
				JTextField playerUsername = new JTextField();
				JTextField amount = new JTextField();
				String usernameSel;
				int amountSel;	
				
				Object[]fields = {
					"Player Username:", playerUsername,
					"Amount:", amount
					
				};
											//Text&JText Fields, header title, OK CANCEL Options 
				JOptionPane.showConfirmDialog(null, fields, "Select Player and Amount", JOptionPane.OK_CANCEL_OPTION);
				usernameSel = playerUsername.getText();
				amountSel = Integer.parseInt(amount.getText());
				Player chosenPlayer = findPlayer(usernameSel);
				if(chosenPlayer == null) {
					JOptionPane.showMessageDialog(null, "Chosen player does not exist. Cannot give XP to a player", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				else{
					//If there is a conflict want to have a popup
					//Use CustomPrintStream to have System.out.println (NOT PRINT) go to JOptionPanes
					CustomPrintStream printStream = new CustomPrintStream(); 
					PrintStream standard = System.out; //IMPORTANT FOR RESETING PRINT BACK TO CONSOLE
			        System.setOut(printStream); 
			        //Call player log in
					game.getTheDM().giveExperience(amountSel, chosenPlayer);
			        System.setOut(standard);
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "DM is not logged in. Cannot give XP to a player", "Error", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handleDMCreation() {
			JTextField dmUsername = new JTextField();
			JTextField dmPassword = new JTextField();
			String usernameSel;
			String passwordSel;	
			
			Object[]fields = {
				"New Username:", dmUsername,
				"New Password:", dmPassword
				
			};
										//Text&JText Fields, header title, OK CANCEL Options 
			JOptionPane.showConfirmDialog(null, fields, "Dungeon Master Creation", JOptionPane.OK_CANCEL_OPTION);
			usernameSel = dmUsername.getText();
			passwordSel = dmPassword.getText();
			
			//If there is a conflict want to have a popup
			//Use CustomPrintStream to have System.out.println (NOT PRINT) go to JOptionPanes
			CustomPrintStream printStream = new CustomPrintStream(); 
			PrintStream standard = System.out; //IMPORTANT FOR RESETING PRINT BACK TO CONSOLE
	        System.setOut(printStream); 
	        //Call DM log in
			game.createDM(usernameSel, passwordSel);
	        System.setOut(standard);
	        
		}
		
		private void handleDMPrint() {
			if(game.dmLoggedIn)
			{
				//Using JTextArea for this
				//Use CustomPrintStream to have System.out.println (NOT PRINT) go to JOptionPanes					//JTextArea - multiline area that displays plain text
				//Constructor (int, int) specified rows and columns
				JTextArea textArea = new JTextArea(18, 45); 
				textArea.setEditable(false);						
				//Need scroll bar
				JScrollPane scrollBar = new JScrollPane(textArea);
				//Always vertical
				scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);					
				//PrintStream will be used as our new "out" for System.out.print and println statements
				PrintStream stream = new PrintStream(new WindowOutputStream(textArea));
				PrintStream standard = System.out; //IMPORTANT FOR RESETING PRINT BACK TO CONSOLE
				System.setOut(stream); //Set the new "out"
				//Call the print function
				game.printAllInfo();				
				//University info Header
				JOptionPane.showMessageDialog(null, scrollBar, "Game Info", JOptionPane.PLAIN_MESSAGE);
				System.setOut(standard); //Reset out. Is this needed?		
			}
			else {
				JOptionPane.showMessageDialog(null, "DM is not logged in. Cannot print all information", "Error", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handleCreateNPC() {
			if(game.playerLoggedIn) {
				JOptionPane.showMessageDialog(null, "DM is logged in. Cannot create player's character", "Error", JOptionPane.PLAIN_MESSAGE);
			}
			else if(game.dmLoggedIn) {
				JTextField charName = new JTextField();
				JTextField charRace = new JTextField();
				String charNameSel;
				String charRaceSel;						
				Object[]fields = {
					"Character Name: ", charName,
					"Character Race (Human, Elf, Halfling, Dwarf):", charRace
					
				};
											//Text&JText Fields, header title, OK CANCEL Options 	
				JOptionPane.showConfirmDialog(null, fields, "NPC Creation", JOptionPane.OK_CANCEL_OPTION);
				charNameSel = charName.getText();
				charRaceSel = charRace.getText();
				if(!(charRaceSel.equals("Human") || charRaceSel.equals("Elf") || charRaceSel.equals("Halfling") || charRaceSel.equals("Dwarf"))) {
					JOptionPane.showMessageDialog(null, "You must have a Human, Elf, Halfling, or Dwarf Character", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				else{
					//If there is a conflict want to have a popup
					//Use CustomPrintStream to have System.out.println (NOT PRINT) go to JOptionPanes
					CustomPrintStream printStream = new CustomPrintStream(); 
					PrintStream standard = System.out; //IMPORTANT FOR RESETING PRINT BACK TO CONSOLE
			        System.setOut(printStream); 
			        //Call player log in
			        GameChar newNPC = new GameChar(charNameSel, charRaceSel);
					(game.getTheDM()).createNPC(newNPC);
			        System.setOut(standard);
				}
					
			}
			else {
				JOptionPane.showMessageDialog(null, "No one is logged in. Cannot create NPC", "Error", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		//Method of player logging in
		//Prompts for a username and password
		private void handlePlayerLogIn() {
			JTextField playerUsername = new JTextField();
			JTextField playerPassword = new JTextField();
			String usernameSel;
			String passwordSel;	
			
			Object[]fields = {
				"Username:", playerUsername,
				"Password:", playerPassword
				
			};
										//Text&JText Fields, header title, OK CANCEL Options 
			JOptionPane.showConfirmDialog(null, fields, "Player Log In", JOptionPane.OK_CANCEL_OPTION);
			usernameSel = playerUsername.getText();
			passwordSel = playerPassword.getText();
			
			//If there is a conflict want to have a popup
			//Use CustomPrintStream to have System.out.println (NOT PRINT) go to JOptionPanes
			CustomPrintStream printStream = new CustomPrintStream(); 
			PrintStream standard = System.out; //IMPORTANT FOR RESETING PRINT BACK TO CONSOLE
	        System.setOut(printStream); 
	        //Call player log in
			game.logInPlayer(usernameSel, passwordSel);
	        System.setOut(standard);
		}
		
		private void handlePlayerLogOut() {
			//If there is a conflict want to have a popup
			//Use CustomPrintStream to have System.out.println (NOT PRINT) go to JOptionPanes
			CustomPrintStream printStream = new CustomPrintStream(); 
			PrintStream standard = System.out; //IMPORTANT FOR RESETING PRINT BACK TO CONSOLE
	        System.setOut(printStream); 
	        //Call DM log in
	        game.logOutPlayer();
	        System.setOut(standard);
		}
		
		private void handlePlayerCreation() {
			JTextField playerUsername = new JTextField();
			JTextField playerPassword = new JTextField();
			String usernameSel;
			String passwordSel;	
			
			Object[]fields = {
				"Username:", playerUsername,
				"Password:", playerPassword
				
			};
										//Text&JText Fields, header title, OK CANCEL Options 
			JOptionPane.showConfirmDialog(null, fields, "Player Creation", JOptionPane.OK_CANCEL_OPTION);
			usernameSel = playerUsername.getText();
			passwordSel = playerPassword.getText();
			
			//If there is a conflict want to have a popup
			//Use CustomPrintStream to have System.out.println (NOT PRINT) go to JOptionPanes
			CustomPrintStream printStream = new CustomPrintStream(); 
			PrintStream standard = System.out; //IMPORTANT FOR RESETING PRINT BACK TO CONSOLE
	        System.setOut(printStream); 
	        //Call player log in
			game.createPlayer(usernameSel, passwordSel);
	        System.setOut(standard);
		}
		
		private void handleCharacterCreation() {
			if(game.dmLoggedIn) {
				JOptionPane.showMessageDialog(null, "DM is logged in. Cannot create player's character", "Error", JOptionPane.PLAIN_MESSAGE);
			}
			else if(game.playerLoggedIn) {
				Player currentPlayer = findPlayerLoggedIn();
				if(currentPlayer == null) {
					JOptionPane.showMessageDialog(null, "Cannot find what Player is currently logged in", "Error", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JTextField charName = new JTextField();
					JTextField charRace = new JTextField();
					String charNameSel;
					String charRaceSel;	
					
					Object[]fields = {
						"Character Name: ", charName,
						"Character Race (Human, Elf, Halfling, Dwarf):", charRace
						
					};
												//Text&JText Fields, header title, OK CANCEL Options 
					JOptionPane.showConfirmDialog(null, fields, "Player Creation", JOptionPane.OK_CANCEL_OPTION);
					charNameSel = charName.getText();
					charRaceSel = charRace.getText();
					if(!(charRaceSel.equals("Human") || charRaceSel.equals("Elf") || charRaceSel.equals("Halfling") || charRaceSel.equals("Dwarf"))) {
						JOptionPane.showMessageDialog(null, "You must have a Human, Elf, Halfling, or Dwarf Character", "Error", JOptionPane.PLAIN_MESSAGE);
					}
					else{
						//If there is a conflict want to have a popup
						//Use CustomPrintStream to have System.out.println (NOT PRINT) go to JOptionPanes
						CustomPrintStream printStream = new CustomPrintStream(); 
						PrintStream standard = System.out; //IMPORTANT FOR RESETING PRINT BACK TO CONSOLE
				        System.setOut(printStream); 
				        //Call player log in
						currentPlayer.createCharacter(charNameSel, charRaceSel);
				        System.setOut(standard);
					}
					
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "No one is logged in. Cannot create player's character", "Error", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		private void handlePlayerPrint() {
			String playerName;
			//Label is "INput Pay Rate?" for Pane
			//"Player username" is label name for textbox
			playerName = JOptionPane.showInputDialog(null, "Player Username: ", "Print Player Information", JOptionPane.QUESTION_MESSAGE);
			if(playerName != null)
			{
				//If you put nothing but click okay
				if(playerName.trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, 
												"Please enter correct Player name", 
												"Error Player does not exist", 
												JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					Player thePlayer = findPlayerLoggedIn();
					if(thePlayer == null || !(thePlayer.getUsername().equals(playerName)))
					{
						JOptionPane.showMessageDialog(null,
													"Player  \""+playerName+"\" isn't logged in or doesn't exist.",
													"Error ",
													JOptionPane.PLAIN_MESSAGE);
					}
					//If we found the player, print
					else
					{
						//Using JTextArea for this
						//Use CustomPrintStream to have System.out.println (NOT PRINT) go to JOptionPanes
						//JTextArea - multiline area that displays plain text
						//Constructor (int, int) specified rows and columns
						JTextArea textArea = new JTextArea(18, 45); 
						textArea.setEditable(false);
						
						//Need scroll bar
						JScrollPane scrollBar = new JScrollPane(textArea);
						//Always vertical
						scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						
						//PrintStream will be used as our new "out" for System.out.print and println statements
						PrintStream stream = new PrintStream(new WindowOutputStream(textArea));
						PrintStream standard = System.out; //IMPORTANT FOR RESETING PRINT BACK TO CONSOLE
						System.setOut(stream); //Set the new "out"
						
						//Call the print function
						game.printAllInfo();
						
						//University info Header
						JOptionPane.showMessageDialog(null, scrollBar, "Player Info", JOptionPane.PLAIN_MESSAGE);
						System.setOut(standard); //Reset out. Is this needed?
						
					}
				}
			}
		}
		
	}
	
	private Player findPlayerLoggedIn() {
		for(Player myP : game.getThePlayers()) {
			if(myP.isLoggedIn()) {
				return myP;
			}
		}
		return null;
	}
	
	private Player findPlayer(String username) {
		for(Player myP : game.getThePlayers()) {
			if((myP.getUsername()).equals(username)) {
				return myP;
			}
		}
		return null;
	}
	
	//To handle JTextArea messages for System.outs
	private class WindowOutputStream extends OutputStream{
		private JTextArea text;
		public WindowOutputStream(JTextArea t) {
		text = t;
	
		}
		//Need a write function
		public void write(int a) throws IOException{
			text.append(String.valueOf((char)a));
			text.setCaretPosition(text.getDocument().getLength());
		}
	}
	
	//To handle JOptionPane messages for System.outs
	public class CustomPrintStream extends PrintStream {  
	    public CustomPrintStream() {  		      
	    	super(new ByteArrayOutputStream());  
		}  
	    public void println(String msg) {  
	        JOptionPane.showMessageDialog(null, msg);  		    
	    }  
	}  

	
	
}
