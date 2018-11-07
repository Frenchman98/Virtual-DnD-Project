package dnd.transactions;

import java.util.*;

import dnd.players.Person;

public class Transaction {
	
	//Alli: I would recommend changing Player to Person since a DM is not a Player but both Player and DM are Person
	private Person Buyer;
	private Person Seller;
	private int Amount;
	
	public Transaction() {
		Buyer = null;
		Seller = null;
		Amount = 0;
	}
	
	public Person getSeller() {
		return this.Seller;
	}
	
	public Person getBuyer() {
		return this.Buyer;
	}
	
	public int getAmount() {
		return this.Amount;
	}
	
	public void setSeller(Person s) {
		this.Seller = s;
	}
	
	public void setBuyer(Person b) {
		this.Buyer = b;
	}
	
	public void setAmount(int amt) {
		this.Amount = amt;
	}
	
}