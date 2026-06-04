package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mySqlConnection.dbConnection;

public class forgotPasswordModel
{
    public int getUserIdByEmail(String email)
    {
        int userId = 0;

        String sql = "SELECT user_id FROM users WHERE email = ?";

        try
        (
            Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                userId = resultSet.getInt("user_id");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return userId;
    }

    public boolean saveOtp(int userId, String otp)
    {
        String disableOldOtp =
                "UPDATE password_reset_otps " +
                "SET is_used = TRUE " +
                "WHERE user_id = ? AND is_used = FALSE";

        String insertOtp =
                "INSERT INTO password_reset_otps " +
                "(user_id, otp_code, expiry_time) " +
                "VALUES (?, ?, DATE_ADD(NOW(), INTERVAL 5 MINUTE))";

        try
        (
            Connection connection = dbConnection.getConnection()
        )
        {
            PreparedStatement updateStatement =
                    connection.prepareStatement(disableOldOtp);

            updateStatement.setInt(1, userId);
            updateStatement.executeUpdate();

            PreparedStatement insertStatement =
                    connection.prepareStatement(insertOtp);

            insertStatement.setInt(1, userId);
            insertStatement.setString(2, otp);

            return insertStatement.executeUpdate() > 0;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean verifyOtp(int userId, String otp)
    {
        String sql =
                "SELECT otp_id FROM password_reset_otps " +
                "WHERE user_id = ? " +
                "AND otp_code = ? " +
                "AND is_used = FALSE " +
                "AND expiry_time > NOW() " +
                "ORDER BY otp_id DESC LIMIT 1";

        try
        (
            Connection connection = dbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setInt(1, userId);
            statement.setString(2, otp);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePassword(int userId, String newPassword)
    {
        String updatePassword =
                "UPDATE users SET password = ? WHERE user_id = ?";

        String markOtpUsed =
                "UPDATE password_reset_otps " +
                "SET is_used = TRUE " +
                "WHERE user_id = ? AND is_used = FALSE";

        try
        (
            Connection connection = dbConnection.getConnection()
        )
        {
            PreparedStatement updateStatement =
                    connection.prepareStatement(updatePassword);

            updateStatement.setString(1, newPassword);
            updateStatement.setInt(2, userId);

            int updatedRows = updateStatement.executeUpdate();

            PreparedStatement otpStatement =
                    connection.prepareStatement(markOtpUsed);

            otpStatement.setInt(1, userId);
            otpStatement.executeUpdate();

            return updatedRows > 0;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
