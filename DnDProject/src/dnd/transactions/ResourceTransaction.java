package dnd.transactions;

import java.util.*;

import dnd.resources.Resource;

public class ResourceTransaction extends Transaction {
	
	private Resource resource;
	
	public ResourceTransaction() {
		resource = null;
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
	
	//TODO: Find a way to add money to seller
	
	public void addMoneyToSeller() {
		super.getSeller();
	}
	
}