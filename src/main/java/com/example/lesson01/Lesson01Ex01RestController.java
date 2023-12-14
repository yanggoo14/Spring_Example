package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController  // @Controller + @ResponseBody
public class Lesson01Ex01RestController {

	// url : http://localhost/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "@RestController를 사용해서 String을 리턴해본다.";
	}
	
	// url : http://localhost/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String,String> ex01_4(){
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		return map;  //JSON
	
	// url : http://localhost/lesson01/ex01/5
	}
	@RequestMapping("/5")
	public Data ex_5() {
		Data data = new Data();
		data.setId(123);
		data.setName("신보람");
		
		return data;
	}
	
	// 상태코드도 가져오기
	// url : http://localhost/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6(){
		Data data = new Data();
		data.setId(11);
		data.setName("바다");
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
