package com.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String n=request.getParameter("name");
		String p=request.getParameter("phone");
		String c=request.getParameter("city");
		
		Student stud=new Student();
		stud.setStudentName(n);
		stud.setStudentCity(c);
		stud.setStudentPhone(p);
		
		StudentDao std=new StudentDao();
		
		//boolean str=StudentDao.InsertStudentToDB(stud);
		boolean str=StudentDao.InsertStudentToDB(stud);
		
		if(std.equals(str)){
			request.getRequestDispatcher("/index.html");
			System.out.println("sucess");
		}else{
			System.out.println("not success");
			
		}
		
	}

}
