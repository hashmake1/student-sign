package com.stu.sign.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.stu.sign.domain.StudentSign;

@Mapper
public interface StudentSignDao {

	@Insert("INSERT INTO student_sign(StudentNum, StudentclassNum, WeekNum, Section, SignTime, SignFlag) "
			+ "VALUES (#{studentNum}, #{studentclassNum}, #{weekNum}, #{section}, #{signTime}, #{signFlag})")
	public int insertStudentSign(StudentSign studentSign);

	@Select("select * from student_sign a where a.classCourseId = #{classCourseId}")
	List<StudentSign> findListByName(@Param("classCourseId") int classCourseId);

}
