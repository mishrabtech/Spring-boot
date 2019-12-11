package com.Dao;

import org.springframework.stereotype.Component;

@Component
public class EntityBean {
	
	private String empname,empcom,empmob,empemail;

	private int id;
	
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
