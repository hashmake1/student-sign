package com.stu.sign.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stu.sign.dao.StudentInfoDao;
import com.stu.sign.dao.TeacherInfoDao;
import com.stu.sign.domain.StudentInfo;
import com.stu.sign.domain.TeacherInfo;
import com.stu.sign.service.UserLoginService;
import com.stu.sign.utils.EqualUtils;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private TeacherInfoDao teacherInfoDao;

	@Autowired
	private StudentInfoDao studentInfoDao;

	@Override
	public boolean checkAccountAndPwd(String account, String password, String loginType) {
		if (EqualUtils.equals(loginType, 1)) {
			List<TeacherInfo> teacherInfoList = teacherInfoDao.findListByNumPwd(account, password);
			if (teacherInfoList != null && teacherInfoList.size() > 0) {
				return true;
			}
		} else {
			List<StudentInfo> studentinfoList = studentInfoDao.findListByNumPwd(account, password);
			if (studentinfoList != null && studentinfoList.size() > 0) {
				return true;
			}
		}
		return false;
	}
}