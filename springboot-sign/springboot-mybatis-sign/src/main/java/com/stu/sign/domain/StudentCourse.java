package com.stu.sign.domain;

import java.sql.Timestamp;

public class StudentCourse {
	private int id;
	private String section;
	private String classNum;
	private String weekNum;
	private Timestamp courseEndTime;
	private Timestamp courseStartTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getWeekNum() {
		return weekNum;
	}

	public void setWeekNum(String weekNum) {
		this.weekNum = weekNum;
	}

	public Timestamp getCourseEndTime() {
		return courseEndTime;
	}

	public void setCourseEndTime(Timestamp courseEndTime) {
		this.courseEndTime = courseEndTime;
	}

	public Timestamp getCourseStartTime() {
		return courseStartTime;
	}

	public void setCourseStartTime(Timestamp courseStartTime) {
		this.courseStartTime = courseStartTime;
	}

}
