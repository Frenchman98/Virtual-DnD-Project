package dnd.software;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


import dnd.players.*;

public class Game implements Serializable{
	private DungeonMaster theDM;
	private ArrayList<Player> thePlayers;
	boolean playerLoggedIn = false;
	boolean dmLoggedIn = false;
	//TODO: Other attributes needed? Armor? Resources? Weapons?
	public Game() {
		theDM = new DungeonMaster();
		thePlayers = new ArrayList<Player>();
	}
	
	public Game(String dmUsername, String dmPassword) {
		theDM = new DungeonMaster();
		theDM.setUsername(dmUsername);
		theDM.setPassword(dmPassword);
		thePlayers = new ArrayList<Player>();
	}
	
	public void createDM(String aUsername, String aPassword) {
		if(theDM != null) {
			System.out.println("The DM " + theDM.getUsername() + " already exists.");
		}
		else {
			theDM = new DungeonMaster(aUsername, aPassword);
		}
	}
	
	public void createPlayer(String aUsername, String aPassword) {
		Player newPlayer = new Player(aUsername, aPassword);
		this.addPlayer(newPlayer);
	}
	
	public DungeonMaster getTheDM() {
		return theDM;
	}

	public void setTheDM(DungeonMaster theDM) {
		this.theDM = theDM;
	}

	public ArrayList<Player> getThePlayers() {
		return thePlayers;
	}

	public void setThePlayers(ArrayList<Player> thePlayers) {
		this.thePlayers = thePlayers;
	}

	public void addPlayer(Player myPlayer) {
		for(Player myP : thePlayers) {
			if((myP.getUsername()).equals(myPlayer.getUsername())) {
				System.out.println("Player " + myP.getUsername() + " already exists.");
				return;
			}
		}
		thePlayers.add(myPlayer);
	}
	
	public void removePlayer(Player myPlayer) {
		thePlayers.remove(myPlayer);
	}
	
	public void logInPlayer(String aUsername, String aPassword) {
		boolean foundPlayer = false;
		if(dmLoggedIn) {
			System.out.println("The DM is currently logged in.");
		}
		else if(playerLoggedIn) {
			System.out.println("A player is already logged in.");
		}
		else {
			for(Player myP : thePlayers) {
				if((myP.getUsername()).equals(aUsername)) {
					foundPlayer = true;
					myP.logIn(aUsername, aPassword);
					playerLoggedIn = myP.isLoggedIn();
				}
			}
			if(!foundPlayer) {
				System.out.println("Player with username " + aUsername + " does not exist.");
			}
		}
	}
	
	public void logInDM(String aUsername, String aPassword) {
		if(playerLoggedIn) {
			System.out.println("A player is currently logged in.");
		}
		else if(dmLoggedIn) {
			System.out.println("The DM is already logged in.");
		}
		else {
			theDM.logIn(aUsername, aPassword);
			dmLoggedIn = theDM.isLoggedIn();
		}
	}
	
	public void logOutDM() {
		if(playerLoggedIn) {
			System.out.println("A player is currently logged in. Cannot log out.");
		}
		else if(!dmLoggedIn) {
			System.out.println("The DM is not logged in. Cannot log out.");
		}
		else
		{
			theDM.logOut();
			dmLoggedIn = theDM.isLoggedIn();
			System.out.println("Successfully logged out the DM.");
		}
	}
	
	public void logOutPlayer() {
		if(playerLoggedIn) {
			for(Player myP : thePlayers) {
				if(myP.isLoggedIn()) {
					myP.logOut();
					playerLoggedIn = myP.isLoggedIn();
					System.out.println("Successfully logged out player " + myP.getUsername() );
					return;
				}
			}
			System.out.println("Could not find the logged in player.");
		}
		else if(dmLoggedIn) {
			System.out.println("The DM is currently logged in. Cannot log out.");
		}
		else
		{
			System.out.println("A player is not logged in. Cannot log out.");
		}
	}
	//TODO: Printing methods? Are they needed?

	public static Game loadData() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Game aGame = null;
		
		try {
			fileIn = new FileInputStream("Game.ser");
			objIn = new ObjectInputStream(fileIn);
			aGame = (Game) objIn.readObject(); //serialized from the object
			objIn.close();
			fileIn.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
			
		}
		catch(ClassNotFoundException c){
			c.printStackTrace(); //print if cannot find the class
		}
		
		return aGame;
		
	}
	
	public static void saveData(Game aGame) {
		try 
			{
				FileOutputStream fileOut = new FileOutputStream("Game.ser"); //.ser means it's serialized
				ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
				objOut.writeObject(aGame);
				objOut.close();
				fileOut.close();
			}
		catch(IOException ex)
			{
				ex.printStackTrace();
			}
	}

}
