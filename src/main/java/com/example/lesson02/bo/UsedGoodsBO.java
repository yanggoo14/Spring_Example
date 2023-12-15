package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean
public class UsedGoodsBO {
	
	@Autowired // Dependency Injection(DI): 의존성 주입 (Spring Bean을 가져온다)
	private UsedGoodsMapper usedGoodsMapper;
	// input:X  (컨트롤러에게 받아온다)        
	// output: (Repository한테 받은것들) List<UsedGoods> (컨트롤러에게 준다)
	public List<UsedGoods> getUsedGoodsList(){
		return usedGoodsMapper.selectUsedGoodsList(); 
	}
	
	
}
