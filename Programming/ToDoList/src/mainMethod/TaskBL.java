package mainMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TaskBL {
	ConnectionJdbc con = new ConnectionJdbc();
	Scanner sc = new Scanner(System.in);
	
	public void addAll() throws ClassNotFoundException, SQLException
	{
		Connection con1=con.getConnection();
		System.out.println("How many task you want add");
		int n = sc.nextInt();
		for(int i =1;i<=n;i++) {
		System.out.println("Enter title of task ");
		
		String title=sc.next();
		sc.nextLine();
		String q=Query.getInsert();
		PreparedStatement ps=con1.prepareStatement(q);
		ps.setString(1,title);
		int i1=ps.executeUpdate();
		if(i1>0)
		{
			System.out.println("task added successfully.");
		}
		else
		{
			System.out.println("failed to add task.");
		}
		ps.close();
	}
	}
	public void update() throws SQLException {
		
		Connection con1=con.getConnection();
		System.out.println("How many task you want Update");
		int n = sc.nextInt();
		for(int i =1; i<=n; i++) {
			String sql = Query.getUpdateTS();
			PreparedStatement ps = con1.prepareStatement(sql);
			System.out.println("Enter Title to change");
			String title = sc.next();
			sc.nextLine();
			ps.setString(1, title);
			System.out.println("Enter Status to change");
			String status = sc.next();
			sc.nextLine();
			ps.setString(2, status);
			System.out.println("Enter Task id where you want to change");
			int tno = sc.nextInt();
			ps.setInt(3, tno);
			int i1 = ps.executeUpdate();
			if(i1>0) {
				System.out.println("Task Updated successfully");
			}else {
				System.out.println("failed to Update Task");
			}
			
		}
		
		
	}
	public void view() throws SQLException {
		Connection con1 = con.getConnection();
		String sql = Query.getSelect();
		Statement st = con1.createStatement();
		ResultSet rs =  st.executeQuery(sql);
		while(rs.next()) {
			System.out.println("[ Task ID = "+rs.getInt(1)+"| Task = "+rs.getString(2)+"| Status = "+rs.getString(3)+" ]");
		}
		
		
	}
	public void delete() throws SQLException {
		Connection con1 = con.getConnection();
		System.out.println("How many task you want delete");
		int n = sc.nextInt();
		for(int i =1; i<=n; i++) {
			String sql = Query.getDelete();
			PreparedStatement ps = con1.prepareStatement(sql);
			System.out.println("Enter Task id which you want to delete");
			int tno = sc.nextInt();
			ps.setInt(1, tno);
			int i1 = ps.executeUpdate();
			if(i1>0) {
				System.out.println("Task deleted successfully");
			}else {
				System.out.println("failed to delete Task");
			}
			
		}
		
	}
	public void updTask() throws SQLException {
		Connection con1 = con.getConnection();
		System.out.println("How many task you want Update");
		int n = sc.nextInt();
		for(int i =1; i<=n; i++) {
			String sql = Query.getUpdateT();
			PreparedStatement ps = con1.prepareStatement(sql);
			System.out.println("Enter Title to change");
			sc.nextLine();
			String title = sc.nextLine();
			ps.setString(1, title);
			System.out.println("Enter Task id where you want to change");
			int tno = sc.nextInt();
			ps.setInt(2, tno);
			int i1 = ps.executeUpdate();
			if(i1>0) {
				System.out.println("Task Updated successfully");
			}else {
				System.out.println("failed to Update Task");
			}
			
		}
		
		
	}
	public void updStatus() throws SQLException {
		Connection con1 = con.getConnection();
		System.out.println("How many task you want Update");
		int n = sc.nextInt();
		for(int i =1; i<=n; i++) {
			String sql = Query.getUpdateS();
			PreparedStatement ps = con1.prepareStatement(sql);
			System.out.println("Enter Status to change");
			sc.nextLine();
			String status = sc.nextLine();
			ps.setString(1, status);
			System.out.println("Enter Task id where you want to change");
			int tno = sc.nextInt();
			ps.setInt(2, tno);
			int i1 = ps.executeUpdate();
			if(i1>0) {
				System.out.println("Task Updated successfully");
			}else {
				System.out.println("failed to Update Task");
			}
			
		}
		
	}
	
	
	
	
	
	
	
}
