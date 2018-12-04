package dnd.resources;

import java.sql.*;
import java.util.ArrayList;

import dnd.resources.MySQLAccess.TABLE;

public class Driver3 
{
	public static void main(String[] args) throws Exception
	{
		// Test Connection firstly without using the SQL class
		String url = "jdbc:mysql://localhost:3306/dnddb";
		String username = "myuser";
		String password = "xxxx";

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) 
		{
		    System.out.println("Database connected!");
		} 
		catch (SQLException e) 
		{
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		
		MySQLAccess dao = new MySQLAccess(TABLE.RACE);
		dao.readTable();
		dao.getRowFromTable(0);
		dao.addToTable(new String[] {"Orcs"});
		dao.removeFromTable(dao.getNumRows() - 1);
		ArrayList<String> test = dao.getRowFromTable(0);
		
		dao.setTableSelect(TABLE.WEAPONS);
		dao.readTable();
		
		dao.setTableSelect(TABLE.ARMOURS);
		dao.readTable();
		
		dao.CloseConnections();
	}
}
