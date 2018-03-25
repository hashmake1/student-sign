package com.stu.sign.domain;

import java.sql.Timestamp;

public class ClassCourse {
	private int classCourseId;
	private int classNum;
	private int courseNum;
	private int teacherNum;
	private Timestamp courseStartTime;
	private Timestamp courseEndTime;
	private Timestamp createDate;

	public int getClassCourseId() {
		return classCourseId;
	}

	public void setClassCourseId(int classCourseId) {
		this.classCourseId = classCourseId;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}

	public int getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(int teacherNum) {
		this.teacherNum = teacherNum;
	}

	public Timestamp getCourseStartTime() {
		return courseStartTime;
	}

	public void setCourseStartTime(Timestamp courseStartTime) {
		this.courseStartTime = courseStartTime;
	}

	public Timestamp getCourseEndTime() {
		return courseEndTime;
	}

	public void setCourseEndTime(Timestamp courseEndTime) {
		this.courseEndTime = courseEndTime;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
