package com.stu.sign.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.stu.sign.domain.ClassCourse;
import com.stu.sign.domain.StudentCourse;

@Mapper
public interface StudentCourseDao {

	/**
	 * 根据学生编号和时间查询该上的课程,上课前15分钟和下课前才能签到
	 */
	@Select("select * from class_course a where exists(select 1 from student_info b "
			+ "where a.classNum = b.classNum and b.studentNum = #{studentNum}) and CURRENT_TIMESTAMP < a.CourseEndTime"
	// + " and a.CourseStartTime > CURRENT_TIMESTAMP - INTERVAL 15 MINUTE"
	)
	@Results({ @Result(property = "studentNum", column = "StudentNum"), @Result(property = "weekNum", column = "WeekNum") })
	List<StudentCourse> findStuCourseListByName(@Param("studentNum") String studentNum);

	/**
	 * 根据教师工号查询当前时间(上课前15分钟,下课前15分钟)要上的课程
	 */
	@Select("select * from class_course a where a.teacherNum = 1 and CURRENT_TIMESTAMP < a.CourseEndTime + INTERVAL 15 MINUTE and CURRENT_TIMESTAMP > a.CourseStartTime - INTERVAL 15 MINUTE")
	@Results({ @Result(property = "teacherNum", column = "TeacherNum"), })
	List<ClassCourse> findTeacherCourseListByName(@Param("teacherNum") String teacherNum);
}
