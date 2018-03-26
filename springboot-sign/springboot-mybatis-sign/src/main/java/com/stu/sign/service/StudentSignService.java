package com.stu.sign.service;

import java.util.List;

import com.stu.sign.domain.StudentSign;

public interface StudentSignService {
	public int insertStudentSign(StudentSign studentSign);
	
	public List<StudentSign> findStudentSignList(int classCourseId);
}
