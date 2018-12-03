package dnd.software;

import dnd.players.*;

public class Driver2 {

	//TODO: 
	//This is just a temporary driver to test the GUI
	public static void main(String[] args)
	{
		Game myGame = new Game();
		Player myPlayer = new Player("Alli", "1234");
		DungeonMaster myDM = new DungeonMaster("Curt", "4567");
		myGame.addPlayer(myPlayer);
		myGame.setTheDM(myDM);
		DnDGUI dndGUI = new DnDGUI("DnD GUI", myGame);    
	}
}
