package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// c: create
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "김바다";
		String phoneNumber = "010-1111-2222";
		String email = "bada@naver.com";
		String dreamJob = "개발자";
		
		// 방금 insert된 pk id도 바로 얻어 낼 수 있다.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// u: Update
	@GetMapping("/2")
	public StudentEntity update() {
		//id가 4번인 dreamjob변경
		// 4번 -> 디자이너
		return studentBO.updateStudentDreamJobById(4, "디자이너");
	}
	
	// d: Delete
	@GetMapping("/3")
		public String delete() {
		// id:3 삭제
		studentBO.deleteStudentById(3);
		return "삭제 완료";
	}
}
