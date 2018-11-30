package dnd.software;

import java.awt.FlowLayout;

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
	private JMenuItem fileLoad;
	private JMenuItem fileSave;
	private JMenuItem fileExit;
	//DM Menu
	private JMenuItem dmLogIn;
	private JMenuItem dmCreateNPC;
	private JMenuItem dmDeleteNPC;
	//TODO: Possibly Print methods
	private JMenuItem dmLogOut;
	//Players Menu
	private JMenuItem playerLogIn;
	private JMenuItem playerCreateCharacter;
	private JMenuItem playerXPTransaction;
	private JMenuItem playerResourceTransaction;
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
		
	}
	
	
}
