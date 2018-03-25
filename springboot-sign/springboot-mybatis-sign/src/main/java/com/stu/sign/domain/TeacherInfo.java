package com.stu.sign.domain;

import java.sql.Timestamp;

public class TeacherInfo {

	private int TeacherId;
	private int TeacherNum;
	private String TeacherName;
	private String LoginPasseord;
	private Timestamp CreateDate;
	private String Remarks;

	public int getTeacherId() {
		return TeacherId;
	}

	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}

	public int getTeacherNum() {
		return TeacherNum;
	}

	public void setTeacherNum(int teacherNum) {
		TeacherNum = teacherNum;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	public String getLoginPasseord() {
		return LoginPasseord;
	}

	public void setLoginPasseord(String loginPasseord) {
		LoginPasseord = loginPasseord;
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
