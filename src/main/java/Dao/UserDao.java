package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

import Connection.DBConnection;
import Model.User;

public class UserDao {
	public static void signup(User u) {
		try {
			Connection connect = DBConnection.CreateConnection();
			String sqlStinString = "insert into user (first_name,last_name,mobile,gender,address,email,password) values (?,?,?,?,?,?,?)";
			PreparedStatement pst = connect.prepareStatement(sqlStinString);

			pst.setString(1, u.getFirst_name());
			pst.setString(2, u.getLast_name());
			pst.setLong(3, u.getMobile());
			pst.setString(4, u.getGender());
			pst.setString(5, u.getAddress());
			pst.setString(6, u.getEmail());
			pst.setString(7, u.getPassword());

			pst.executeUpdate();
			System.out.println("Data inserterd Succesfully.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static User login(User u) {
		User u1 = null;
		try {
			Connection Conn = DBConnection.CreateConnection();
			String sql = "select * from user where email=? and password=?";
			PreparedStatement pst = Conn.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				u1 = new User();
				u1.setFirst_name(rs.getString("first_name"));
				u1.setLast_name(rs.getString("last_name"));
				u1.setEmail(rs.getString("email"));
				u1.setMobile(rs.getLong("mobile"));
				u1.setGender(rs.getString("gender"));
				u1.setAddress(rs.getString("address"));
				u1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u1;
	}

	public static boolean checkOldPassword(int id, String op) {
		boolean flag = false;
		try {
			Connection connection = DBConnection.CreateConnection();
			String sqlString = "select * from user where id=? and password=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, id);
			pst.setString(2, op);
			ResultSet rSet = pst.executeQuery();
			if (rSet.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void changePasswrod(int id,String np) {
			try {
				Connection connection = DBConnection.CreateConnection();
				String sqlString="update user set password=? where id=?";
				PreparedStatement pst = connection.prepareStatement(sqlString);
				pst.setString(1, np);
				pst.setInt(2, id);
				pst.executeUpdate();
				System.out.println("password changed");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
			public static boolean checkEmail(String email) {
				boolean flag = false;
				try {
					Connection connection = DBConnection.CreateConnection();
					String sqlString="select * from user where email=?";
					PreparedStatement pst = connection.prepareStatement(sqlString);
					pst.setString(1, email);
					ResultSet rs  = pst.executeQuery();
					if(rs.next()) {
						flag = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return flag;
			
			}
			public static void ChangeNewPasswrod(String email,String np) {
				try {
					Connection connection = DBConnection.CreateConnection();
					String sqlString="update user set password=? where email=?";
					PreparedStatement pst = connection.prepareStatement(sqlString);
					pst.setString(1, np);
					pst.setString(2, email);
					pst.executeUpdate();
					System.out.println("password changed");
				} catch (Exception e) {
					e.printStackTrace();
	

}
			}
	}
