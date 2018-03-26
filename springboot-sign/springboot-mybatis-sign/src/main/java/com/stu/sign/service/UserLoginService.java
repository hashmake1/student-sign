package com.stu.sign.service;

public interface UserLoginService {
	// public List<TeacherInfo> findListByUserId();

	public boolean checkAccountAndPwd(String account, String password, String loginType);
}
