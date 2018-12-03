package dnd.character;
import java.io.Serializable;
import java.util.Random;

public class PrimaryProfile implements Serializable{
	private int weaponSkill;
	private int ballisticSkill;
	private int strength;
	private int toughness;
	private int agility;
	private int intelligence;
	private int willpower;
	private int fellowship;
	private Random rNum = new Random();
	
	//Constructors
	
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
	
	//Constructor where base stats are based off of race
	//Adds 2d10 results together
	public PrimaryProfile(String race) {
		switch(race) {
		 case "Dwarf":
		 	weaponSkill = 30 + rNum.nextInt(10) + rNum.nextInt(10);
		 	ballisticSkill = 20 + rNum.nextInt(10) + rNum.nextInt(10);
		 	strength = 20 + rNum.nextInt(10) + rNum.nextInt(10);
		 	toughness = 30 + rNum.nextInt(10) + rNum.nextInt(10);
		 	agility = 10 + rNum.nextInt(10) + rNum.nextInt(10);
		 	intelligence = 20 + rNum.nextInt(10) + rNum.nextInt(10);
		 	willpower = 20 + rNum.nextInt(10) + rNum.nextInt(10);
		 	fellowship = 10 + rNum.nextInt(10) + rNum.nextInt(10);
		 	break;
		 case "Elf":
			 weaponSkill = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 ballisticSkill = 30 + rNum.nextInt(10) + rNum.nextInt(10);
			 strength = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 toughness = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 agility = 30 + rNum.nextInt(10) + rNum.nextInt(10);
			 intelligence = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 willpower = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 fellowship = 20 + rNum.nextInt(10) + rNum.nextInt(10); 
			 break;
		 case "Halfling":
			 weaponSkill = 10 + rNum.nextInt(10) + rNum.nextInt(10);
			 ballisticSkill = 30 + rNum.nextInt(10) + rNum.nextInt(10);
			 strength = 10 + rNum.nextInt(10) + rNum.nextInt(10);
			 toughness = 10 + rNum.nextInt(10) + rNum.nextInt(10);
			 agility = 30 + rNum.nextInt(10) + rNum.nextInt(10);
			 intelligence = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 willpower = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 fellowship = 30 + rNum.nextInt(10) + rNum.nextInt(10); 
			 break;
		 case "Human":
			 weaponSkill = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 ballisticSkill = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 strength = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 toughness = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 agility = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 intelligence = 20 + rNum.nextInt(10 + rNum.nextInt(10));
			 willpower = 20 + rNum.nextInt(10) + rNum.nextInt(10);
			 fellowship = 20 + rNum.nextInt(10) + rNum.nextInt(10); 
			 break;
		}
		
	}
	
	public PrimaryProfile(int weaponSkill, int ballisticSkill, int strength, int toughness, int agility, int intelligence, int willpower, int fellowship) 
	{
		//use set so that way value over 100 case is checked
		this.setWeaponSkill(weaponSkill);
		this.setBallisticSkill(ballisticSkill);
		this.setStrength(strength);
		this.setToughness(toughness);
		this.setAgility(agility);
		this.setIntelligence(intelligence);
		this.setWillpower(willpower);
		this.setFellowship(fellowship);
			
	}

	//Getters and Setters
	
	public int getWeaponSkill() {
		return weaponSkill;
	}

	public void setWeaponSkill(int weaponSkill) {
		int newVal = this.weaponSkill + weaponSkill;
		if(newVal > 100) {
			this.weaponSkill = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile. Automatically set to 100.");
		}
		else if(newVal < 0) {
			this.weaponSkill = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile. Automatically set to 0.");
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
		int newVal = this.ballisticSkill + ballisticSkill;
		if(newVal > 100) {
			this.ballisticSkill = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile. Automatically set to 100.");
		}
		else if(newVal < 0) {
			this.ballisticSkill = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile. Automatically set to 0.");
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
		int newVal = this.strength + strength;
		if(newVal > 100) {
			this.strength = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile. Automatically set to 100.");
		}
		else if(newVal < 0) {
			this.strength = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile. Automatically set to 0.");
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
		int newVal = this.toughness + toughness;
		if(newVal > 100) {
			this.toughness = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile. Automatically set to 100.");
		}
		else if(newVal < 0) {
			this.toughness = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile. Automatically set to 0.");
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
		int newVal = this.agility + agility;
		if(newVal > 100) {
			this.agility = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile. Automatically set to 100.");
		}
		else if(newVal < 0) {
			this.agility = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile. Automatically set to 0.");
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
		int newVal = this.intelligence + intelligence;
		if(newVal > 100) {
			this.intelligence = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile. Automatially set to 100.");
		}
		else if(newVal < 0) {
			this.intelligence = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile. Automatically set to 0.");
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
		int newVal = this.willpower + willpower;
		if(newVal > 100) {
			this.willpower = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile. Automatically set to 100.");
		}
		else if(newVal < 0) {
			this.willpower = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile. Automatically set to 0.");
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
