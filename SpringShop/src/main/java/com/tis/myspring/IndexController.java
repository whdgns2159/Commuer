package com.tis.myspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/top")
	public void showTop() {
		//������� ��ȯ���� ���� ���
		//��û ���� /top �տ� ���ξ ���̰� �ڿ� ���̻縦 �ٿ� �̵��Ѵ�.
		//WEB-INF/views/top.jsp
	}
	@GetMapping("/foot")
	public void showFoot() {
		
	}
}
