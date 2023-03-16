package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.Employee;

public class DbOperation {
	static Connection con = null;
	
	private static void connect() {
		
		String url = "jdbc:mysql://localhost:3306/httpcrud";
		String id = "root";
		String pass = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pass);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static boolean insert(Employee e) {
		 connect();
		 boolean b = true;
		 
		 try {
			PreparedStatement ps = con.prepareStatement("insert into employee value (?,?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setInt(3, e.getSalary());
			ps.setString(4, e.getDepartment());
			ps.setInt(5, e.getAge());
	
			
			if(!ps.execute()) {
				b = false;
				System.out.println("Data inserted successfully..");
			}
			else {
				System.out.println("Data not inserted !");
			}
			con.close();
		} 
		 catch (Exception ex) 
		 {
			ex.printStackTrace();
		}	 
		return b;
	}
	
	public static boolean delete(int id) {
		 connect();
		 boolean b = true;
		 
		 try {
			PreparedStatement ps = con.prepareStatement("delete from employee where id=?");
			ps.setInt(1, id);
			
			b = ps.execute();
			
//			if(!ps.execute()) {
//				System.out.println("Data deleted successfully..");
//			}
//			else {
//				System.out.println("Data not deleted !");
//			}
			con.close();
		} 
		 catch (Exception ex) 
		 {
			ex.printStackTrace();
		}	 
		return b;
	}
	
	public static Employee getDataById(int id) {
		
		connect();
		 Employee e = new Employee();
		 
		 try {
			PreparedStatement ps = con.prepareStatement("select * from employee where id = ?");
			ps.setInt(1, id);
			
	ResultSet rs = ps.executeQuery();	
	rs.next();
	
	e.setId(rs.getInt(1));
	e.setName(rs.getString(2));
	e.setSalary(rs.getInt(3));
	e.setDepartment(rs.getString(4));
	e.setAge(rs.getInt(5));
					
			con.close();
		} 
		 catch (Exception ex) 
		 {
			ex.printStackTrace();
		}	 	
		return e;
	}
	
	public static ArrayList<Employee> vewData() {
		
		 connect();
		 ArrayList<Employee> al = new ArrayList<Employee>();
		 
		 
		 try {
			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setSalary(rs.getInt(3));
			e.setDepartment(rs.getString(4));
			e.setAge(rs.getInt(5));
			al.add(e);
			}	
			con.close();
		} 
		 catch (Exception ex) 
		 {
			ex.printStackTrace();
		}
		return al;
	}
	
	public static int update(Employee e) {		
		connect();
		 int v = 0;
		 
		 try {
			PreparedStatement ps = con.prepareStatement("update employee set name=?, salary=?, department=?, age=? where id=?");
			
			ps.setString(1, e.getName());
			ps.setInt(2, e.getSalary());
			ps.setString(3, e.getDepartment());
			ps.setInt(4, e.getAge());
			ps.setInt(5, e.getId());
			
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