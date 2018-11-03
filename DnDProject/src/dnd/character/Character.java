package dnd.character;

import java.util.ArrayList;
import dnd.resources.*;
import dnd.skills.*;

public class Character {
	private String name;
	//Change race to a type? Not sure
	private String race;
	private int money = 0;
	//private int experience = 0;
	private ArrayList<Resource> resources = new ArrayList<Resource>();
	private PrimaryProfile primary;
	private SecondaryProfile secondary;
	private Armor equippedArmor;
	private Weapon equippedWeapon;
	private ArrayList<Skill> skills = new ArrayList<Skill>();
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	//Constructors
	public Character() {
		name = "Unknown character";
		race = "Unknown race";
	}
	
	public Character(String name, String race) {
		this.name = name;
		this.race = race;
	}
	
	//Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public ArrayList<Resource> getResources() {
		return resources;
	}

	public void setResources(ArrayList<Resource> resources) {
		this.resources = resources;
	}

	public PrimaryProfile getPrimary() {
		return primary;
	}

	public void setPrimary(PrimaryProfile primary) {
		this.primary = primary;
	}

	public SecondaryProfile getSecondary() {
		return secondary;
	}

	public void setSecondary(SecondaryProfile secondary) {
		this.secondary = secondary;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public Armor getEquippedArmor() {
		return equippedArmor;
	}
	
	public void setEquippedArmor(Armor armor) {
		equippedArmor = armor;
	}
	
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}
	
	public void setEquippedWeapon(Weapon weapon) {
		equippedWeapon = weapon;
	}
	
	//TODO: Add aTransaction and execute the transaction (remove money or experience
	public void makeTransaction(Transaction aTransaction) {
		transactions.add(aTransaction);
	}
	
	//TODO: After resource transaction, add Resource
	public void addResource(Resource aResource) {
		resources.add(aResource);
	}
	
	//TODO: After XP transaction, add Skill
	public void addSkill(Skill aSkill) {
		skills.add(aSkill);
	}

}
