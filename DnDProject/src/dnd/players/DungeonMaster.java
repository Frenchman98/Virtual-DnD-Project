package dnd.players;

import java.util.ArrayList;

import dnd.character.GameChar;
import dnd.transactions.Transaction;

public class DungeonMaster extends Person{
	private ArrayList<GameChar> npcs = new ArrayList<GameChar>();
	
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
	
	public boolean getLoggedIn() {
		return loggedIn;
	}
	
	public ArrayList<GameChar> getNPCs() {
		return npcs;
	}

	public void setNPCs(ArrayList<GameChar> nPCs) {
		npcs = nPCs;
	}
	
	//Add the given amount of experience to the given player
	public void giveExperience(int experience, Player myPlayer) {
		myPlayer.addExperience(experience);
	}
	
//	//If password is incorrect, loggedIn should stay false and ask the user to try again
//	public void logIn(String aUsername, String aPassword) {
//		if(aUsername.equals(username)) {
//			if(aPassword.equals(password)) {
//				loggedIn = true;
//				System.out.println("Log in successful");
//				return;
//			}
//			else
//			{
//				loggedIn = false;
//				System.out.println("Incorrect password. Please try again.");
//				return;
//			}
//		}
//		else {
//			System.out.println("Incorrect username. Please try again.");
//		}
//		
//	}
//	
//	public void logOut() {
//		loggedIn = false;
//	}
	
	//TODO: Add NPC to NPCs arraylist
	//Should these parameters be changed?
	public void createNPC(GameChar npc) {
		npcs.add(npc);
		
	}
	
	public void deleteNPC(GameChar npc) {
		npcs.remove(npc);
	}


}
