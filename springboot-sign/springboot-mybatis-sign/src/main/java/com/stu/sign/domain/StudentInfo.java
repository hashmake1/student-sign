package com.stu.sign.domain;

import java.sql.Timestamp;

public class StudentInfo {

	private int studentId;
	private int studentNum;
	private String studentName;
	private int classNum;
	private String LoginPassword;
	private Timestamp CreateDate;
	private String Remarks;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public String getLoginPassword() {
		return LoginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		LoginPassword = loginPassword;
	}

	public Timestamp getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Timestamp createDate) {
		CreateDate = createDate;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
}
