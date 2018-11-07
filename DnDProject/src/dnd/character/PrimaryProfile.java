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
	
	public PrimaryProfile(int weaponSkill, int ballisticSkill, int strength, int toughness, int agility, int intelligence, int willpower, int fellowship) 
	{
		this.weaponSkill = weaponSkill;
		this.ballisticSkill = ballisticSkill;
		this.strength = strength;
		this.toughness = toughness;
		this.agility = agility;
		this.intelligence = intelligence;
		this.willpower = willpower;
		this.fellowship = fellowship;
			
	}

	//Getters and Setters
	
	public int getWeaponSkill() {
		return weaponSkill;
	}

	public void setWeaponSkill(int weaponSkill) {
		int newVal = this.weaponSkill + weaponSkill;
		if(newVal > 100) {
			this.weaponSkill = 100;
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else if(newVal < 0) {
			this.weaponSkill = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile.");
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
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else if(newVal < 0) {
			this.ballisticSkill = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile.");
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
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else if(newVal < 0) {
			this.strength = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile.");
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
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else if(newVal < 0) {
			this.toughness = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile.");
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
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else if(newVal < 0) {
			this.agility = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile.");
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
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else if(newVal < 0) {
			this.intelligence = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile.");
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
			System.out.println("Cannot have a stat greater than 100 in primary profile.");
		}
		else if(newVal < 0) {
			this.willpower = 0;
			System.out.println("Cannot have a stat less than 0 in primary profile.");
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
