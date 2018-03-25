package com.stu.sign.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.stu.sign.domain.StudentSign;

@Mapper
public interface StudentSignDao {

	@Insert("INSERT INTO test.student_sign(StudentNum, StudentclassNum, WeekNum, Section, SignTime, SignFlag) "
			+ "VALUES (#{studentNum}, #{studentclassNum}, #{weekNum}, #{section}, #{signTime}, #{signFlag})")
	public int insertStudentSign(StudentSign studentSign);
	
//	@Select("select * from class_course a where exists(select 1 from student_info b "
//    		+ "where a.classNum = b.classNum and b.studentNum = #{studentNum}) and a.CourseEndTime > CURRENT_TIMESTAMP"
////    		+ " and a.CourseStartTime > CURRENT_TIMESTAMP - INTERVAL 15 MINUTE"
//    		)
//    @Results({
//            @Result(property = "studentNum", column = "StudentNum"),
//            @Result(property = "weekNum", column = "WeekNum")
//    })
//	List<StudentSign> findListByName(@Param("studentNum") String studentNum, @Param("weekNum") String weekNum);

}
