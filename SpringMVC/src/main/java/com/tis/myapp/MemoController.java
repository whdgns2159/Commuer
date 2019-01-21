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
	//@Autowired : MemoDAOŬ���� ������ �ִٸ� �����Ѵ�.

	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String memoInput() {
		//�α� ������ ���� �޼ҵ� ȣ�� debut/info/warn/error
		/*log.info("memoForm()����");*/
		System.out.println("memoForm()����");
		return "memo/input"; 
		//�����ּҴ� Ŭ������ �޼ҵ�� �и��ؼ� ���� ����������
		//���� �ּҴ� �������ּ��̱⶧���� �ѹ��� �� ������Ѵ�.
	}
	
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String memoInsert(Model model) {
		System.out.println("memoInsert() ����");
		model.addAttribute("message","�޸����׽�Ʈ");
		model.addAttribute("loc","memos");
		return "memo/message";
	}
	
	@RequestMapping("/memos")
	public String memoList(Model model) {
		System.out.println("memoList() ����");
		int cnt=memoDao.getTotalCount();
		System.out.println("cnt==="+cnt);
		model.addAttribute("totalCount",cnt);
		return "memo/list";
	}
	
}
