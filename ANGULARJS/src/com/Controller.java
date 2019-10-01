package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		Sservice ser=new Sservice();
		if(action.equalsIgnoreCase("registerStu"))
		{
			System.out.println(action);
			String name=request.getParameter("stuName");
			String email=request.getParameter("stuEmail");
			long number=Long.parseLong(request.getParameter("stuNum"));
		
			Student s=new Student(name, email, number);
			Student s1=ser.addStudent(s);
			System.out.println(number);
			if(s1!=null)
			{
				System.out.println(s1);
				String message="Added ";
				String json=new Gson().toJson(s1);
				response.setContentType("application/json");
				response.getWriter().write(json.toString());
			}
		}else if(action.equalsIgnoreCase("view"))
		{
			ArrayList<Student>list=ser.viewAll();
			if(list!=null)
			{
				System.out.println(list);
				String json=new Gson().toJson(list);
				response.setContentType("application/json");
				response.getWriter().write(json.toString());
			}
		}
		else if(action.equalsIgnoreCase("deletestu"))
		{
			System.out.println(action);
			int Id=Integer.parseInt(request.getParameter("stuid"));
			String msg=ser.deleteStudent(Id);
			System.out.println(msg);
			if(msg!=null)
			{
				System.out.println(msg);
				//String message="Added ";
				String json=new Gson().toJson(msg);
				response.setContentType("application/json");
				response.getWriter().write(json.toString());
			}
			
		
	}
		else if(action.equalsIgnoreCase("updatestu"))
		{
			System.out.println(action);
			int Id=Integer.parseInt(request.getParameter("studentid"));
			String studentname=request.getParameter("studentname");
			long studentnumber=Long.parseLong(request.getParameter("studentnumber"));
			Student s=new Student(Id, studentname, studentnumber);
			String msg=ser.updateStudent(s);
			if(msg!=null)
			{
				System.out.println(msg);
				String json=new Gson().toJson(msg);
				response.setContentType("application/json");
				response.getWriter().write(json.toString());
				
			}
		}
	}

}
