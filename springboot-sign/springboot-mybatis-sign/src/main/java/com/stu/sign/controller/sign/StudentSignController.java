package com.stu.sign.controller.sign;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.ListUtils;

import com.stu.sign.domain.ClassCourse;
import com.stu.sign.domain.StudentCourse;
import com.stu.sign.domain.StudentInfo;
import com.stu.sign.domain.StudentSign;
import com.stu.sign.service.ClassCourseService;
import com.stu.sign.service.StudentInfoService;
import com.stu.sign.service.StudentSignService;
import com.stu.sign.utils.EqualUtils;

@RestController
public class StudentSignController {
	@Autowired
	private ClassCourseService classCourseService;

	@Autowired
	private StudentInfoService studentInfoService;

	@Autowired
	private StudentSignService studentSignService;

	/**
	 * 学生本节课签到功能
	 */
	@PostMapping("/studentSign")
	public @ResponseBody Map<String, Object> studentSign(String studentNum, String weekNum, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(session.getAttribute("ACCOUNT_ID"))) {
			studentNum = (String) session.getAttribute("ACCOUNT_ID");
		}
		if(EqualUtils.equals(session.getAttribute("LOGIN_TYPE"), 1)){
			map.put("message", "老师无需签到考勤");
			return map;
		}
		List<StudentCourse> studentCourseList = classCourseService.findStudentCourseList(studentNum);
		if (ListUtils.isEmpty(studentCourseList)) {
			map.put("message", "当前无课程考勤");
		} else {
			int classCourseId = studentCourseList.get(0).getClassCourseId();
			List<StudentSign> studentSignList = studentSignService.findStudentSignList(classCourseId, Integer.valueOf(studentNum));
			if(!studentSignList.isEmpty()){
				map.put("message", "该学号本节课已考勤成功,不能重复签到.");
				return map;
			}
			String accountId = (String) session.getAttribute("ACCOUNT_ID");
			StudentSign studentSign = new StudentSign();
			studentSign.setStudentclassNum(studentCourseList.get(0).getClassNum());
			studentSign.setClassCourseId(studentCourseList.get(0).getClassCourseId());
			studentSign.setStudentNum(Integer.valueOf(accountId));
			studentSign.setWeekNum("无");
			studentSign.setSignTime(new Timestamp(System.currentTimeMillis()));
			studentSign.setSignFlag(1);
			studentSignService.insertStudentSign(studentSign);
			map.put("message", "考勤成功");
		}
		return map;
	}

	/**
	 * 学生签到功能
	 */
	@PostMapping("/findAbsentStudents")
	public @ResponseBody Map<String, Object> findAbsentStudents(@RequestParam(value = "teacherNum", required = false) String teacherNum, HttpSession session) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		if (StringUtils.isEmpty(teacherNum)) {
			teacherNum = (String) session.getAttribute("ACCOUNT_ID");
		}
		List<ClassCourse> studentCourseList = classCourseService.findTeacherCourseList(teacherNum);
		if (EqualUtils.notEquals(session.getAttribute("LOGIN_TYPE"), 1)) {
			retMap.put("message", "只有教师有权查看");
			return retMap;
		}
		if (studentCourseList != null && studentCourseList.size() > 1) {
			retMap.put("message", "排课出错, 同一时间安排了多节课");
			return retMap;
		}
		if (ListUtils.isEmpty(studentCourseList)) {
			retMap.put("message", "当前无课程,不需要考勤");
			return retMap;
		}
		List<StudentInfo> absentStudentList = new ArrayList<StudentInfo>();
		String classNum = String.valueOf(studentCourseList.get(0).getClassNum());
		List<StudentInfo> studentInfoList = studentInfoService.findAllStudentsByClassNum(classNum);
		int classCourseId = studentCourseList.get(0).getClassCourseId();
		List<StudentSign> studentSignList = studentSignService.findStudentSignList(classCourseId);
		for (StudentInfo studentInfo : studentInfoList) {
			boolean isSign = false;
			for (StudentSign studentSign : studentSignList) {
				if (EqualUtils.equals(studentInfo.getStudentNum(), studentSign.getStudentNum())) {
					isSign = true;
				}
			}
			if (!isSign) {
				absentStudentList.add(studentInfo);
			}
		}
		retMap.put("success", true);
		retMap.put("message", absentStudentList);
		return retMap;
	}
}
