package com.tis.myapp;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tis.common.CommonUtil;
import com.tis.domain.MemoVO;
import com.tis.service.MemoService;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/memo")
@Log4j
public class MemoController {
	
	
	//@Autowired : MemoServiceŬ���� ������ �ִٸ� �����Ѵ�.
	@Autowired
	private MemoService mService;
	
	@Autowired
	private CommonUtil util;
	
	
	
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String memoInput() {
		//�α� ������ ���� �޼ҵ� ȣ�� debut/info/warn/error
		log.info("memoForm()����");
		
		return "memo/input"; 
		//�����ּҴ� Ŭ������ �޼ҵ�� �и��ؼ� ���� ����������
		//���� �ּҴ� �������ּ��̱⶧���� �ѹ��� �� ������Ѵ�.
	}
	/*���� ���ε� ó���� ������ 
	 * [1] pom.xml�� commons-fileupload�� commons-io�� ����Ѵ�.
	 * [2] WEB-INF/spring/appServlet/servlet-context.xml��
	 * 		multipartResolver���� ���
	 * [����] ���� id�� �ݵ�� multipartResolver�� ����
	 * ------------------------------------------------------------------------------------------------
	 *  <beans:bean id="multipartResolver" 
	 	class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		 	<beans:property name="maxUploadSize" value="-1"/>
		 	<!-- value�� -1�� �ָ� ���ε� �뷮 ������ -->
		 	<beans:property name="defaultEncoding" value="UTF-8"/>
	 	</beans:bean>
	 * ------------------------------------------------------------------------------------------------
	 * */
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String memoInsert(Model m,@ModelAttribute("memo") MemoVO memo, 
			HttpServletRequest req) {
		String upDir=req.getServletContext().getRealPath("/images");
		log.info("upDir="+upDir);
		
		MultipartHttpServletRequest mr=(MultipartHttpServletRequest)req;
		
		//���ϸ� ���
		MultipartFile mf=mr.getFile("mfile");
		//memo�� setFilename�� ����
		//���� ���ε� ó��
		if(!mf.isEmpty()) {
			String fname=mf.getOriginalFilename();
			memo.setFilename(fname);
			try {
				mf.transferTo(new File(upDir, fname));
				log.info(fname+"���� ���ε� ó������");
			} catch (Exception e) {
				log.error("���� ���ε� ����: "+e.getMessage());
			}
		}
		
		//mService���� createMemo()ȣ��
		int n=mService.createMemo(memo);
		String str=(n>0)?"�۾��� ����":"�۾��� ����";
		String loc=(n>0)?"memos":"javascript:history.back()";
	
		return util.addMsgLoc(m, str, loc);
	}
	
	//����÷�α�� ���°�
	@RequestMapping(value="/input_old",method=RequestMethod.POST)
	public String memoInsert(@ModelAttribute("memo") MemoVO memo,Model model) {
		log.info("memoInsert() ����==memo: "+memo);
		int n=mService.createMemo(memo);
		String str=(n>0)?"�޸� ��� ����":"��� ����";
		String loc=(n>0)?"memos":"javascript:history.back()";
		
		
		return util.addMsgLoc(model, str, loc);
	}
	
	@RequestMapping("/memos")
	public String memoList(Model model, @RequestParam(defaultValue="1") int cpage) {
		log.info("memoList() ����");
		int cnt=mService.getTotalCount();
		int pageSize=9; //�� �������� ������ �� ��
		
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
			return util.addMsgLoc(model, "�߸� ���� ��� �Դϴ�.", "memos");
		}
		int n=mService.deleteMemo(idx);
		
		String msg=(n>0)?"���� ����":"���� ����";
		return util.addMsgLoc(model, msg, "memos");
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String memoEdit(@RequestParam(defaultValue="0") int idx, Model model) {
		log.info("idx=="+idx);
		if(idx==0) {
			return "redirect:memos";
		}
		MemoVO memo=mService.getMemo(idx);
		model.addAttribute("memo",memo);
		
		return "memo/edit";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String memoEditEnd(@ModelAttribute("memo") MemoVO memo, Model m) {
		log.info("�� ���� memo=="+memo);
		int n=this.mService.updateMemo(memo);
		String str=(n>0)?"�� ���� ����":"�� ���� ����";
		String loc=(n>0)?"memos":"javascript:history.back()";
				
		return util.addMsgLoc(m, str, loc);
	}
}
