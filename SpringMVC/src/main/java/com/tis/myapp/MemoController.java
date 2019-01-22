package com.tis.myapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tis.common.CommonUtil;
import com.tis.domain.MemoVO;
import com.tis.service.MemoService;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/memo")
@Log4j
public class MemoController {
	
	
	//@Autowired : MemoService클래스 유형이 있다면 주입한다.
	@Autowired
	private MemoService mService;
	
	@Autowired
	private CommonUtil util;
	
	
	
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String memoInput() {
		//로그 레벨에 따라 메소드 호출 debut/info/warn/error
		log.info("memoForm()들어옴");
		
		return "memo/input"; 
		//맵핑주소는 클래스와 메소드로 분리해서 접근 가능하지만
		//접속 주소는 물리적주소이기때문에 한번에 다 써줘야한다.
	}
	
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String memoInsert(@ModelAttribute("memo") MemoVO memo,Model model) {
		log.info("memoInsert() 들어옴==memo: "+memo);
		int n=mService.createMemo(memo);
		String str=(n>0)?"메모 등록 성공":"등록 실패";
		String loc=(n>0)?"memos":"javascript:history.back()";
		
		
		return util.addMsgLoc(model, str, loc);
	}
	
	@RequestMapping("/memos")
	public String memoList(Model model, @RequestParam(defaultValue="1") int cpage) {
		log.info("memoList() 들어옴");
		int cnt=mService.getTotalCount();
		int pageSize=9; //한 페이지당 보여줄 글 수
		
		int pageCount=(cnt-1)/pageSize+1;
		if(cpage<0) {
			cpage=1;
		}
		if(cpage>=pageCount) {
			cpage=pageCount;
		}
		Map<String, Integer> map=new HashMap<>();
		
		int end=cpage*pageSize;
		int start=end-(pageSize-1);
		map.put("start", start);
		map.put("end", end);
		List<MemoVO> arr=mService.listMemo(map);
		
		
		model.addAttribute("totalCount",cnt);
		model.addAttribute("memoList",arr);
		model.addAttribute("pageCount",pageCount);
		model.addAttribute("cpage",cpage);
		return "memo/list";
	}
	
	@RequestMapping("/delete")
	public String memoRemove(@RequestParam(defaultValue="0") int idx, Model model) {
		log.info("idx=="+idx);
		if(idx==0) {
			return util.addMsgLoc(model, "잘못 들어온 경로 입니다.", "memos");
		}
		int n=mService.deleteMemo(idx);
		
		String msg=(n>0)?"삭제 성공":"삭제 실패";
		return util.addMsgLoc(model, msg, "memos");
	}
	
	@RequestMapping("/edit")
	public String memoEdit(@RequestParam(defaultValue="0") int idx, Model model) {
		log.info("idx=="+idx);
		if(idx==0) {
			return "redirect:memos";
		}
		
		MemoVO memo=mService.getMemo(idx);
		model.addAttribute("memo",memo);
		
		return "memo/edit";
	}
	/*
	@RequestMapping("/edit")
	public String memoUpdate(Model model) {
		log.info("메모 업데이트");
		
	}*/
}
