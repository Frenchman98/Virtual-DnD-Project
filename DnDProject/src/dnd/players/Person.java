package dnd.players;

import java.io.Serializable;
import java.util.ArrayList;

import dnd.transactions.ResourceTransaction;
import dnd.transactions.Transaction;
import dnd.transactions.XPSkillTransaction;

public abstract class Person implements Serializable{
	private String username;
	private String password;
	protected boolean loggedIn = false;
	protected ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	public Person() {
		username = "Unknown name";
		password = "Unknown password";
	}

	//Getters and Setters
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	//If password is incorrect, loggedIn should stay false and ask the user to try again
	public void logIn(String aUsername, String aPassword) {
		if(aUsername.equals(username)) {
			if(aPassword.equals(password)) {
				loggedIn = true;
				System.out.println("Log in successful");
				return;
			}
			else
			{
				loggedIn = false;
				System.out.println("Incorrect password. Please try again.");
				return;
			}
		}
		else {
			System.out.println("Incorrect or nonexistent username. Please try again.");
		}
		
	}
	
	public void logOut() {
		loggedIn = false;
	}
	
	//TODO: Add aTransaction and execute the transaction (remove money or experience
	//Buy/sells skill to a Character
	public abstract void makeXPTransaction(XPSkillTransaction aTransaction);
	
	//TODO: Add aTransaction and execute the transaction (remove money or experience
	//Buy/sells resource to a Character
	public abstract void makeResourceTransaction(ResourceTransaction aTransaction);

}
