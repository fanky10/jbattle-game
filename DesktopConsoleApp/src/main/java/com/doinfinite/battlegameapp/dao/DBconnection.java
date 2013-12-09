package com.doinfinite.battlegameapp.dao;

import java.sql.*;

public class DBconnection {

	private static String host = "localhost";
	private static String dbname = "battlegame_DB";
	private static String username = "victor";
	private static String password = "local";

	public static Connection newConecttion() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		StringBuilder urlConnection = new StringBuilder();
		urlConnection.append("jdbc:mysql://");
		urlConnection.append(host);
		urlConnection.append("/");
		urlConnection.append(dbname);

		return DriverManager.getConnection(urlConnection.toString(), username,
				password);
	}

	public static void main(String[] args) throws SQLException {

		Connection conn = DBconnection.newConecttion();

		if (conn != null) {
			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of
			// using "*"
			String query = "SELECT * FROM units";

			// create the java statement
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");

				// print the results
				System.out.println("Id: " + id);
				System.out.println("Name: " + name);

			}
			st.close();

		}

	}

}
