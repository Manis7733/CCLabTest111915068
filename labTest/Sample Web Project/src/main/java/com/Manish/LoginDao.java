package com.manish;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class LoginDao {
	public boolean check(String uname,String pass)
	{
		String url ="jdbc:mysql://localhost:3306/crud";
		String sql = "select * from manish111915068detail1 where Employee_id_number=? and pwd=?";
		String username = "root";
		String pwd = "1234";		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if (rs.next())
			{
				return true;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean enter(String eid,String pwd)
	{
		String url ="jdbc:mysql://localhost:3306/crud";
		String ;
		String username = "root";
		String pwd = "1234";	
	}

}
