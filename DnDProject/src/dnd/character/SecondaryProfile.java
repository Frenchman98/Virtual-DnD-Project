package dnd.character;

public class SecondaryProfile {
	private int numberOfAttacks;
	private int wounds;
	private int strengthBonus;
	private int toughnessBonus;
	private int movementPoints;
	private int insanityPoints;
	private int fortunePoints;
	
	//Constructors
	//TODO: Make the secondary profile dependent on race
	public SecondaryProfile() {
		numberOfAttacks = 0;
		wounds = 0;
		strengthBonus = 0;
		toughnessBonus = 0;
		movementPoints = 0;
		insanityPoints = 0;
		fortunePoints = 0;		
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

	public int getWounds() {
		return wounds;
	}

	public void setWounds(int wounds) {
		if(wounds > 10) {
			this.wounds = 10;
			System.out.println("Cannot have a stat greater than 10 in secondary profile.");
		}
		else
		{
			this.wounds = wounds;
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
			case "Wounds":
				newVal += wounds;
				this.setWounds(newVal);
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
				System.out.println("Not a valid type. Must be a Primary Skill.");
				break;
			}	
			
		}
	
	
	

}
