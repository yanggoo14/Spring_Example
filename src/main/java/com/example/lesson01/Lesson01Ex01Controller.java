package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01")
@Controller // Spring Bean으로 등록
public class Lesson01Ex01Controller {
	
	//String 브라우저에 출력
	// url: http://localhost/lesson01/ex01/1
	@RequestMapping("/1") //들어오는 주소 매핑 
	@ResponseBody //리턴하는 값을 이곳에 담아서 보낸다.
	public String ex01_1() {
		return "<h2>예제1번</h2>문자열을 Response Body로 보내는 예제";
	}
	
	// MAP 출력 => JSON 출력
	// url: http://localhost/lesson01/ex01/2
	
	
	@ResponseBody
	@RequestMapping("/2")
	public Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("사과", 20);
		map.put("포도", 20);
		map.put("멜론", 32);
		map.put("귤", 55);
		
		// "키"=값 = map
		// "키":값 = JSON
		
		//map을 리턴하면 json으로 나타난다.
		//web starter에 jackson이라는 라이브러리가 포함되어있기 때문
		return map;
	}

}
