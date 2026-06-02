package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import mySqlConnection.dbConnection;

public class signUpModel
{
	private String email;
	private String username;
	private String password;
	
	
	
	public void setEmail(String email) 
	{
		this.email = email;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public  boolean addUser()
	{
		String sql="INSERT INTO users (email,username,password)VALUES(?,?,?)";
		
		try(Connection connection=dbConnection.getConnection();
			PreparedStatement statement=connection.prepareStatement(sql))
		{
			statement.setString(1,email);
			statement.setString(2,username);
			statement.setString(3, password);
			
			 int rowInserted=statement.executeUpdate();
			 return rowInserted>0;
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return false;
		}
		
	}
	

}
