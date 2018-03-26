package com.stu.sign.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stu.sign.dao.TeacherInfoDao;
import com.stu.sign.domain.TeacherInfo;
import com.stu.sign.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private TeacherInfoDao teacherInfoDao;

	@Override
	public boolean checkAccountAndPwd(String account, String password) {
		List<TeacherInfo> teacherInfoList = teacherInfoDao.findListByNumPwd(account, password);
		if (teacherInfoList != null && teacherInfoList.size() > 0) {
			return true;
		}
		return false;
	}
}