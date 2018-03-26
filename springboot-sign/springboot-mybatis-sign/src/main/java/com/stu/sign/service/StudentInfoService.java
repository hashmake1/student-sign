package com.stu.sign.service;

import java.util.List;

import com.stu.sign.domain.StudentInfo;


public interface StudentInfoService {
	
	public List<StudentInfo> findAllStudentsByClassNum(String classNum);
}
