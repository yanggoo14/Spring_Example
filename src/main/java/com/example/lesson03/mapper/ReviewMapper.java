package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	public Review selectReview(); 


	// input :Reivew        output: 성공한 행의 갯수(int)
		public int insertReview(Review review);
		
		public int insertReviewAsField(
				@Param("storeId") int storeId,
				@Param("menu") String menu, 
				@Param("userName") String userName ,
				@Param("point") Double point ,
				@Param("review") String review
				);
		
		public int updateReviewById(
				@Param("id")int id, 
				@Param("review") String review);

		// input: id      output= 성공한 행의 갯수
		public int deletdReviewById(int id);
}
