package dnd.players;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import dnd.character.GameChar;
import dnd.transactions.ResourceTransaction;
import dnd.transactions.XPSkillTransaction;

public class DungeonMaster extends Person{
	private ArrayList<GameChar> npcs = new ArrayList<GameChar>();
	
	//Constructors
	public DungeonMaster() {
		this.setUsername("Unknown DM Username");
		this.setPassword("Unknown DM password");
		loggedIn = false;
		
	}
	
	public DungeonMaster(String username, String myPSWD) {
		this.setUsername(username);
		this.setPassword(myPSWD);
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
	
	//Commented out because handled in Person for now
//	//If password is incorrect, loggedIn should stay false and ask the user to try again
//	public void logIn(String aUsername, String aPassword) {
//		if(aUsername.equals(this.getUsername())) {
//			if(aPassword.equals(this.getPassword())) {
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
//			System.out.println("Incorrect username or nonexistent username. Please try again.");
//		}
//		
//	}
//	
//	public void logOut() {
//		loggedIn = false;
//	}
	

	
	//TODO: Add NPC to NPCs arraylist
	//Should these parameters be changed?
	//How should we prompt the user to create an NPC?
	public void createNPC(GameChar npc) {
		npcs.add(npc);
		
	}
	
	public void deleteNPC(GameChar npc) {
		npcs.remove(npc);
	}
	
	//Given an NPCs name, remove them from the list
	public void deleteNPC(String name) {
		for(GameChar npc: npcs) {
			if(npc.getName() == name) {
				npcs.remove(npc);
			}
		}
	}
	
	//TODO: Should we have NPC manipulation methods? Such as manipulating their resources or profiles?
	
	//Called in the XPSkillTransaction methods
	//This simply adds the transaction to history
	public void makeXPTransaction(XPSkillTransaction aTransaction) {
		transactions.add(aTransaction);
		
	}
	
	//All is executed in Transaction classes
	//This is simply to add the transaction to history
	public void makeResourceTransaction(ResourceTransaction aTransaction) {
		transactions.add(aTransaction);
	}
	
	//TODO: Give money to players
	public void giveMoney(int amount) {
		
	}

}
