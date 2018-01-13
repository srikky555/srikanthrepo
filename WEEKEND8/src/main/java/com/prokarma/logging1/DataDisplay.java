package com.prokarma.logging1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class DataDisplay {

	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@172.16.203.151:1521:traindb";
	static final String USER = "bsrikanth";
	static final String PASS = "prokarma";
	static Connection conn = null;

	static Scanner sc = new Scanner(System.in);
	private static PreparedStatement stmt4;
	private static PreparedStatement stmt5;

	static void Display(Logger logger) throws SQLException {
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt4 = conn.prepareStatement("select Title from Maintask_Details");

			ResultSet resultset1 = stmt4.executeQuery();
			logger.info("Existing maintasks list");
			while (resultset1.next()) {
				String titles = resultset1.getString(1);
				logger.info(titles);
			}
			logger.info("please enter the title of maintask to be displayed from above list");
			String title = sc.next();

			PreparedStatement pstmt = conn.prepareStatement(
					"select m.Title,m.Description,p.personname,p.personage from Maintask_details m join Person_Details p on p.Personid=m.Personid where m.Title=?");
			pstmt.setString(1, title);
			ResultSet resultset = pstmt.executeQuery();

			while (resultset.next()) {
				logger.info("Title of Maintask");
				logger.info(resultset.getString(1));
				logger.info("Description of Maintask");
				logger.info(resultset.getString(2));
				logger.info("person assigned to Maintask");
				logger.info(resultset.getString(3));
				logger.info("person age");
				logger.info(resultset.getInt(4));

			}

			stmt5 = conn.prepareStatement(
					"select s.Title,s.description,p.Personname,p.Personage,s.ESTIMATEDHRS from Subtask_Details s join Person_Details p on p.Personid=s.PERSONID  where s.Maintaskid in (select Maintaskid from Maintask_Details where Maintask_Details.Title=?)");
			stmt5.setString(1, title);
			ResultSet resultset11 = stmt5.executeQuery();
			logger.info("Existing Subtasksasks list of " + title);
			while (resultset11.next()) {
				logger.info("Title of SubTask");
				logger.info(resultset11.getString(1));
				logger.info("Description of SubTask");
				logger.info(resultset11.getString(2));
				logger.info("person assigned to Subtask");
				logger.info(resultset11.getString(3));
				logger.info("person age");
				logger.info(resultset11.getInt(4));
				logger.info("Estimated hours of subtask");
				logger.info(resultset11.getInt(5));
			}
		} catch (Exception e) {
			logger.error(e);
		}

		finally {
			conn.close();
		}
	}
}
