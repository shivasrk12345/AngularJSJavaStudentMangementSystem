package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
	
	public Student addStudent(Student s)
	{
		Student s1=new Student();
		Connection con=null;
		PreparedStatement ps=null;
		con=DButil.getConnection();
		int x=0;
		int a=0;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select stuid.nextval from dual");
			rs = ps.executeQuery();
			while(rs.next())
			{
				x=rs.getInt(1);
			}
			ps=con.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, x);
			ps.setString(2, s.getName());
			ps.setString(3, s.getEmail());
			ps.setLong(4, s.getNumber());
			a=ps.executeUpdate();
			ps=con.prepareStatement("select * from student where id=?");
			ps.setInt(1, x);
			ResultSet rs1=ps.executeQuery();
			while(rs1.next())
			{
				s1.setId(rs1.getInt(1));
				s1.setName(rs1.getString(2));
				s1.setEmail(rs1.getString(3));
				s1.setNumber(rs1.getLong(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s1);
		return s1;
	}
	
	public ArrayList<Student> viewAll(){
		ArrayList<Student> list=new ArrayList<Student>();
		Connection con=null;
		PreparedStatement ps=null;
		con=DButil.getConnection();
		try{
		ps=con.prepareStatement("select * from student");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Student s=new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setEmail(rs.getString(3));
			s.setNumber(rs.getLong(4));
			list.add(s);
		}
			
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		System.out.println(list);
		return list;
	}
	public String deleteStudent(int Id) 
	{
		String msg=null;
		int a=0;
		Connection con=null;
		PreparedStatement ps=null;
		con=DButil.getConnection();
		try {
			ps=con.prepareStatement("Delete from student where id=?");
			ps.setInt(1, Id);
			a=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a>0)
			msg="succesfully deleted";
		
		return msg;
	
	}
	public String updateStudent(Student s) 
	{
		String msg=null;
		int a=0;
		Connection con=null;
		PreparedStatement ps=null;
		con=DButil.getConnection();
		try {
			ps=con.prepareStatement("update student set name=?,num=? where id=?");
			ps.setString(1, s.getName());
			ps.setLong(2, s.getNumber());
			ps.setInt(3, s.getId());
			a=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a>0)
		{
			msg="successfully updated";
		}
		return msg;
	}
	

}
