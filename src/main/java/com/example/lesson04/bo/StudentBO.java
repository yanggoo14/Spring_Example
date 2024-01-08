package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	// JPA로 insert
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) // @UpdateTimestamp가 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);  
	}
	
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		
		StudentEntity student = studentRepository.findById(id).orElse(null); // entity가 만약 없으면 null로 넣어줌
		
		if(student != null) {
		student = student.toBuilder() // 기존 필드값들은 유지하고 일부 필드만 변경 - toBuilder
		.dreamJob(dreamJob)
		.build(); // ★★반드시 다시 저장한다!!
		
		//update
		student = studentRepository.save(student);
		}
		
		return student; // student에 들어가거나 or null
		
		
	}
	
	// Mybatis로 insert
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public void deleteStudentById(int id) {
		// select
		// delete 방법 1 
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//				if(student != null) {
//					studentRepository.delete(student);
//				}
		
		
		// 방법2 delete 방법 2
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
}
