package com.stu.sign.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stu.sign.dao.UserLoginDao;
import com.stu.sign.domain.TeacherInfo;
import com.stu.sign.service.UserLoginService;



public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginDao userLoginDao;

	@Override
	public List<TeacherInfo> findListByUserId() {
		return userLoginDao.findListByUserId();
	}
	@Override
	public boolean checkAccountAndPwd(String account,String password){
		
		
		return false;
		
	}
}