package com.manish;

import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import com.subodh.User;  
public class Signup {  
  
public static Connection getConnection(){  
    Connection con=null;  
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","","");  
    }catch(Exception e){System.out.println(e);}  
    return con;  
}  
public static int save(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"insert into (eid,name,password,email,dob) values(?,?,?,?,?)");  
        ps.setInt(1,u.getEid());  
        ps.setString(2,u.getFirstname());  
        ps.setString(3,u.getPassword());  
        ps.setString(4,u.getEmail());  
        ps.setString(5,u.getDob());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int update(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update register set name=?,password=?,email=?, where id=?");  
        ps.setInt(1,u.getEid());  
        ps.setString(2,u.getFirstname());  
        ps.setString(3,u.getPassword());  
        ps.setString(4,u.getEmail());  
        ps.setString(5,u.getDob());    
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int delete(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from register where id=?");  
        ps.setInt(1,u.getEid());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
public static List<User> getAllRecords(){  
    List<User> list=new ArrayList<User>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from register");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            User u=new User();  
            u.setEid(0);  
            u.setFirstname(null);  
            u.setPassword(rs.getString("password"));  
            u.setEmail(rs.getString("email"));  
            u.setDob(null);  
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
public static User getRecordById(int id){  
    User u=null;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from register where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new User();  
            u.setEid(0);  
            u.setFirstname(null);  
            u.setPassword(rs.getString("password"));  
            u.setEmail(rs.getString("email"));  
            u.setDob(null);  
          
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}  
}  