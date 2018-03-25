package com.stu.sign.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.stu.sign.domain.TeacherInfo;

public interface UserLoginDao {
	@Select("select * from teacher_info where TeacherNum = #{TeacherNum}  and LoginPasseord = #{LoginPasseord}")
	List<TeacherInfo> findListByUserId();


}
