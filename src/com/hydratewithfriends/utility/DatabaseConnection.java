package com.hydratewithfriends.utility;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseConnection {

	/**
	 * Connection reference
	 */
	Connection con = null;
	PreparedStatement pst = null;

	/**
	 * This method makes a connection to the MySQL server
	 * 
	 * @return : It returns true if the connection is made successfully and
	 *         false if it fails
	 */
	public boolean makeConnection() {

		String url = "jdbc:mysql://localhost:3306/hydratewithfriends";
		String user = "root";
		String password = "Ichbin12";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, password);
			return true;

		} catch (SQLException ex) {
			return false;
		} catch (ClassNotFoundException ex){
			return false;
		}
	}

	/**
	 * This method inserts into the water_data table
	 * 
	 * @param amount
	 *            The amount of water the user just drank
	 * @param time
	 *            The time when the user drank water
	 * @return Returns true if the Db store the value and false if there was a
	 *         connection problem
	 */
	public boolean insertInto(Long amount, Long time) {
		try {
			pst = (PreparedStatement) con.prepareStatement("INSERT INTO water_data VALUES (?,?)");
			pst.setLong(1, amount);
			pst.setLong(2, time);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		} finally {
			terminateGracefully();
		}
	}

	public void terminateGracefully() {
		try {
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException ex) {
		}
	}

}
