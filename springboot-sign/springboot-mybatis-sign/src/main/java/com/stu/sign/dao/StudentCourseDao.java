package com.stu.sign.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.stu.sign.domain.StudentCourse;

@Mapper
public interface StudentCourseDao {

    /**
     * 根据学生编号和时间查询该上的课程,上课前15分钟才能签到
     * @param StudentNum 学生编号
     * @param WeekNum 星期
     */
    @Select("select * from class_course a where exists(select 1 from student_info b "
    		+ "where a.classNum = b.classNum and b.studentNum = #{studentNum}) and a.CourseEndTime > CURRENT_TIMESTAMP"
//    		+ " and a.CourseStartTime > CURRENT_TIMESTAMP - INTERVAL 15 MINUTE"
    		)
    @Results({
            @Result(property = "studentNum", column = "StudentNum"),
            @Result(property = "weekNum", column = "WeekNum")
    })
	List<StudentCourse> findListByName(@Param("studentNum") String studentNum, @Param("weekNum") String weekNum);
}
