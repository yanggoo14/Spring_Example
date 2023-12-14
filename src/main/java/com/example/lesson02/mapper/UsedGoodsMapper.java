package com.example.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.domain.UsedGoods;

@Repository
public interface UsedGoodsMapper {

	//	input: X (BO로 부터 받아오는게 X)
	// 	output: List<UsedGoods> (Service한테 주는것)
	public List<UsedGoods> selectUsedGoodsList();
}
