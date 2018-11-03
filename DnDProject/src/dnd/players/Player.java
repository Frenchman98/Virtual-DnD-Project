package dnd.players;

import java.util.ArrayList;

import dnd.character.Character;
import dnd.transactions.*;

public class Player {
	private String username;
	private String password;
	private int experience;
	private boolean loggedIn = false;
	private Character theCharacter;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
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
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Character getTheCharacter() {
		return theCharacter;
	}

	public void setTheCharacter(Character theCharacter) {
		this.theCharacter = theCharacter;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	public void addExperience(int exp) {
		experience += exp;
	}
	
	public void subtractExperinece(int exp) {
		experience -= exp;
	}
	
	//TODO: Change what Armor is currently equipped on Character
	//If Character doesn't own the armor then it cannot be equipped
	//If they do, change setEquippedArmor
	public void changeArmor(Armor aArmor) {
		
	}
	
	//TODO: Change what Weapon is currently equipped on Character
	//If character doesn't own the weapon then it cannot be equipped
	//If they do, change setEquippedWeapon
	public void changeWeapon(Weapon aWeapon) {
		
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
				System.out.println("Incorrect password. Please try again.");					return;
			}
		}
		else {
			System.out.println("Incorrect username. Please try again.");
		}
			
	}
		
	public void logOut() {
			loggedIn = false;
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
