package dnd.transactions;

import java.util.*;

import dnd.players.Player;

public class Transaction {
	
	private Player Buyer;
	private Player Seller;
	private int Amount;
	
	public Transaction() {
		Buyer = null;
		Seller = null;
		Amount = 0;
	}
	
	public Player getSeller() {
		return this.Seller;
	}
	
	public Player getBuyer() {
		return this.Buyer;
	}
	
	public int getAmount() {
		return this.Amount;
	}
	
	public void setSeller(Player s) {
		this.Seller = s;
	}
	
	public void setBuyer(Player b) {
		this.Buyer = b;
	}
	
	public void setAmount(int amt) {
		this.Amount = amt;
	}
	
}