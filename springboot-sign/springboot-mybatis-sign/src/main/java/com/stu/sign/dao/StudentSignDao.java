package com.stu.sign.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.stu.sign.domain.StudentSign;

@Mapper
public interface StudentSignDao {

	/**
	 * 根据学生编号和周期查询该上的课程
	 * 
	 * @param StudentNum
	 *            学生编号
	 * @param WeekNum
	 *            星期
	 */
	// @Select("select * from class_course a where a.weekNum = #{weekNum} and
	// exists(select 1 from student_info b "
	// + "where a.classNum = b.classNum and b.studentNum = #{studentNum}) and
	// a.CourseEndTime > CURRENT_TIMESTAMP")
	// @Results({
	// @Result(property = "studentNum", column = "StudentNum"),
	// @Result(property = "weekNum", column = "WeekNum")
	// })
	// List<StudentCourse> findListByName(@Param("studentNum") String
	// studentNum, @Param("weekNum") String weekNum);

	@Insert("INSERT INTO test.student_sign(StudentNum, StudentclassNum, WeekNum, Section, SignTime, SignFlag) "
			+ "VALUES (#{studentNum}, #{studentclassNum}, #{weekNum}, #{section}, #{signTime}, #{signFlag})")
	public int insertStudentSign(StudentSign studentSign);

}
