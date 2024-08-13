package Serialization;

import structure.Date;

public class Student {
	
	private int id;
	private String fname;
	private String lname;
	private Date dob;
	public Student(int id, String fname, String lname, Date dob) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	

}
