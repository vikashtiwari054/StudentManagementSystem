package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	
	public static  boolean InsertStudentToDB(Student stud){
		
		boolean f=false;
		try{
			Connection con=CP.createC();
			String q="insert into students(sname,sphone,scity) values(?,?,?) ";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,stud.getStudentName());
			pst.setString(2,stud.getStudentPhone());
            pst.setString(3,stud.getStudentCity() );
            pst.executeUpdate();
            f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}

	public static boolean deleteStudent(int userId) {
		
		boolean f=false;
		try{
			Connection con=CP.createC();
			String q="delete from students where sid=?  ";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setInt(1,userId);
            pst.executeUpdate();
            f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}

	public static boolean showAllStudent() {
		// TODO Auto-generated method stub
		boolean f=false;
		try{
			Connection con=CP.createC();
		  	String q="select * from students ";
		    Statement stmt=con.createStatement();
		    ResultSet rst=stmt.executeQuery(q);
		
		    while(rst.next())
		    {
		    	int id=rst.getInt(1);
		    	String name=rst.getString(2);
		    	String phone=rst.getString(3);
		    	String city=rst.getString("scity");
		    	System.out.println("ID :"+id);
		    	System.out.println("Name :"+name);
		    	System.out.println("Phone :"+phone);
                System.out.println("City :"+city);
                System.out.println("++++++++++++++++++++++");
		    }
		    
            f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
		
	}
	
	

}
