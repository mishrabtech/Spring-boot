package com.Dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empdetail")
public class Empdata {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String empname,empcom,empmob,empemail;
	
	
	
	public Empdata(String empname, String empcom, String empmob, String empemail) {
		super();
		this.empname = empname;
		this.empcom = empcom;
		this.empmob = empmob;
		this.empemail = empemail;
	}
	public Empdata() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpcom() {
		return empcom;
	}
	public void setEmpcom(String empcom) {
		this.empcom = empcom;
	}
	public String getEmpmob() {
		return empmob;
	}
	public void setEmpmob(String empmob) {
		this.empmob = empmob;
	}
	public String getEmpemail() {
		return empemail;
	}
	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}

}
