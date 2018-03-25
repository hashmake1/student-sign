package com.stu.sign.domain;

import java.sql.Timestamp;

public class StudentSign {
	private int signId;
	private int studentNum;
	// private String studentName;
	private String studentclassNum;
	private String weekNum;
	private String section;
	private Timestamp signTime;
	private int signFlag;

	public int getSignId() {
		return signId;
	}

	public void setSignId(int signId) {
		this.signId = signId;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	// public String getStudentName() {
	// return studentName;
	// }
	//
	// public void setStudentName(String studentName) {
	// this.studentName = studentName;
	// }

	public String getStudentclassNum() {
		return studentclassNum;
	}

	public void setStudentclassNum(String studentclassNum) {
		this.studentclassNum = studentclassNum;
	}

	public String getWeekNum() {
		return weekNum;
	}

	public void setWeekNum(String weekNum) {
		this.weekNum = weekNum;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public int getSignFlag() {
		return signFlag;
	}

	public void setSignFlag(int signFlag) {
		this.signFlag = signFlag;
	}

	public Timestamp getSignTime() {
		return signTime;
	}

	public void setSignTime(Timestamp signTime) {
		this.signTime = signTime;
	}
}
