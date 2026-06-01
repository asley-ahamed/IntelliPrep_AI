package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mySqlConnection.dbConnection;

public class loginModel 
{
	
	public static boolean loginUser(String username,String password)
	{
		String sql="SELECT * FROM users WHERE username=? AND password=?";
		
		try(Connection connection =dbConnection.getConnection();
				PreparedStatement statement =connection.prepareStatement(sql))
		{
			statement.setString(1,username);
			statement.setString(2,password);
			
			ResultSet rs=statement.executeQuery();
			return rs.next();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}

	}

}
