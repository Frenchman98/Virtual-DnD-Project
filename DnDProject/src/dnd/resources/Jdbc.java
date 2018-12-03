package dnd.resources;

import java.sql.*;

public class Jdbc 
{
	private static final String userName = "myuser";
	private static final String password = "xxxx";
	
		
	public static void readRacesTable()
	{
		try 
		(
		// Step 1: Allocate a database 'Connection' object
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnddb?useSSL=false", userName, password);
        // 										MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"

        // Step 2: Allocate a 'Statement' object in the Connection
        Statement stmt = conn.createStatement();
				) 
		{
	        // Step 3: Execute a SQL SELECT query, the query result
	        //  is returned in a 'ResultSet' object.
	        String strSelect = "select name from dnddb.races";
	        System.out.println("The SQL query is: " + strSelect); // Echo For debugging
	        System.out.println();
	
	        ResultSet rset = stmt.executeQuery(strSelect);
	
	        // Step 4: Process the ResultSet by scrolling the cursor forward via next().
	        //  For each row, retrieve the contents of the cells with getXxx(columnName).
	        System.out.println("The records selected are:");
	        int rowCount = 0;
	        while(rset.next()) 
	        {   
	        	// Move the cursor to the next row, return false if no more row
	           String name = rset.getString("name");
	           System.out.println(name);
	           ++rowCount;
	        }
	        System.out.println("Total number of races = " + rowCount);
	        
	        // Closing the ResultSet
	        rset.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		// Step 5: Close the resources - Done automatically by try-with-resources
	}
	
	public void addToRaceTable(String name) throws Exception 
	{
        try 
        (
    		
			// Step 1: Allocate a database 'Connection' object
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnddb?useSSL=false", userName, password);
	        // 										MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
	
	        // Step 2: Allocate a 'Statement' object in the Connection
	        Statement stmt = conn.createStatement();
        		)
        {
        	// This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");

            // PreparedStatements can use variables and are more efficient
            PreparedStatement ppdStmt = conn.prepareStatement("insert into  dnddb.races values (default, ?)");
            // "name from dnddb.races");
            // Parameters start with 1
            ppdStmt.setString(1, name);
            ppdStmt.executeUpdate();
            
            System.out.println("Checking that the field was inserted into the database correctly...");
            
            ppdStmt = conn.prepareStatement("select * from dnddb.races");
            ResultSet rst = ppdStmt.executeQuery();
            writeResultSet(rst);

            rst = stmt.executeQuery("select * from dnddb.races");
            writeMetaData(rst);

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 
    }

    private void writeMetaData(ResultSet rst) throws SQLException 
    {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + rst.getMetaData().getTableName(1));
        
        for  (int i = 0; i < rst.getMetaData().getColumnCount(); i++)
        {
            System.out.println("Column " + (i+1) + " "+ rst.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet rst) throws SQLException 
    {
    	ResultSetMetaData mtData = rst.getMetaData();
    	
        // ResultSet is initially before the first data set
        while (rst.next()) 
        {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
        	for (int i = 0; i < mtData.getColumnCount(); i++)
        	{
        		System.out.println(mtData.getColumnName(i) + ": " + rst.getString(mtData.getColumnName(i)));
        	}
        }
    }
	
}