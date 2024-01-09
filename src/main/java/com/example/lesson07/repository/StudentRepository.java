package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

//@Transactional
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
//	@PersistenceContext
//	private EntityManager em;
//	
//	public StudentEntity save(StudentEntity studentEntity) {
//		em.persist(studentEntity);
//		return studentEntity;
//	}
	
	// JPA , Spring Data JPA  (다름)
	
	//기본 제공 메소드
	//save(entity) 1, insert (id가 null)  2.update (id가 있음)
	// 앤티티 findById(id)  => 해당 id 앤티티 하나 나옴
	// void delete(엔티티객체)
	// List<엔티티객체> findAll();
	
	// ex02/1 -> JPQL
	//1
	public List<StudentEntity> findAllByOrderByIdDesc();
	//2
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	//3
	public List<StudentEntity> findByName(String name);
	//4
	public List<StudentEntity> findByNameIn(List<String> names);
	//5
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	//6
	public List<StudentEntity> findByEmailContaining(String email);
	//7
	public List<StudentEntity> findByNameStartingWith(String name);
	//8
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	// ex02 / 2  -  JPQL(Entity에 조회)
	// @Query(value = "select st from StudentEntity st where st.dreamJob =:dreamJob") //JPQL(엔티티 조회)
	@Query(value = "select * from new_student where dreamJob =:dreamJob" , nativeQuery = true)  // nativeQuery SQL문 조회
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
}
