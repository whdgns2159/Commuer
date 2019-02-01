package com.tis.myspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tis.common.CommonUtil;
import com.user.domain.UserVO;
import com.user.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private CommonUtil util;
	
	@GetMapping("/join")
	public String joinForm() {
		return "member/join";
	}
	
	@PostMapping("/join")
	public String joinEnd(Model m,
			@ModelAttribute("user") UserVO user) {
		int n=uService.createUser(user);
		log.info("ȸ�������� �ο���= "+n);
		String str=(n>0)?"ȸ������ ����":"���� ����";
		String loc="index";
		
		return util.addMsgLoc(m, str, loc);
	}
}
