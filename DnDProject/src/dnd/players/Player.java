package dnd.players;

import dnd.character.Character;

public class Player {
	private String username;
	private String password;
	private int experience;
	private boolean loggedIn = false;
	private Character theCharacter;
	
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
	
}
