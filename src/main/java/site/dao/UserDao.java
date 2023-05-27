package site.dao;

import java.sql.*;
import site.model.*;
import site.utils.*;
import site.web.*;

public class UserDao {

	public int registerEmployee(User employee) throws ClassNotFoundException {
		String SELECT_USER_SQL = "SELECT COUNT(*) FROM users WHERE username = ?";
		String INSERT_USERS_SQL = "INSERT INTO users (firstname, lastname, username, password) VALUES (?, ?, ?, ?)";

		int result = 0;

		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement selectStatement = connection.prepareStatement(SELECT_USER_SQL);
				PreparedStatement insertStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

			// Check if user already exists
			selectStatement.setString(1, employee.getUsername());
			ResultSet resultSet = selectStatement.executeQuery();
			resultSet.next();
			int count = resultSet.getInt(1);

			if (count > 0) {

				System.out.println("User already exists!");
			} else {
				// User does not exist, proceed with the registration
				insertStatement.setString(1, employee.getFirstName());
				insertStatement.setString(2, employee.getLastName());
				insertStatement.setString(3, employee.getUsername());
				insertStatement.setString(4, employee.getPassword());

				result = insertStatement.executeUpdate();
			}

		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}

		return result;
	}

	public int Editemployee(User employee) throws ClassNotFoundException {
		String sql = "UPDATE users SET firstname = ?, lastname = ?, password = ? WHERE username = '"
				+ LoginController.usekaro + "'";

		int result = 0;
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			System.out.println("editing chalu hai");

			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getPassword());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			JDBCUtils.printSQLException(e);
		}
		return result;
	}

}
