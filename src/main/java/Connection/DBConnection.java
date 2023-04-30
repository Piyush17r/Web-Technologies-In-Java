package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection CreateConnection() {
		Connection Connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "root", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Connection;
	}

}
