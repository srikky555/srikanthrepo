package com.prokarma.logging1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class Dbupdate {
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@172.16.203.151:1521:traindb";
	static final String USER = "bsrikanth";
	static final String PASS = "prokarma";
	static Connection conn = null;
	private static PreparedStatement stmt4;
	static Scanner sc = new Scanner(System.in);
	private static PreparedStatement stmt5;

	static void update(Logger logger) throws SQLException {
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt4 = conn.prepareStatement("select Title from Maintask_Details");

		ResultSet resultset1 = stmt4.executeQuery();
		logger.info("Existing maintasks list");
		while (resultset1.next()) {
			String titles = resultset1.getString(1);
			logger.info(titles);
		}
		logger.info("please enter the title of maintask to be updated from above list");
		String title = sc.next();

		PreparedStatement pstmt = conn.prepareStatement("select Maintaskid from Maintask_details where Title =?");
		pstmt.setString(1, title);
		ResultSet flag = pstmt.executeQuery();
		if (flag.next()) {

			logger.info("please select the field to be updated");
			logger.info("1.Maintask\n2.Related Subtasks");
			int option = sc.nextInt();
			if (option == 1) {

				logger.info("please enter description to be modified");

				String description = sc.next();

				String sql1 = "UPDATE Maintask_Details m SET m.Description =? WHERE m.Title =? ";

				PreparedStatement statement1 = conn.prepareStatement(sql1);
				statement1.setString(1, description);
				statement1.setString(2, title);

				int rowsUpdated = statement1.executeUpdate();
				if (rowsUpdated > 0) {
					logger.info("An existing Maintask was updated successfully!");
				}
			} else {

				stmt5 = conn.prepareStatement(
						"select s.Title from Subtask_Details s join Maintask_Details m on s.Maintaskid=m.Maintaskid where m.Title=?");
				stmt5.setString(1, title);
				ResultSet resultset = stmt5.executeQuery();
				logger.info("Existing Subtasksasks list of " + title);
				while (resultset.next()) {
					String title1 = resultset.getString(1);
					logger.info(title1);
				}
				logger.info("please enter the title of subtask to be changed");
				String stitle = sc.next();
				logger.info("please enter ther descrption of subtask to be changed");
				String sdescription = sc.next();
				String sql2 = "UPDATE Subtask_Details  SET Description =? WHERE Title =? ";
				PreparedStatement statement2 = conn.prepareStatement(sql2);
				statement2.setString(1, sdescription);
				statement2.setString(2, stitle);

				int rowsUpdated = statement2.executeUpdate();
				if (rowsUpdated > 0) {
					logger.info("An existing subtask was updated successfully!");
				}
			}
			conn.commit();
		} else {
			logger.error("this title doesnt exist");
		}

	}
}
