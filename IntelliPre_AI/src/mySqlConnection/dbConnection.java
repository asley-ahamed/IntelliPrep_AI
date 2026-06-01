package mySqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection 
{
    private static final String URL = "jdbc:mysql://localhost:3306/intelliPrepAi_db";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection()
    {
        Connection connection = null;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return connection;
    }
}