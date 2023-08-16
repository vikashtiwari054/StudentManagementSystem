package com.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("welcome to student");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
        	System.out.println("PRESS 1 TO ADD STUDENT :");
        	System.out.println("PRESS 2 TO DELETE STUDENT :");
        	System.out.println("PRESS 3 TO DISPLAY STUDENT :");
        	System.out.println("PRESS 4 TO EXIT APP");
        	int c=Integer.parseInt(br.readLine());
     
        	if(c==1){
        		//add student
        		System.out.println("enter student name");
        		String name=br.readLine();
        		System.out.println("enter student phone");
        		String phone=br.readLine();
        		System.out.println("enter student city ");
        		String city =br.readLine();
        		
        		Student stud=new Student(name,phone,city);
        		boolean answer=StudentDao.InsertStudentToDB(stud);
        		if(answer){
        			System.out.println("student is added sucessfully in database...");
        		}
        		else{
        			System.out.println("something went wrong....");
        		}
        		System.out.println(stud);
        		
        	}
        	else if(c==2){
        		System.out.println("Enter Student Id to Delete Student :");
        	    int userId=Integer.parseInt(br.readLine());
        	    boolean f=StudentDao.deleteStudent(userId);
        	if(f){
        		System.out.println("Deleted.....");
        	}else{
        		System.out.println("Something went wrong.....");
        	}
        }
        else if(c==3)
        {
    		StudentDao.showAllStudent();
        }else if(c==4)
        {
        	break;
        }else
        {
        
        }
	}
        System.out.println("Thank You......");
	}
}
