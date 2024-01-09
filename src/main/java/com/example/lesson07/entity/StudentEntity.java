package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString //객체를 출력시 필드 값이 보여준다.
@AllArgsConstructor //파라미터가 모두 있는 생성자
@NoArgsConstructor //파라미터가 없는 생성자
@Builder(toBuilder = true) // Setter 대신에 사용  , tobuiler = true > 필드값 변경 허용
@Getter  // getter 가져오기
@Table(name = "new_student")  // 테이블명 지정해주기 (jakarta 없으면 javax 선택해주기)
@Entity // 이 객체는 Entity이다. (JPA - DB)  테이블처럼 이름을 설정해서 바꿔줄수 있다.
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber; // - (카멜케이스)에는 colum추가해줘야함
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp // createdAt이 null이어도 현재시간으로 저장
	@Column(name = "createdAt" , updatable = false) //업데이트시 변경되지 않도록 설정
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}
