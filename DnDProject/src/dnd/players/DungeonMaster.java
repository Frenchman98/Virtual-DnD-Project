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
	
	public void createPassword() {
		
	}
	
	//Serialization Load
	public static DungeonMaster loadData() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		DungeonMaster dm = null;
		
		try {
			fileIn = new FileInputStream("DungeonMaster.ser");
			objIn = new ObjectInputStream(fileIn);
			dm = (DungeonMaster) objIn.readObject(); //serialized from the object
			objIn.close();
			fileIn.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
			
		}
		catch(ClassNotFoundException c){
			c.printStackTrace(); //print if cannot find the class
		}
		
		return dm;
		
	}
	
	//Serialization Save
	//TODO: MAY BE REMOVED IF THERE IS A GAME CLASS FOR SERIALIZATION
	public static void saveData(DungeonMaster aDM) {
		try 
			{
				FileOutputStream fileOut = new FileOutputStream("DungeonMaster.ser"); //.ser means it's serialized
				ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
				objOut.writeObject(aDM);
				objOut.close();
				fileOut.close();
			}
		catch(IOException ex)
			{
				ex.printStackTrace();
			}
	}
	
	//TODO: Add NPC to NPCs arraylist
	//Should these parameters be changed?
	public void createNPC(GameChar npc) {
		npcs.add(npc);
		
	}
	
	public void deleteNPC(GameChar npc) {
		npcs.remove(npc);
	}
	
	//TODO: Add aTransaction and execute the transaction (remove money or experience
	//Adds skill to Character
	public void makeXPTransaction(XPSkillTransaction aTransaction) {
		transactions.add(aTransaction);
		
	}
	
	//TODO: Add aTransaction and execute the transaction (remove money or experience
	//Adds resource to Character
	public void makeResourceTransaction(ResourceTransaction aTransaction) {
		transactions.add(aTransaction);
	}

}
