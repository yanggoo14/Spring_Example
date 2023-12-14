package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

 // jsp로 보내는 컨트롤러
@Controller  //@ResponseBody가 있으면 안된다!(@RestController도 있으면 안됨)
public class Lesson01Ex02Controller {
	//url http://localhost/lesson01/ex03
	@RequestMapping("/lesson01/ex02") //Request path주소
	public String ex02() {
		// return되는 String은 jsp의 경로이다(@ResponseBody가 없을때)
		// return "/Web-INF/jsp/lesson01/ex02.jsp"; (application에 주소지를 저장했으므로 그거 제외하고 주소 경로)
		return "/lesson01/ex02"; //Response view 경로
	}
	
}
