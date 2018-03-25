package com.stu.sign.controller.sign;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.ListUtils;

import com.stu.sign.domain.StudentCourse;
import com.stu.sign.domain.StudentSign;
import com.stu.sign.service.ClassCourseService;
import com.stu.sign.service.StudentSignService;

@RestController
public class StudentSignController {
	@Autowired
	private ClassCourseService classCourseService;
	
	@Autowired
	private StudentSignService studentSignService;

//	@RequestMapping(value = "/getStudentCourse", method = RequestMethod.GET)
//	public List<StudentCourse> selectStuCourse(String studentNum, String weekNum) {
//		return classCourseService.findStudentCourseList(studentNum, weekNum);
//	}
	
	@PostMapping("/studentSign")
	public @ResponseBody Map<String, Object> studentSign(String studentNum, String weekNum, HttpSession session) {
		List<StudentCourse> studentCourseList = classCourseService.findStudentCourseList(studentNum, weekNum);
		Map<String, Object> map = new HashMap<String, Object>();
		if(ListUtils.isEmpty(studentCourseList)){
			map.put("message", "当前无课程考勤");
		}else{
			StudentSign studentSign = new StudentSign();
			studentSign.setStudentclassNum(studentCourseList.get(0).getClassNum());
			studentSign.setStudentNum(Integer.valueOf(studentNum));
			studentSign.setWeekNum(weekNum);
			studentSign.setSection(studentCourseList.get(0).getSection());
			studentSign.setSignTime(new Timestamp(System.currentTimeMillis()));
			studentSign.setSignFlag(1);
			studentSignService.insertStudentSign(studentSign);
			map.put("message", "考勤成功");
		}
		return map;
	}
}
