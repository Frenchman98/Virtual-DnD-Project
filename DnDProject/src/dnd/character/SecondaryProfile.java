package dnd.character;

import java.util.Random;

public class SecondaryProfile {
	private int numberOfAttacks;
	private int health;
	private int strengthBonus;
	private int toughnessBonus;
	private int movementPoints;
	private int insanityPoints;
	private int fortunePoints;
	private Random rNum = new Random(); //this will account for creation
	
	//Constructors
	public SecondaryProfile() {
		numberOfAttacks = 1;
		health = 0;
		strengthBonus = 0;
		toughnessBonus = 0;
		movementPoints = 0;
		insanityPoints = 0;
		fortunePoints = 0;		
	}
	
	
	public SecondaryProfile(String race, int strength, int toughness) {
		numberOfAttacks = 1;
		health = 0;
		strengthBonus = strength / 10;
		toughnessBonus = toughness / 10;
		insanityPoints = 0;
		int firstRoll = rNum.nextInt();
		int secondRoll = rNum.nextInt();
		
		//Health bonus based on dice roll
		if(firstRoll >= 4 && firstRoll <= 6) {
			health += 1;
		}
		else if(firstRoll >= 7 && firstRoll <= 9) {
			health += 2;
		}
		else if(firstRoll == 10) {
			health += 3;
		}	
		
		switch(race) {
		case "Dwarf":
			health += 11;
			movementPoints = 3;
			fortunePoints = 1;
			
			//Fortune point bonus based on dice roll
			if(secondRoll >= 5 && secondRoll <= 7) {
				fortunePoints += 1;
			}
			else if(secondRoll >= 8 && secondRoll <= 10) {
				fortunePoints += 2;
			}
			break;
		case "Elf":
			health += 9;
			movementPoints = 5;
			fortunePoints = 1;
			
			//Fortune point bonus based on dice roll
			if(secondRoll >= 5 && secondRoll <= 10) {
				fortunePoints += 1;
			}
			break;
		case "Halfling":
			health += 8;
			movementPoints = 4;
			fortunePoints = 2;
			
			//Fortune point bonus based on dice roll
			if(secondRoll >= 8 && secondRoll <= 10) {
				fortunePoints += 1;
			}
			break;
		case "Human":
			health += 10;
			movementPoints = 4;
			fortunePoints = 2;
			
			//Fortune point bonus based on dice roll
			if(secondRoll >= 5 && secondRoll <= 10) {
				fortunePoints += 1;
			}
			break;
		default:
			System.out.println("Not a valid race. Must be Dwarf, Elf, Halfling, or Human.");
		}
	}
	public SecondaryProfile(int numberOfAttacks, int health, int strengthBonus, int toughnessBonus, int movementPoints, int insanityPoints, int fortunePoints) {
		this.numberOfAttacks = numberOfAttacks;
		this.health = health;
		this.strengthBonus = strengthBonus;
		this.toughnessBonus = toughnessBonus;
		this.movementPoints = movementPoints;
		this.insanityPoints = insanityPoints;
		this.fortunePoints = fortunePoints;
	}

	//Getters and Setters
	
	public int getNumberOfAttacks() {
		return numberOfAttacks;
	}

	public void setNumberOfAttacks(int numberOfAttacks) {
		if(numberOfAttacks > 10) {
			this.numberOfAttacks = 10;
			System.out.println("Cannot have a stat greater than 10 in secondary profile.");
		}
		else
		{
			this.numberOfAttacks = numberOfAttacks;
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health > 10) {
			this.health = 10;
			System.out.println("Cannot have a stat greater than 10 in secondary profile.");
		}
		else
		{
			this.health = health;
		}
	}

	public int getStrengthBonus() {
		return strengthBonus;
	}

	public void setStrengthBonus(int strengthBonus) {
		if(strengthBonus > 10) {
			this.strengthBonus = 10;
			System.out.println("Cannot have a stat greater than 10 in secondary profile.");
		}
		else
		{
			this.strengthBonus = strengthBonus;
		}
	}

	public int getToughnessBonus() {
		return toughnessBonus;
	}

	public void setToughnessBonus(int toughnessBonus) {
		if(toughnessBonus > 10) {
			this.toughnessBonus = 10;
			System.out.println("Cannot have a stat greater than 10 in secondary profile.");
		}
		else
		{
			this.toughnessBonus = toughnessBonus;
		}
	}

	public int getMovementPoints() {
		return movementPoints;
	}

	public void setMovementPoints(int movementPoints) {
		if(movementPoints > 10) {
			this.movementPoints = 10;
			System.out.println("Cannot have a stat greater than 10 in secondary profile.");
		}
		else
		{
			this.movementPoints = movementPoints;
		}
	}

	public int getInsanityPoints() {
		return insanityPoints;
	}

	public void setInsanityPoints(int insanityPoints) {
		if(insanityPoints > 10) {
			this.insanityPoints = 10;
			System.out.println("Cannot have a stat greater than 10 in secondary profile.");
		}
		else
		{
			this.insanityPoints = insanityPoints;
		}
	}

	public int getFortunePoints() {
		return fortunePoints;
	}

	public void setFortunePoints(int fortunePoints) {
		if(fortunePoints > 10) {
			this.fortunePoints = 10;
			System.out.println("Cannot have a stat greater than 10 in secondary profile.");
		}
		else
		{
			this.fortunePoints = fortunePoints;
		}
	}
	
	//Adds points to a specific type of skill
	//The setter will check if the new value is greater than 10 and adjust accordingly
	public void addPoints(int points, String type) {
		int newVal = points;
		switch(type) {
		case "Number of Attacks":				
			newVal += numberOfAttacks;
			this.setNumberOfAttacks(newVal);
			break;
		case "Health":
			newVal += health;				
			this.setHealth(newVal);
			break;
		case "Strength Bonus":
			newVal += strengthBonus;
			this.setStrengthBonus(newVal);
			break;
		case "Toughness Bonus":
			newVal += toughnessBonus;
			this.setToughnessBonus(newVal);
			break;
		case "Movement Points":
			newVal += movementPoints;
			this.setMovementPoints(newVal);
			break;
		case "Insanity Points":
			newVal += insanityPoints;
			this.setInsanityPoints(newVal);
			break;
		case "Fortune Points":
			newVal += fortunePoints;
			this.setFortunePoints(newVal);
			break;
		default:
			System.out.println("Not a valid type. Must be a Secondary Skill.");
			break;
			}	
			
	}
	
	
	

}
