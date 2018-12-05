package dnd.software;

import java.sql.SQLException;

import dnd.players.*;
import dnd.resources.MySQLAccess;
import dnd.resources.MySQLAccess.TABLE;

public class Driver2 {

	//TODO: 
	//This is just a temporary driver to test the GUI
	public static void main(String[] args) throws SQLException
	{
		MySQLAccess dao = new MySQLAccess(TABLE.RACE);
		dao.readTable();
		
		dao.setTableSelect(TABLE.ARMOURS);
		dao.readTable();
		
		dao.setTableSelect(TABLE.WEAPONS);
		dao.readTable();
		
		Game myGame = new Game();
		Player myPlayer = new Player("Alli", "1234");
		DungeonMaster myDM = new DungeonMaster("Curt", "4567");
		myGame.addPlayer(myPlayer);
		myGame.setTheDM(myDM);
		DnDGUI dndGUI = new DnDGUI("DnD GUI", myGame);    
	}
}
