package com.stu.sign.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.stu.sign.domain.StudentSign;

@Mapper
public interface StudentSignDao {

	@Insert("INSERT INTO test.student_sign(StudentNum, StudentclassNum, WeekNum, Section, SignTime, SignFlag) "
			+ "VALUES (#{studentNum}, #{studentclassNum}, #{weekNum}, #{section}, #{signTime}, #{signFlag})")
	public int insertStudentSign(StudentSign studentSign);

}
