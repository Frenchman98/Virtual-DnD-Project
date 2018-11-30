package dnd.software;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


import dnd.players.*;

public class Game implements Serializable{
	private DungeonMaster theDM;
	private ArrayList<Player> thePlayers;
	//TODO: Other attributes needed? Armor? Resources? Weapons?
	public Game() {
		theDM = new DungeonMaster();
		thePlayers = new ArrayList<Player>();
	}
	
	
	public DungeonMaster getTheDM() {
		return theDM;
	}

	public void setTheDM(DungeonMaster theDM) {
		this.theDM = theDM;
	}

	public ArrayList<Player> getThePlayers() {
		return thePlayers;
	}

	public void setThePlayers(ArrayList<Player> thePlayers) {
		this.thePlayers = thePlayers;
	}

	public void addPlayer(Player myPlayer) {
		thePlayers.add(myPlayer);
	}
	
	public void removePlayer(Player myPlayer) {
		thePlayers.remove(myPlayer);
	}
	
	//TODO: Printing methods? Are they needed?

	public static Game loadData() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Game aGame = null;
		
		try {
			fileIn = new FileInputStream("Game.ser");
			objIn = new ObjectInputStream(fileIn);
			aGame = (Game) objIn.readObject(); //serialized from the object
			objIn.close();
			fileIn.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
			
		}
		catch(ClassNotFoundException c){
			c.printStackTrace(); //print if cannot find the class
		}
		
		return aGame;
		
	}
	
	public static void saveData(Game aGame) {
		try 
			{
				FileOutputStream fileOut = new FileOutputStream("Game.ser"); //.ser means it's serialized
				ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
				objOut.writeObject(aGame);
				objOut.close();
				fileOut.close();
			}
		catch(IOException ex)
			{
				ex.printStackTrace();
			}
	}

}
