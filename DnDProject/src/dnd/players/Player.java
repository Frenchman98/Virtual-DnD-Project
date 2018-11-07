package dnd.players;

import dnd.character.GameChar;
import dnd.resources.Armor;
import dnd.resources.Weapon;
import dnd.transactions.*;

public class Player extends Person{
	private int experience;
	private GameChar theCharacter;
	
	//Constructors
	public Player() {
		username = "Unknown username";
		password = "Unknown password";
		theCharacter.setName("Unknown name for Player");
	}
	
	public Player(String username, String password) {
		this.username = username;
		this.password = password;
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
	
	//TODO: Change what Armor is currently equipped on Character
	//If Character doesn't own the armor then it cannot be equipped
	//If they do, change setEquippedArmor
	public void changeArmor(Armor aArmor) {
		theCharacter.setEquippedArmor(aArmor);
		
	}
	
	//TODO: Change what Weapon is currently equipped on Character
	//If character doesn't own the weapon then it cannot be equipped
	//If they do, change setEquippedWeapon
	public void changeWeapon(Weapon aWeapon) {
		theCharacter.setEquippedWeapon(aWeapon);
		
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
