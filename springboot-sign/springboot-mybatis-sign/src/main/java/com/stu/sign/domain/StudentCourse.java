package com.stu.sign.domain;

import java.sql.Timestamp;

public class StudentCourse {
	private int classCourseId;
	private String classNum;
	private String weekNum;
	private Timestamp courseEndTime;
	private Timestamp courseStartTime;

	public int getClassCourseId() {
		return classCourseId;
	}

	public void setClassCourseId(int classCourseId) {
		this.classCourseId = classCourseId;
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