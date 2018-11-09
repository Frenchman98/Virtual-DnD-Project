package dnd.transactions;

import java.util.*;

import dnd.character.GameChar;
import dnd.players.Person;
import dnd.players.Player;

public class Transaction {
	
	//Alli: I would recommend changing Player to Person since a DM is not a Player but both Player and DM are Person
	private Player Buyer;
	private Player Seller;
	private Person DM;
	private GameChar NPC;
	private int Amount;
	
	public Transaction() {
		Buyer = null;
		Seller = null;
		DM = null;
		Amount = 0;
	}
	
	public Player getSeller() {
		return this.Seller;
	}
	
	public Person getDM() {
		return this.DM;
	}
	
	public Player getBuyer() {
		return this.Buyer;
	}
	
	public GameChar getNPC() {
		return this.NPC;
	}
	
	public int getAmount() {
		return this.Amount;
	}
	
	public void setSeller(Player s) {
		this.Seller = s;
	}
	
	public void setNPC(GameChar npc) {
		this.NPC = npc;
	}
	
	public void setDM(Person dm) {
		this.DM = dm;
	}
	
	public void setBuyer(Player b) {
		this.Buyer = b;
	}
	
	public void setAmount(int amt) {
		this.Amount = amt;
	}
	
}