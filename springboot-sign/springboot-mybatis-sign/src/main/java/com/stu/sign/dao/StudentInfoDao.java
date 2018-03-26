package com.stu.sign.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.stu.sign.domain.StudentInfo;

@Mapper
public interface StudentInfoDao {
	@Select("select * from student_info where classnum = #{classNum}")
	List<StudentInfo> findListByName(@Param("classNum") String classNum);
}
