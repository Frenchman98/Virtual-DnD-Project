package dnd.players;

import java.util.ArrayList;

public class DungeonMaster {
	private String username;
	private String password;
	private ArrayList<Character> npcs = new ArrayList<Character>();
	private boolean loggedIn = false;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	//Constructors
	public DungeonMaster() {
		username = "Unknown DM Username";
		password = "Unknown DM password";
		loggedIn = false;
		
	}
	
	public DungeonMaster(String username, String myPSWD) {
		this.username = username;
		password = myPSWD;
		loggedIn = false;
	}

	//Getters and Setters
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getLoggedIn() {
		return loggedIn;
	}
	
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public ArrayList<Character> getNPCs() {
		return npcs;
	}

	public void setNPCs(ArrayList<Character> nPCs) {
		npcs = nPCs;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	//TODO: Add Getters/Setters for Transactions
	
	//Add the given amount of experience to the given player
	public void giveExperience(int experience, Player myPlayer) {
		//TODO: myPlayer.addExperience(experience);
	}
	
	//If password is incorrect, loggedIn should stay false and ask the user to try again
	public void logIn(String aUsername, String aPassword) {
		if(aUsername.equals(username)) {
			if(aPassword.equals(password)) {
				loggedIn = true;
				System.out.println("Log in successful");
				return;
			}
			else
			{
				loggedIn = false;
				System.out.println("Incorrect password. Please try again.");
				return;
			}
		}
		else {
			System.out.println("Incorrect username. Please try again.");
		}
		
	}
	
	public void logOut() {
		loggedIn = false;
	}
	
	//TODO: Add NPC to NPCs arraylist
	//Should these parameters be changed?
	public void createNPC(Character npc) {
		npcs.add(npc);
		
	}
	
	public void deleteNPC(Character npc) {
		npcs.remove(npc);
	}


}
