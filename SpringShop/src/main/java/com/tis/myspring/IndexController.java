package com.tis.myspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/top")
	public void showTop() {
		//뷰네임을 반환하지 않을 경우
		//요청 매핑 /top 앞에 접두어를 붙이고 뒤에 접미사를 붙여 이동한다.
		//WEB-INF/views/top.jsp
	}
	@RequestMapping("/foot")
	public void showFoot() {
		
	}
	
	@RequestMapping("/carousel")
	public String showCarousel() {
		return "shop/carousel";
	}
	
	@RequestMapping("/index")
	public void showIndex() {
		
	}
}
