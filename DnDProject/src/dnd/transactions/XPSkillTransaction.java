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
	
	public void addSkillToBuyer() {
		super.getBuyer().getTheCharacter().addSkill(skillPurchased);
	}
	
	public void removeExperienceFromBuyer() {
		super.getBuyer().subtractExperinece(super.getAmount());
	}
	
	public void addExperienceToSeller() {
		super.getSeller().addExperience(super.getAmount());
	}
	
}