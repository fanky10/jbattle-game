package com.doinfinite.battlegameapp.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.doinfinite.battlegame.mocked.MockedUnits;
import com.doinfinite.battlegame.model.Unit;

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

	private static void showUnits(Connection conn) throws SQLException {
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

	private static void insertUnit(Connection conn) throws SQLException,
			IOException {

		int x = 0;

		Statement st = conn.createStatement();
		String query = "truncate units;";

		// execute the query, and get a java resultset

		System.out.println("Do you want to add a new team to the data base?");
		System.out
				.println("1- Yes. I want to remove all the units from the data base");
		System.out.println("2- No. I want to add more units to the data base");

		BufferedReader read1 = new BufferedReader(new InputStreamReader(
				System.in));

		String a = read1.readLine();
		try {
			x = Integer.parseInt(a);
		} catch (Exception e) {
			// TODO: handle exception
		}

		switch (x) {

		case 1:

			ResultSet rs = st.executeQuery(query);
			break;

		case 2:
			

			System.out.println("Select the units to insert");
			for (Unit u: MockedUnits.getAvailableUnits()){
				
			
					
					
					System.out.println(u.getName());
					 }
			

			BufferedReader read2 = new BufferedReader(new InputStreamReader(
					System.in));

			String a2 = read1.readLine();

			String sql = "INSERT INTO units (name)" + "VALUES (?)";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, a);
			preparedStatement.executeUpdate();
			break;

		}

	}

	public static void main(String[] args) throws SQLException, IOException {

		Connection conn = DBconnection.newConecttion();

		if (conn != null) {

			showUnits(conn);
			insertUnit(conn);
			showUnits(conn);

		}

	}
}
