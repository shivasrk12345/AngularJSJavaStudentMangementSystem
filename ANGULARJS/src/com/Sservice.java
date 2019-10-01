package com;

import java.util.ArrayList;

public class Sservice {
	
	Dao d=new Dao();
	public Student addStudent(Student s)
	{
		return d.addStudent(s);
	}
	
	public ArrayList<Student> viewAll()
	{
		return d.viewAll();
	}
	public String deleteStudent(int Id) 
	{
		return d.deleteStudent(Id);
	}
	public String updateStudent(Student s) 
	{
		return d.updateStudent(s);
	}
}
