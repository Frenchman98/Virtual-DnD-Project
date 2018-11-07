package dnd.transactions;

import java.util.*;

import dnd.skills.Skill;

public class XPSkillTransaction extends Transaction {
	
	private Skill skillPurchased;
	
	public XPSkillTransaction() {
		skillPurchased = null;
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
	
	//TODO: Figure out a way to access character and player through person, or find a way to handle DM transactions differently.
	
	public void addSkillToBuyer() {
		super.getBuyer().getTheCharacter().addSkill(skillPurchased);
	}
	
	public void removeExperienceFromBuyer() {
		super.getBuyer().subtractExperience(super.getAmount());
	}
	
	public void addExperienceToSeller() {
		super.getSeller().addExperience(super.getAmount());
	}
	
}