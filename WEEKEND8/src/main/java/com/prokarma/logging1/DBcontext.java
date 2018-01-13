package com.prokarma.logging1;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBcontext {

	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@172.16.203.151:1521:traindb";
	static final String USER = "bsrikanth";
	static final String PASS = "prokarma";
		static Connection conn = null;
	
		private static int pid1;
		private static int mid;
		private static PreparedStatement pstmt;
		private static PreparedStatement stmt4;
		private static PreparedStatement pstmt1;
		private static int pid;
		 static void intialize(MainTask mt) throws SQLException
		{
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		 CallableStatement stmt=conn.prepareCall("{call Insert_Person(?,?)}"); 
			stmt.setString(1,mt.p.getName());  
			stmt.setInt(2,mt.p.getAge());  
			stmt.execute();
		
			 pstmt = conn.prepareStatement("select Personid from Person_details where Personname =? and Personage=?");
			 pstmt.setString(1,mt.p.getName());  
				pstmt.setInt(2,mt.p.getAge());  
			ResultSet resultset =pstmt.executeQuery();
		 while(resultset.next())
		 {
			 pid1 = resultset.getInt(1);
		 
		 }
			CallableStatement stmt2=conn.prepareCall("{call Insert_Maintask(?,?,?)}");  
			stmt2.setString(1,mt.getTitle());  
			stmt2.setString(2,mt.getDescription());  
			stmt2.setInt(3, pid1);
			stmt2.execute();
			resultset.close();
			stmt2.close();
		if (!(mt.sb.isEmpty())){
			
		
			for(Subtask st :mt.sb)
			{
				

				CallableStatement stmt3=conn.prepareCall("{call Insert_Person(?,?)}"); 
				stmt3.setString(1,st.p1.getName());  
				stmt3.setInt(2,st.p1.getAge());  
				stmt3.execute(); 
				
				stmt4= conn.prepareStatement("select MaintaskId from Maintask_Details where Title =? and Description=?");
				stmt4.setString(1,mt.getTitle());  
				stmt4.setString(2,mt.getDescription());  				
				ResultSet resultset1 = stmt4.executeQuery();
			 
				if(resultset1.next())
			 {
				 mid = resultset1.getInt(1);
			 
			 }
				resultset1.close();
				
				 pstmt1 = conn.prepareStatement("select Personid from Person_details where Personname=? and Personage=?");
				 pstmt1.setString(1,st.p1.getName());  
				 pstmt1.setInt(2,st.p1.getAge());   
				ResultSet resultset3 =pstmt1.executeQuery();
		
			 if(resultset3.next())
			 {
				 pid = resultset3.getInt(1);
			 
			 }
			 resultset3.close();
				CallableStatement stmt6=conn.prepareCall("{call Insert_Subtask(?,?,?,?,?)}");  
				stmt6.setString(1,st.getTitle());  
				stmt6.setString(2,st.getDescription());  
				stmt6.setInt(3, st.estimatehours);
				stmt6.setInt(4,mid );
				stmt6.setInt(5,pid);
				stmt6.execute();
			}			
		
		} 
		}
		
		catch (final SQLException se) {

			se.printStackTrace();
			se.getMessage();
			conn.rollback();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
		}

}
