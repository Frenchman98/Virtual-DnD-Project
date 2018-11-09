package dnd.transactions;

import java.util.*;

import dnd.players.Player;
import dnd.skills.Skill;

public class XPSkillTransaction extends Transaction {
	
	private Skill skillPurchased;
	
	public XPSkillTransaction() {
		skillPurchased = null;
	}
	
	public void MakeTransaction(Player buyer, Skill skill, int amount) {
		super.setBuyer(buyer);
		setSkillPurchased(skill);
		super.setAmount(amount);
		
		if (buyer.getExperience() < amount)
		{
			System.out.println(buyer.getUsername() + " has insufficient experience (" + buyer.getExperience() + " XP) to buy the skill " + skill.getName() + " (" + amount + " XP). Aborting transaction.");
			return;
		}
		else
		{
			this.removeExperienceFromBuyer();
			this.addSkillToBuyer();
			System.out.println(buyer.getUsername() + " has successfully bought the skill " + skill.getName() + ".");
		}
	}
	
	public XPSkillTransaction(Skill skill, int amount) {
		skillPurchased = skill;
		super.setAmount(amount);
	}
	
	public Skill getSkillPurchased() {
		return this.skillPurchased;
	}
	
	public void setSkillPurchased(Skill s) {
		this.skillPurchased = s;
	}
	
	public void addSkillToBuyer() {
		super.getBuyer().getTheCharacter().addSkill(skillPurchased);
	}
	
	public void removeExperienceFromBuyer() {
		super.getBuyer().subtractExperience(super.getAmount());
	}
	
}