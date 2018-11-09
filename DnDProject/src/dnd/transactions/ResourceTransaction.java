package dnd.transactions;

import java.util.*;

import dnd.character.GameChar;
import dnd.players.Person;
import dnd.players.Player;
import dnd.resources.Resource;
import dnd.skills.Skill;

public class ResourceTransaction extends Transaction {
	
	private Resource resource;
	
	public ResourceTransaction() {
		resource = null;
	}
	
	public void MakePlayerTransaction(Player buyer, Player seller, Resource _resource, int amount) {
		super.setSeller(seller);
		super.setBuyer(buyer);
		setResource(_resource);
		super.setAmount(amount);
		
		if (buyer.getTheCharacter().getMoney() < amount)
		{
			System.out.println(buyer.getTheCharacter().getName() + " has insufficient money ($" + buyer.getTheCharacter().getMoney() + ") to buy a " + _resource.getName() + " ($" + amount + "). Aborting transaction.");
			return;
		}
		else
		{
			this.removeMoneyFromBuyer();
			this.addResourceToBuyer();
			this.addMoneyToSeller();
			System.out.println(buyer.getTheCharacter().getName() + " has successfully bought a " + _resource.getName() + " from " + seller.getTheCharacter().getName() + ".");
		}
	}
	
	public void MakeDMTransaction(Player buyer, Person dm, Resource _resource, int amount) {
		super.setDM(dm);
		super.setBuyer(buyer);
		setResource(_resource);
		super.setAmount(amount);
		
		if (buyer.getTheCharacter().getMoney() < amount)
		{
			System.out.println(buyer.getTheCharacter().getName() + " has insufficient money ($" + buyer.getTheCharacter().getMoney() + ") to buy a " + _resource.getName() + " ($" + amount + "). Aborting transaction.");
			return;
		}
		else
		{
			this.removeMoneyFromBuyer();
			this.addResourceToBuyer();
			System.out.println(buyer.getTheCharacter().getName() + " has successfully bought a " + _resource.getName() + " from the Dungeon Master.");
		}
	}
	
	public void MakeNPCTransaction(Player buyer, GameChar npc, Resource _resource, int amount) {
		super.setNPC(npc);
		super.setBuyer(buyer);
		setResource(_resource);
		super.setAmount(amount);
		
		if (buyer.getTheCharacter().getMoney() < amount)
		{
			System.out.println(buyer.getTheCharacter().getName() + " has insufficient money ($" + buyer.getTheCharacter().getMoney() + ") to buy a " + _resource.getName() + " ($" + amount + "). Aborting transaction.");
			return;
		}
		else
		{
			this.removeMoneyFromBuyer();
			this.addResourceToBuyer();
			System.out.println(buyer.getTheCharacter().getName() + " has successfully bought a " + _resource.getName() + " from the Dungeon Master.");
		}
	}
	
	public ResourceTransaction(Resource _resource, int amount) {
		resource = _resource;
		super.setAmount(amount);
	}
	
	public Resource getResource() {
		return resource;
	}
	
	public void setResource(Resource _resource) {
		resource = _resource;
	}
	
	public void addResourceToBuyer() {
		super.getBuyer().getTheCharacter().addResource(resource);
	}
	
	public void removeMoneyFromBuyer() {
		super.getBuyer().getTheCharacter().removeMoney(super.getAmount());
	}
	
	public void addMoneyToSeller() {
		super.getSeller().getTheCharacter().addMoney(super.getAmount());
	}
	
}