package com.stu.sign.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stu.sign.dao.StudentInfoDao;
import com.stu.sign.domain.StudentInfo;
import com.stu.sign.service.StudentInfoService;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

	@Autowired
	private StudentInfoDao studentInfoDao;

//	@Override
//	public boolean checkAccountAndPwd(String account, String password) {
//		List<TeacherInfo> teacherInfoList = teacherInfoDao.findListByNumPwd(account, password);
//		if (teacherInfoList != null && teacherInfoList.size() > 0) {
//			return true;
//		}
//		return false;
//	}

	@Override
	public List<StudentInfo> findAllStudentsByClassNum(String classNum) {
		List<StudentInfo> studentInfoList = studentInfoDao.findListByName(classNum);
		return studentInfoList;
	}
}