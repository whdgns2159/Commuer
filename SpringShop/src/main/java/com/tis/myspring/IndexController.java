package com.tis.myspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/top")
	public void showTop() {
		//������� ��ȯ���� ���� ���
		//��û ���� /top �տ� ���ξ ���̰� �ڿ� ���̻縦 �ٿ� �̵��Ѵ�.
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
