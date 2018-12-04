package dnd.players;

import dnd.character.GameChar;
import dnd.resources.Armor;
import dnd.resources.Weapon;
import dnd.transactions.*;

public class Player extends Person{
	private int experience = 0;
	private GameChar theCharacter = null;
	
	//Constructors
	public Player() {
		this.setUsername("Unknown username");
		this.setPassword("Unknown password");
		experience = 0;
	}
	
	public Player(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		experience = 0;
	}

	//Getters and Setters

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public GameChar getTheCharacter() {
		return theCharacter;
	}

	public void setTheCharacter(GameChar theCharacter) {
		this.theCharacter = theCharacter;
	}
	
	public void addExperience(int exp) {
		experience += exp;
	}
	
	public void subtractExperience(int exp) {
		experience -= exp;
	}
	
	public void createCharacter(String name, String race) {
		if(theCharacter != null) {
			System.out.println("Character already exists for player " + this.getUsername());
			return;
		}
		theCharacter = new GameChar(name, race);
		System.out.println("Successfully created character " + name + " for user " + this.getUsername());
	}
	
	//Change what Armor is currently equipped on Character
	//If Character doesn't own the armor then it cannot be equipped
	//If they do, change setEquippedArmor
	public void changeArmor(Armor aArmor) {
		if(!this.isLoggedIn()) {
			System.out.println("You must be logged in to change armor.");
			return;
		}
		boolean owns = false;
		for(Armor armor : theCharacter.getArmors()) {
			if(armor.equals(aArmor)) {
				owns = true;
			}
		}
		if(owns) {
			theCharacter.setEquippedArmor(aArmor);
		}
		else {
			System.out.println("You cannot equip Armor you don't own");
		}
	}
	
	//Change what Weapon is currently equipped on Character
	//If character doesn't own the weapon then it cannot be equipped
	//If they do, change setEquippedWeapon
	public void changeWeapon(Weapon aWeapon) {
		if(!this.isLoggedIn()) {
			System.out.println("You must be logged in to change weapon.");
			return;
		}
		boolean owns = false;
		for(Weapon weapon : theCharacter.getWeapons()) {
			if(weapon.equals(aWeapon)) {
				owns = true;
			}
		}
		if(owns) {
			theCharacter.setEquippedWeapon(aWeapon);
		}
		else
		{
			System.out.println("You cannot equip Weapon you don't own");
		}
		
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
//				System.out.println("Incorrect password. Please try again.");					return;
//			}
//		}
//		else {
//			System.out.println("Incorrect username. Please try again.");
//		}
//			
//	}
//		
//	public void logOut() {
//			loggedIn = false;
//	}
	
	//Simply adds the transaction to the player's history
	public void makeXPTransaction(XPSkillTransaction aTransaction) {
		transactions.add(aTransaction);
		
	}
	
	//Adds the transaction to the player's history
	public void makeResourceTransaction(ResourceTransaction aTransaction) {
		transactions.add(aTransaction);
	}
	
	public void printPlayerInfo() {
		System.out.println("Player Information");
		System.out.println("Username: " + this.getUsername());
		System.out.println("Unspent Experience: " + experience + "\n");
		System.out.println("Character information: ");			
		if(theCharacter != null) {
			theCharacter.printCharacterInfo();
		}

	}
	
	
	
}
