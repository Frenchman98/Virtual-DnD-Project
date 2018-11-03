package dnd.character;

public class PrimaryProfile {
	private int weaponSkill;
	private int ballisticSkill;
	private int strength;
	private int toughness;
	private int agility;
	private int intelligence;
	private int willpower;
	private int fellowship;
	
	//Constructors
	//TODO: Constructor where base stats are based off of race
	public PrimaryProfile() {
		weaponSkill = 0;
		ballisticSkill = 0;
		strength = 0;
		toughness = 0;
		agility = 0;
		intelligence = 0;
		willpower = 0;
		fellowship = 0;
	}

	//Getters and Setters
	
	public int getWeaponSkill() {
		return weaponSkill;
	}

	public void setWeaponSkill(int weaponSkill) {
		if(weaponSkill > 100) {
			this.weaponSkill = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else
		{
			this.weaponSkill = weaponSkill;
		}
		
	}

	public int getBallisticSkill() {
		return ballisticSkill;
	}

	public void setBallisticSkill(int ballisticSkill) {
		if(ballisticSkill > 100) {
			this.ballisticSkill = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else
		{
			this.ballisticSkill = ballisticSkill;
		}
		
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		if(strength > 100) {
			this.strength = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else
		{
			this.strength = strength;
		}
		
	}

	public int getToughness() {
		return toughness;
	}

	public void setToughness(int toughness) {
		if(toughness > 100) {
			this.toughness = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else
		{
			this.toughness = toughness;
		}
		
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		if(agility > 100) {
			this.agility = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else
		{
			this.agility = agility;
		}
		
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		if(intelligence > 100) {
			this.intelligence = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else
		{
			this.intelligence = intelligence;
		}
		
	}

	public int getWillpower() {
		return willpower;
	}

	public void setWillpower(int willpower) {
		if(willpower > 100) {
			this.willpower = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else
		{
			this.willpower = willpower;
		}
		
	}

	public int getFellowship() {
		return fellowship;
	}

	public void setFellowship(int fellowship) {
		this.fellowship = fellowship;
	}
	
	//Adds points to a specific type of skill
	//The setter will check if the new value is greater than 100 and adjust accordingly
	public void addPoints(int points, String type) {
		int newVal = points;
		switch(type) {
		case "Weapon Skill":
			newVal += weaponSkill;
			this.setWeaponSkill(newVal);
			break;
		case "Ballistic Skill":
			newVal += ballisticSkill;
			this.setBallisticSkill(newVal);
			break;
		case "Strength":
			newVal += strength;
			this.setStrength(newVal);
			break;
		case "Toughness":
			newVal += toughness;
			this.setToughness(newVal);
			break;
		case "Agility":
			newVal += agility;
			this.setAgility(newVal);
			break;
		case "Intelligence":
			newVal += intelligence;
			this.setIntelligence(newVal);
			break;
		case "Willpower":
			newVal += willpower;
			this.setWillpower(newVal);
			break;
		default:
			System.out.println("Not a valid type. Must be a Primary Skill.");
			break;
		}	
		
	}
	
	
	
	

}
