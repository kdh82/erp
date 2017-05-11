package kr.or.dgit.ncs_erp.dto;

import java.util.Date;

public class Employee {
	private String eNo;
	private String eName;
	private Title title;
	private int salary;
	private boolean gender;		
	private Department department;
	private Date joinDate;
	
	public Employee() {}
	
	public Employee(String eNo, String eName, Title title, int salary, boolean gender, Department department,
			Date joinDate) {
		this.eNo = eNo;
		this.eName = eName;
		this.title = title;
		this.salary = salary;
		this.gender = gender;
		this.department = department;
		this.joinDate = joinDate;
	}

	public String geteNo() {
		return eNo;
	}

	public void seteNo(String eNo) {
		this.eNo = eNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s, %s, %s",
				eNo, eName, title, salary, gender, department, joinDate);
	}
	public Object[] toArray(){
		return new Object[] {eNo, eName, title.gettCode(), salary, gender, department.getdName(), joinDate};
		
		}
	}

