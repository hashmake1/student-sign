package com.stu.sign.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.stu.sign.domain.StudentCourse;

@Mapper // 标志为 Mybatis 的 Mapper
public interface StudentCourseDao {

    /**
     * 根据学生编号和周期查询该上的课程
     * @param StudentNum 学生编号
     * @param WeekNum 星期
     */
    @Select("select * from class_course a where a.weekNum = #{weekNum} and exists(select 1 from student_info b where a.classname = b.classname and b.studentNum = #{studentNum})")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "studentNum", column = "StudentNum"),
            @Result(property = "weekNum", column = "WeekNum")
    })
	List<StudentCourse> findListByName(@Param("studentNum") String studentNum, @Param("weekNum") String weekNum);
}
