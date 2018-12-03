package dnd.software;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


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
	private JMenuItem dmCreateNPC;
	private JMenuItem dmDeleteNPC;
	//TODO: Possibly Print methods
	private JMenuItem dmLogOut;
	//Players Menu
	private JMenuItem playerLogIn;
	private JMenuItem playerNewPlayer;
	private JMenuItem playerCreateChar;
	private JMenuItem playerXPTrans;
	private JMenuItem playerResourceTrans;
	//TODO: Possibly print methods?
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
		dmCreateNPC = new JMenuItem("Create NPC");
		dmDeleteNPC = new JMenuItem("Delete NPC");
		dmLogOut = new JMenuItem("Log Out");
		
		dmLogIn.addActionListener(new MenuListener());
		dmNewDM.addActionListener(new MenuListener());
		dmCreateNPC.addActionListener(new MenuListener());
		dmDeleteNPC.addActionListener(new MenuListener());
		dmLogOut.addActionListener(new MenuListener());
		
		dmMenu.add(dmLogIn);
		dmMenu.add(dmNewDM);
		dmMenu.add(dmCreateNPC);
		dmMenu.add(dmDeleteNPC);
		dmMenu.add(dmLogOut);
		
		//Player MenuItems
		playerLogIn = new JMenuItem("Log In");
		playerNewPlayer = new JMenuItem("New Player");
		playerCreateChar = new JMenuItem("Create Character");
		playerXPTrans = new JMenuItem("Make XP Transaction");
		playerResourceTrans = new JMenuItem("Make Resource Transaction");
		playerLogOut = new JMenuItem("Log Out");
		
		playerLogIn.addActionListener(new MenuListener());
		playerNewPlayer.addActionListener(new MenuListener());
		playerCreateChar.addActionListener(new MenuListener());
		playerXPTrans.addActionListener(new MenuListener());
		playerResourceTrans.addActionListener(new MenuListener());
		
		playersMenu.add(playerLogIn);
		playersMenu.add(playerNewPlayer);
		playersMenu.add(playerCreateChar);
		playersMenu.add(playerXPTrans);
		playersMenu.add(playerResourceTrans);
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
			else if(source.equals(playerLogIn)) {
				handleLogIn();
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
		private void handleDMLogIn() {
			//TODO: Prompt for username and password
			if(game != null) {
				//game.logInDM(aUsername, aPassword);
			}
		}
		
		private void handleLogIn() {
			//TODO: Prompt for username and password
			if(game != null) {
				//game.logInPlayer(aUsername, aPassword);
			}
		}
		
	}
	
	
}
