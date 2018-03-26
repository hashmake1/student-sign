package com.stu.sign.service;

import java.util.List;

import com.stu.sign.domain.ClassCourse;
import com.stu.sign.domain.StudentCourse;

public interface ClassCourseService {
	public List<StudentCourse> findStudentCourseList(String studentNum);
	
	public List<ClassCourse> findTeacherCourseList(String teacherNum);
}
