package dnd.character;

import java.io.Serializable;
import java.util.ArrayList;

import dnd.resources.*;
import dnd.skills.*;

public class GameChar implements Serializable{
	private String name;
	//Change race to a type? Not sure
	private String race;
	private int money = 0;
	//private int experience = 0;
	//TODO: Is resources needed?
	private ArrayList<Resource> resources = new ArrayList<Resource>();
	private ArrayList<Armor> armors = new ArrayList<Armor>();
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private PrimaryProfile primary = new PrimaryProfile();
	private SecondaryProfile secondary = new SecondaryProfile();
	private Armor equippedArmor = null;
	private Weapon equippedWeapon = null;
	private ArrayList<Skill> skills = new ArrayList<Skill>();
	
	//Constructors
	public GameChar() {
		name = "Unknown character";
		race = "Unknown race";
	}
	
	public GameChar(String name, String race) {
		this.name = name;
		this.race = race;
		primary = new PrimaryProfile(race);
		secondary = new SecondaryProfile(race, primary.getStrength(), primary.getToughness());
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
	
	public ArrayList<Armor> getArmors(){
		return armors;
	}
	
	public void setArmors(ArrayList<Armor> armors) {
		this.armors = armors;
	}
	
	public ArrayList<Weapon> getWeapons(){
		return weapons;
	}
	
	public void setWeapons(ArrayList<Weapon> weapons) {
		this.weapons = weapons;
	}
	
	public void addResource(Resource aResource) {
		resources.add(aResource);
	}
	
	//Called in XPSkillTransaciton
	public void addSkill(Skill aSkill) {
		skills.add(aSkill);
	}
	
	//TODO: GenerateRandomSkills for Humans and Haflings
	public void generateRandomSkills(String race, int diceRoll) {
		
	}
	
	//TODO: add points to primary profile stat
	//Might change this
	//If a Strength or Toughness has a new 10s place then
	//Strength and Toughness Bonus need to be adjusted accordingly
	public void addPrimaryPoints(int points, String stat) {
		if(stat.equals("Strength")) {
			int oldTens = (this.getPrimary().getStrength()) / 10;
			primary.addPoints(points, stat);
			int newTens = this.getPrimary().getStrength() / 10; 
			if(newTens != oldTens) {
				secondary.setStrengthBonus(newTens);
			}
		}
		else if(stat.equals("Toughenss")) {
			int oldTens = (this.getPrimary().getToughness()) / 10;
			primary.addPoints(points, stat);
			int newTens = this.getPrimary().getToughness() / 10; 
			if(newTens != oldTens) {
				secondary.setToughnessBonus(newTens);
			}
			
		}
		else {
			primary.addPoints(points, stat);
		}
		
	}
	
	public void printCharacterInfo() {
		System.out.println("Name: " + name);
		System.out.println("Race: " + race);
		System.out.println("Money: " + money);
		if(equippedArmor != null) {
			System.out.println("Current Armor equipped: " + this.getEquippedArmor().getName());
		}
		if(equippedWeapon != null) {
			System.out.println("Current Weapon equipped: " + this.getEquippedWeapon().getName());
		}
		System.out.println();
		primary.printPrimaryProfile();
		System.out.println();
		secondary.printSecondaryProfile();
		System.out.println();
	}
	
	//TODO: add points to secondary profile stat
	//Might change this
	public void addSecondaryPoints(int points, String stat) {
		secondary.addPoints(points, stat);
	}
	
	public void removePrimaryPoints(int points, String stat) {
		//multiply by -1 for same functionality as addPoints but with a negative number
		primary.addPoints(points * -1, stat);
	}
	
	public void removeSecondaryPoints(int points, String stat) {
		secondary.addPoints(points * -1, stat);
	}
	
	public void addMoney(int _money) {
		money += _money;
	}
	
	public void removeMoney(int _money) {
		money -= _money;
	}

}
