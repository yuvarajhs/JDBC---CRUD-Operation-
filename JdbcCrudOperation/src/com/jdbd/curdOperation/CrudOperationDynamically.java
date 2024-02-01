package com.jdbd.curdOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class CrudOperationDynamically 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/jdbc_database";
		String user="root";
		String password="Yuvaraj@123";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		while(true)
		{
			System.out.println("Enter  1.insert  2.update  3.delete  4.select  5.selectAll 6.Any other no. for Exit/Stop");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:insert(con); break;
			case 2:update(con); break;
			case 3:delete(con); break;
			case 4:select(con); break;
			case 5:selectAll(con); break;
			default:System.exit(0);
			}
		}
		
	}
	
	public static void insert(Connection con) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String query = "insert into employee values(?,?,?)";
		
		System.out.println("Enter the id , name , salary for inserting into the table");
		int id=sc.nextInt();
		String name=sc.next();
		//sc.next();
		int salary=sc.nextInt();
		
		PreparedStatement pstm=con.prepareStatement(query);
		pstm.setInt(1, id);
		pstm.setString(2, name);
		pstm.setInt(3, salary);
		pstm.executeUpdate();
		
		System.out.println("------Insertion is Done------");
		
	}
	
	public static void update(Connection con) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String query = "update employee set salary=? where id=?";
		
		System.out.println("Enter the id , salary  for updating salary in  the table");
		int id=sc.nextInt();
		int salary=sc.nextInt();
		
		PreparedStatement pstm=con.prepareStatement(query);
		pstm.setInt(1, salary);
		pstm.setInt(2, id);
		
		pstm.executeUpdate();
		
		System.out.println("------Updation is Done------");
		
	}
	
	
	public static void delete(Connection con) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String query = "delete from employee where id =?";
		
		System.out.println("Enter the id  for deleting the row in  the table");
		int id=sc.nextInt();
		
		PreparedStatement pstm=con.prepareStatement(query);
		pstm.setInt(1, id);
		pstm.executeUpdate();
		
		System.out.println("------Deletion is Done------");
		
	}
	
	
	public static void select(Connection con) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String query = "select * from employee where id=?";
		
		System.out.println("Enter the id for retriving that row");
		int id=sc.nextInt();
		
		PreparedStatement pstm=con.prepareStatement(query);
		pstm.setInt(1, id);
		ResultSet res =pstm.executeQuery();
		
		while(res.next())
		{
			System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3));
		}
		
		System.out.println("------Retriving Single row is done------");
		
	}
	
	public static void selectAll(Connection con) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String query = "select * from employee";
		Statement stm = con.createStatement();
		ResultSet res =stm.executeQuery(query);
		
		while(res.next())
		{
			System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3));
		}
		
		
		System.out.println("------Retriving all row is done------");
		
	}
	
	

}
