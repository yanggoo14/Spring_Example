package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service // spring bean
public class UsedGoodsBO {
	
	// input:X  (컨트롤러에게 받아온다)        
	// output: (Repository한테 받은것들) List<UsedGoods> (컨트롤러에게 준다)
	public List<UsedGoods> getUsedGoodsList(){
		return ; 
	}
	
	
}
