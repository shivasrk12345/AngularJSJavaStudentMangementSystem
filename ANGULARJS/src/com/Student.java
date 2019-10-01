package com;

public class Student {
	
	private int id;
	private String name;
	private String email;
	private long number;
	public Student(int id, String name, String email, long number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
	}
	public Student(String name, String email, long number) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
	}
	
	public Student(int id, String name, long number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email
				+ ", number=" + number + "]";
	}
	
	

}
