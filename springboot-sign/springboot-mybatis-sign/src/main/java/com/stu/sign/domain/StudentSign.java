package com.stu.sign.domain;

import java.sql.Timestamp;

public class StudentSign {
	private int signId;
	private int studentNum;
	private int classCourseId;
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

	public int getClassCourseId() {
		return classCourseId;
	}

	public void setClassCourseId(int classCourseId) {
		this.classCourseId = classCourseId;
	}

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
