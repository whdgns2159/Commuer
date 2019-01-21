package com.tis.myapp;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tis.persistence.MemoDAO;


@Controller
@RequestMapping("/memo")
public class MemoController {
	
	@Autowired
	private MemoDAO memoDao;
	//@Autowired : MemoDAO클래스 유형이 있다면 주입한다.

	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String memoInput() {
		//로그 레벨에 따라 메소드 호출 debut/info/warn/error
		/*log.info("memoForm()들어옴");*/
		System.out.println("memoForm()들어옴");
		return "memo/input"; 
		//맵핑주소는 클래스와 메소드로 분리해서 접근 가능하지만
		//접속 주소는 물리적주소이기때문에 한번에 다 써줘야한다.
	}
	
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String memoInsert(Model model) {
		System.out.println("memoInsert() 들어옴");
		model.addAttribute("message","메모등록테스트");
		model.addAttribute("loc","memos");
		return "memo/message";
	}
	
	@RequestMapping("/memos")
	public String memoList(Model model) {
		System.out.println("memoList() 들어옴");
		int cnt=memoDao.getTotalCount();
		System.out.println("cnt==="+cnt);
		model.addAttribute("totalCount",cnt);
		return "memo/list";
	}
	
}
