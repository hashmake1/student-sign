package com.stu.sign.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stu.sign.dao.StudentSignDao;
import com.stu.sign.domain.StudentSign;
import com.stu.sign.service.StudentSignService;

/**
 * 城市业务逻辑实现类
 */
@Service
public class StudentSignServiceImpl implements StudentSignService {

    @Autowired
    private StudentSignDao studentSignDao;

	@Override
	public int insertStudentSign(StudentSign studentSign){
		return studentSignDao.insertStudentSign(studentSign);
	}

	@Override
	public List<StudentSign> findStudentSignList(int classCourseId) {
		return studentSignDao.findListByName(classCourseId);
	}
}
