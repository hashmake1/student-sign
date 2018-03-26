package com.stu.sign.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stu.sign.dao.StudentCourseDao;
import com.stu.sign.domain.ClassCourse;
import com.stu.sign.domain.StudentCourse;
import com.stu.sign.service.ClassCourseService;

/**
 * 城市业务逻辑实现类
 */
@Service
public class ClassCourseServiceImpl implements ClassCourseService {

    @Autowired
    private StudentCourseDao classCourseDao;

	@Override
	public List<StudentCourse> findStudentCourseList(String studentNum) {
		return classCourseDao.findStuCourseListByName(studentNum);
	}

	@Override
	public List<ClassCourse> findTeacherCourseList(String teacherNum) {
		return classCourseDao.findTeacherCourseListByName(teacherNum);
	}
}
