package dnd.resources;

import java.sql.*;
import java.util.ArrayList;


public class MySQLAccess 
{
	private static final String userName = "myuser";
	private static final String password = "xxxx";
	private static final String dbName = "dnddb";
	private static final String connectionStr = 
			"jdbc:mysql://localhost:3306/" + dbName + "?user=" + userName + "&password=" + password +
			"&useUnicode=true&characterEncoding=UTF-8";
	private static TABLE sel = null;
	private static Connection conn = null;
	private Statement stmt = null;
	private Integer numRows = null;
	
	enum TABLE
	{
		RACE, 
		WEAPONS,
		ARMOURS;	
	}
	
	public MySQLAccess(TABLE sel) throws SQLException
	{
        MySQLAccess.sel = sel;
		// Step 1: Allocate a database 'Connection' object
        System.out.println("Connecting database...");
        
		Connection conn = DriverManager.getConnection(connectionStr);
    	System.out.println("Database connected!");
        // Step 2: Allocate a 'Statement' object in the Connection
        stmt = conn.createStatement();
	}
	

    public void CloseConnections()
    {
    	try 
    	{
    		if (stmt != null)
    		{
    			stmt.close();
    		}
    		
    		if (conn != null)
    		{
    			conn.close();
    		}
    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
	
	public void setTableSelect(TABLE sel)
	{
		MySQLAccess.sel = sel;
	}
	
	// Gets the number of rows in the current table	
	public Integer getNumRows()
	{
		return numRows;
	}
	
	public void readTable()
	{
		try
		{
			String tableSel = ToString(sel);
	        // Step 3: Execute a SQL SELECT query, the query result
	        //  is returned in a 'ResultSet' object.
	        String strSelect = "select * from " + dbName + "." + tableSel;
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
	        System.out.println("Total number of " + tableSel + " = " + rowCount);
	        
	        numRows = rowCount;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		// Step 5: Close the resources - Done automatically by try-with-resources
	}
	
	// Pass in entries to columns for a table. First column is id and is automatically incremented, so don't pass in the next
	// value of it. The method creates the rows based on the values and type of table inputted
	public void addToTable(String[] vals) throws SQLException, Exception
	{
		try (
				// Step 1: Allocate a database 'Connection' object
				Connection connect = DriverManager.getConnection(connectionStr);
		        // Step 2: Allocate a 'Statement' object in the Connection
		        Statement statemnt = connect.createStatement();
				) 
        {
        	String tableSel = ToString(sel);
        	
        	ResultSet rst;
        	
        	rst = statemnt.executeQuery("select * from " + dbName + "." + tableSel); // Doing this to obtain metadata
        	
        	ResultSetMetaData rstMData= rst.getMetaData();
            
            String input = GetPrepStmtInput(rstMData, tableSel);
            
            // PreparedStatements can use variables and are more efficient
            PreparedStatement ppdStmt = connect.prepareStatement(input);
            // Parameters start with 1
            SetParameters(ppdStmt, vals, rstMData);
            ppdStmt.executeUpdate();
            
            System.out.println("Checking that the field was inserted into the database correctly...");
            
            ppdStmt = connect.prepareStatement("select * from " + dbName + "." + tableSel);
            rst = ppdStmt.executeQuery();
            writeResultSet(rst);

            rst = statemnt.executeQuery("select * from " + dbName + "." + tableSel);
            writeMetaData(rst);
            
            numRows++;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 
    }
	public void removeFromTable(int id) throws SQLException, Exception
	{
		try (
				// Step 1: Allocate a database 'Connection' object
				Connection connect = DriverManager.getConnection(connectionStr);
		        // Step 2: Allocate a 'Statement' object in the Connection
		        Statement statemnt = connect.createStatement();
				)
        {
        	String tableSel = ToString(sel);
        	
        	ResultSet rst;
            
            String input = "delete from " + dbName + "." + tableSel + " where id= ?; ";
            
            // PreparedStatements can use variables and are more efficient
            PreparedStatement ppdStmt = connect.prepareStatement(input);
            // Parameters start with 1
            ppdStmt.setInt(1, id);
            ppdStmt.executeUpdate();
            
            System.out.println("Checking that the field was deleted from the database correctly...");
            
            ppdStmt = connect.prepareStatement("select * from " + dbName + "." + tableSel);
            rst = ppdStmt.executeQuery();
            writeResultSet(rst);

            rst = statemnt.executeQuery("select * from " + dbName + "." + tableSel);
            writeMetaData(rst);
            
            numRows--;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 
    }
	
	public ArrayList<String> getRowFromTable(int id) throws SQLException, Exception
	{
		ArrayList<String> rowData = null;
		try (
				// Step 1: Allocate a database 'Connection' object
				Connection connect = DriverManager.getConnection(connectionStr);
		        // Step 2: Allocate a 'Statement' object in the Connection
		        Statement statemnt = connect.createStatement();
				) {
        	String tableSel = ToString(sel);
        	
        	ResultSet rst;
            
            String input = "select * from " + dbName + "." + tableSel + " where id= ?; ";
            
            // PreparedStatements can use variables and are more efficient
            PreparedStatement ppdStmt = connect.prepareStatement(input);
            // Parameters start with 1
            ppdStmt.setInt(1, id);
            rst = ppdStmt.executeQuery();
            
            rowData = getResultSetData(rst);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
		return rowData; 
	}
	
	private ArrayList<String> getResultSetData(ResultSet rst) throws SQLException
	{
		ResultSetMetaData mtData = rst.getMetaData();
    	ArrayList<String> output = new ArrayList<String>();
    	
        // ResultSet is initially before the first data set
        while (rst.next()) 
        {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
        	for (int i = 0; i < mtData.getColumnCount(); i++)
        	{
        		output.add(mtData.getColumnName(i) + ": " + rst.getString(mtData.getColumnName(i)));
        	}
        }
        return output;
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
	
    private static String ToString(TABLE sel)
    {
    	switch(sel)
    	{
    	case RACE:
    		return "races";
    	case WEAPONS:
    		return "weapons";
    	case ARMOURS:
    		return "armours";
		default:
			return "";
    	}
    }
    
    private static String GetPrepStmtInput(ResultSetMetaData rstMData, String tableSel) throws SQLException
    {
    	String input = "insert into " + dbName + "." + tableSel + " values (default"; // column id is default
        for (int i = 1; i <= rstMData.getColumnCount(); i++) // rest of the table's columns are '?'
        {
        	input = input + ", ?";
        }
        input = input + ");";
        
        return input;
    }
    
    private void SetParameters(PreparedStatement ppdStmt, String[] vals, ResultSetMetaData rstMData) throws SQLException
    {
    	String colTypeName;
    	for (int i = 1; i <= rstMData.getColumnCount(); i++)
    	{
    		colTypeName = rstMData.getColumnTypeName(i);
    		if ((colTypeName == JDBCType.CHAR.getName()) || (colTypeName == JDBCType.VARCHAR.getName()) || (colTypeName == JDBCType.LONGVARCHAR.getName()))
    		{
				ppdStmt.setString(i, vals[i-1]);
    		}
    		else if ((colTypeName == JDBCType.NUMERIC.getName()) || (colTypeName == JDBCType.DECIMAL.getName()))
    		{
    			ppdStmt.setBigDecimal(i,  new java.math.BigDecimal(vals[i-1]));
    		}	
    		else if (colTypeName == JDBCType.BIT.getName())
    		{
    			ppdStmt.setBoolean(i, Boolean.valueOf(vals[i-1]));
    		}
    		else if (colTypeName == JDBCType.TINYINT.getName())
    		{
    			ppdStmt.setByte(i, Byte.valueOf(vals[i-1]));
    		}
    		else if (colTypeName == JDBCType.SMALLINT.getName())
    		{
    			ppdStmt.setShort(i, Short.valueOf(vals[i-1]));
    		}
    		else if (colTypeName == JDBCType.INTEGER.getName())
    		{
    			ppdStmt.setInt(i,  Integer.valueOf(vals[i-1]));
    		}
    		else if (colTypeName == JDBCType.BIGINT.getName())
    		{
    			ppdStmt.setLong(i, Long.valueOf(vals[i-1]));
    		}
    		else if (colTypeName == JDBCType.REAL.getName())
    		{
    			ppdStmt.setFloat(i, Float.valueOf(vals[i-1]));
    		}
    		else if ((colTypeName == JDBCType.FLOAT.getName()) || (colTypeName == JDBCType.DOUBLE.getName()))
    		{
    			ppdStmt.setDouble(i, Double.valueOf(vals[i-1]));
    		}
    		else if ((colTypeName == JDBCType.BINARY.getName()) || (colTypeName == JDBCType.VARBINARY.getName()) || (colTypeName == JDBCType.LONGVARBINARY.getName()))
    		{
    			System.out.println("WARNING: Byte arrays aren't handled in Jdbc.SetParameters()");
    		}
    		else if (colTypeName == JDBCType.DATE.getName())
    		{
    			ppdStmt.setDate(i,  new java.sql.Date(Long.valueOf(vals[i-1])));
    		}
    		else if (colTypeName == JDBCType.TIME.getName())
    		{
    			ppdStmt.setTime(i, new java.sql.Time(Long.valueOf(vals[i-1])));
    		}
    		else if (colTypeName == JDBCType.TIMESTAMP.getName())
    		{
    			ppdStmt.setTimestamp(i, new java.sql.Timestamp(Long.valueOf(vals[i-1])));
    		}
    		else 
    		{
    			throw new SQLException("Unrecognized Column Type Name");
    		}
    	}
    }
}