package com.tis.myspring;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tis.common.CommonUtil;
import com.tis.domain.BoardVO;
import com.tis.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	
	@Inject
	private CommonUtil util;
	
	@Inject
	private BoardService bService;

	@GetMapping("/input")
	public String boardForm() {
		return "board/boardWrite";
			//WEB-INF/views/board/boardWrite.jsp
	}
	/*<!-- MultipartResolver ��� -->
	<beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<beans:property name="defaultEncoding" value="UTF-8"></beans:property>
		<beans:property name="maxUploadSize" value="-1"></beans:property>
	</beans:bean>
	 * */
	@PostMapping("/input")
	public String boardInsert(Model m,HttpServletRequest req,
			@RequestParam("mfilename") MultipartFile mfilename, 
			@ModelAttribute("board") BoardVO board) {
		log.info("board="+board);
		//servlet-context.xml�� multipartResolver���� ��ϵǾ� ����		
		//1. ���ε� ���丮(Upload)�� ������ ���
		String upDir=req.getServletContext().getRealPath("/Upload");
		log.info("upDir="+upDir);
		
		File dir=new File(upDir);
		if(!dir.exists()) {
			dir.mkdirs();//���丮 ����
		}
		
		
		//2. ���� ÷�����ϸ�,����ũ�� �˾Ƴ���
		String originfile=mfilename.getOriginalFilename();
		long fsize=mfilename.getSize();
		//������ ���ϸ��� ��� ����� �����ϱ� ����
		UUID uuid=UUID.randomUUID();
		
		String fname=uuid.toString()+"_"+originfile;
		log.info("fname="+fname);
		
		board.setOriginFilename(originfile);//�������ϸ�
		board.setFilename(fname);//������ ���ϸ�
		board.setFilesize(fsize);
		
		//3. ���ε� ó��=> transferTo()
		try {
			mfilename.transferTo(new File(upDir,fname));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//4. BoardService��ü�� ���� �۾��� ó��
		
		int n=0;
		for(int i=0;i<30;i++) {
		n=bService.insertBoard(board);
		}
		
		String str=(n>0)?"�۾��� ����":"�۾��� ����";
		String loc=(n>0)?"list":"javascript:history.back()";
		
		return util.addMsgLoc(m, str, loc);
	}//----------------------------
	@RequestMapping("/list")
	public String boardList(Model m,
			@RequestParam(defaultValue="1") int cpage,
			@RequestParam(defaultValue="5") int pageSize) {
		
		//1.�ѰԽñ� �� ��������
		int totalCount=bService.getTotalCount();
		
		//2. pageCount���ϱ�
		//int pageSize=5;
		int pageCount=(totalCount-1)/pageSize+1;
		if(cpage<=0) {
			cpage=1;
		}
		if(cpage>pageCount) {
			cpage=pageCount;
		}
		Map<String,Integer> map=new HashMap<>();
		int end=cpage*pageSize;
		int start=end-pageSize;
		map.put("start", start);
		map.put("end", end);
		
		List<BoardVO> bList=bService.selectBoardAll(map);
		
		m.addAttribute("boardList",bList);
		m.addAttribute("totalCount",totalCount);
		m.addAttribute("pageCount",pageCount);
		m.addAttribute("pageSize",pageSize);
		m.addAttribute("cpage",cpage);
		return "board/boardList";		
	}
	
	/**�Խñ� ���� ����*/
	@GetMapping("/view")
	public String boardView(Model m, @RequestParam(defaultValue="0") int idx) {
		log.info("idx= "+idx);
		if(idx==0) {
			return "redirect:list";
		}
		return "board/boardView";
	}
}







