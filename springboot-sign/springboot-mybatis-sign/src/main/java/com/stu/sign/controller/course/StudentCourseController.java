package com.stu.sign.controller.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stu.sign.domain.StudentCourse;
import com.stu.sign.service.ClassCourseService;

@RestController
public class StudentCourseController {
	@Autowired
	private ClassCourseService classCourseService;

	@RequestMapping(value = "/getStudentCourse", method = RequestMethod.GET)
	public List<StudentCourse> selectStuCourse(String studentNum, String weekNum) {
		return classCourseService.findStudentCourseList(studentNum, weekNum);
	}
	
	// @Autowired
	// private DemoMapper demoMapper;//实际开发，不建议这么写，这里只是为了测试方便。

	// @GetMapping("/selectStCour")
	// public List<ClassCourse> selectStCour(String StudentNum,String WeekNum){
	// return demoService.selectStCour(StudentNum,WeekNum);
	// }
	// @GetMapping("/show")
	// public String show() {
	// return demoService.show();
	// }
	//
	// @GetMapping("/time")
	// public int getDayForWeek(String pTime) throws Exception {
	// return demoService.getDayForWeek(pTime);
	// }

}
