package com.stu.sign.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.stu.sign.domain.StudentSign;

@Mapper
public interface StudentSignDao {

	/**
	 * 插入考勤表
	 * 
	 * @param studentSign
	 * @return
	 */
	@Insert("INSERT INTO student_sign(classCourseId, StudentNum, StudentclassNum, SignTime, SignFlag) "
			+ "VALUES (#{classCourseId}, #{studentNum}, #{studentclassNum}, #{signTime}, #{signFlag})")
	public int insertStudentSign(StudentSign studentSign);

	/**
	 * 根据班级课程编号查询签到表
	 */
	@Select("select * from student_sign a where a.classCourseId = #{classCourseId}")
	List<StudentSign> findListByName(@Param("classCourseId") int classCourseId);

	/**
	 * 根据班级课程编号和学号查询签到表
	 */
	@Select("select * from student_sign a where a.classCourseId = #{classCourseId} and a.studentNum = #{studentNum}")
	public List<StudentSign> findStudentSignList(@Param("classCourseId") int classCourseId, @Param("studentNum") int studentNum);

}
