package com.stu.sign.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.stu.sign.domain.TeacherInfo;

@Mapper
public interface TeacherInfoDao {
	@Select("select * from teacher_info where TeacherNum = #{teacherNum}  and LoginPassword = #{loginPassword}")
	List<TeacherInfo> findListByNumPwd(@Param("teacherNum") String teacherNum, @Param("loginPassword") String loginPassword);
}
