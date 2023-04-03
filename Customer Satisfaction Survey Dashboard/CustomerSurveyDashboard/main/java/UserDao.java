import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.User;
import ConnectionUtil;

public class UserDao {

	public User getUserByUserName(String username) {
		String query = "select * from users where username = '" + username + "'";
		User user = new User();

		try (Connection connection = ConnectionUtil.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

}
