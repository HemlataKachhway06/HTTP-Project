package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.User;

public class DbOperation {
	static Connection con = null;
	
	private static void connect() {
		String url = "jdbc:mysql://localhost:3306/mydb";
		String id = "root";
		String pass = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pass);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static boolean register(User u) {
		connect();
		boolean b = true;
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into User(Id,Password,Name,Age,Contact,City,Travel_City) value(?,?,?,?,?,?,?)");
		    ps.setString(1, u.getId());
		    ps.setString(2, u.getPassword());
			ps.setString(3, u.getName());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getContact());
			ps.setString(6, u.getCity());
			ps.setString(7, u.getTravel_city());
			
			b = ps.execute();
			
			con.close();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return b;
	}
	
	public static boolean login(String id,String pass) {
		connect();
		boolean b = true;
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from user where id=? and password=?");
			ps.setString(1, id);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				b = false;
			}
			else {
				b = true;
			}
			con.close();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return b;
	}
	
	public static boolean delete(String id) {
		 connect();
		 boolean b = true;
		 
		 try {
			PreparedStatement ps = con.prepareStatement("delete from User where id=?");
			ps.setString(1, id);
			
			b = ps.execute();
			
			con.close();
		} 
		 catch (Exception ex) 
		 {
			ex.printStackTrace();
		}	 
		return b;
	}
	
	public static User getDataById(String id) {
		
		connect();
		User u = new User();
		 
		 try {
			PreparedStatement ps = con.prepareStatement("select Id,Name,Age,Contact,City,Travel_City from User where id = ?");
			ps.setString(1, id);
			
	ResultSet rs = ps.executeQuery();	
	rs.next();
	
	u.setId(rs.getString(1));
	u.setName(rs.getString(2));
	u.setAge(rs.getInt(3));
	u.setContact(rs.getString(4));
	u.setCity(rs.getString(5));
	u.setTravel_city(rs.getString(6));
	u.setRole(rs.getString(id));
					
			con.close();
		} 
		 catch (Exception ex) 
		 {
			ex.printStackTrace();
		}	 	
		return u;
	}
	
	public static ArrayList<User> vewData() {
		
		 connect();
		 ArrayList<User> al = new ArrayList<User>();
		 
		 try {
			PreparedStatement ps = con.prepareStatement("select * from User");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getString(1));
				u.setName(rs.getString(2));
				u.setAge(rs.getInt(3));
				u.setContact(rs.getString(4));
				u.setCity(rs.getString(5));
				u.setTravel_city(rs.getString(6));
				u.setRole(rs.getString(7));
			al.add(u);
			}	
			con.close();
		} 
		 catch (Exception ex) 
		 {
			ex.printStackTrace();
		}
		return al;
	}
	
	public static int update(User u) {		
		connect();
		 int v = 0;
		 
		 try {
			PreparedStatement ps = con.prepareStatement("update User set name=?, age=?, contact=?, city=?, travel_city=? where id=?");
			
			ps.setString(1, u.getName());
			ps.setInt(2, u.getAge());
			ps.setString(3, u.getContact());
			ps.setString(4, u.getCity());
			ps.setString(5, u.getTravel_city());
			ps.setString(6, u.getId());
			
			v = ps.executeUpdate();
			
			con.close();
		} 
		 catch (Exception ex) 
		 {
			ex.printStackTrace();
		}	 
		return v;
	}
	
	public static int resetPassword(String id, String pass) {		
		connect();
	
		int v=0;
		 try {
			PreparedStatement ps = con.prepareStatement("update user set password=? where id=?");
			ps.setString(1, pass);
			ps.setString(2, id);
			
          v = ps.executeUpdate();
			
			con.close();
		} 
		 catch (Exception ex) 
		 {
			ex.printStackTrace();
		}	 
		return v;
	}
}