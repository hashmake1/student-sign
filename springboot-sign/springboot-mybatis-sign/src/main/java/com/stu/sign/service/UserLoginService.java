package com.stu.sign.service;

import java.util.List;

import com.stu.sign.domain.TeacherInfo;

public interface UserLoginService {
	public List<TeacherInfo> findListByUserId();
	
	public boolean checkAccountAndPwd(String account,String password);
}
