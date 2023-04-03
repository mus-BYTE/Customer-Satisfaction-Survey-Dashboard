import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() {
		try {
			// step-1 : Register driver
			Class.forName("org.postgresql.Driver");

			// step-2 : Open a connection
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres",
					"admin");

			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}