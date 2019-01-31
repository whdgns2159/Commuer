package com.tis.myspring;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tis.common.CommonUtil;
import com.tis.domain.BoardVO;
import com.tis.domain.PagingVO;
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
		// WEB-INF/views/board/boardWrite.jsp
	}

	/*
	 * <!-- MultipartResolver 등록 --> <beans:bean id="multipartResolver"
	 * class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	 * <beans:property name="defaultEncoding" value="UTF-8"></beans:property>
	 * <beans:property name="maxUploadSize" value="-1"></beans:property>
	 * </beans:bean>
	 */

	@PostMapping("/input")
	public String boardInsert(Model m, 
			HttpServletRequest req, 
			@RequestParam("mfilename") MultipartFile mfilename,
			@ModelAttribute("board") BoardVO board,
			@RequestParam(defaultValue="") String old_file
			) {
		log.info("mode= "+board.getMode());
		log.info("board=" + board);
		// servlet-context.xml에 multipartResolver빈이 등록되어 있음
		// 1. 업로드 디렉토리(Upload)의 절대경로 얻기
		String upDir = req.getServletContext().getRealPath("/Upload");
		log.info("upDir=" + upDir);

		File dir = new File(upDir);
		if (!dir.exists()) {
			dir.mkdirs();// 디렉토리 생성
		}

		if (!mfilename.isEmpty()) {
			// 2. 먼저 첨부파일명,파일크기 알아내자
			String originfile = mfilename.getOriginalFilename();
			long fsize = mfilename.getSize();
			// 동일한 파일명일 경우 덮어쓰기 방지하기 위해
			UUID uuid = UUID.randomUUID();

			String fname = uuid.toString() + "_" + originfile;
			log.info("fname=" + fname);

			board.setOriginFilename(originfile);// 원본파일명
			board.setFilename(fname);// 물리적 파일명
			board.setFilesize(fsize);

			// 3. 업로드 처리=> transferTo()
			try {
				mfilename.transferTo(new File(upDir, fname));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//4. 글 수정의 경우 예전파일은 새로운 첨부파일이 있다면 삭제처리
			if(board.getMode().equals("Edit")&& !old_file.isEmpty()) {
				File delFile=new File(upDir, old_file);
				boolean b=delFile.delete();
				log.info("이전 첨부파일 삭제 처리 여부: "+b);
			}
		} // mfilename.isEmpty

		// 4. BoardService객체를 통해 글쓰기 처리

		int n = 0;
		String mode=board.getMode();
		String str="";
		if(mode.equals("write")) {
			//mode가 글쓰기라면
			n = bService.insertBoard(board);
			str="글쓰기";
		}else if(mode.equals("Edit")) {
			//mode가 글 수정이라면
			n=bService.updateBoard(board);
			str="글수정";
		}else if(mode.equals("rewrite")) {
			//mode가 답변글 쓰기 라면
			n=bService.rewriteBoard(board);
			str="답변글 쓰기";
		}
		
		
		
		str += (n > 0) ? " 성공" : " 실패";
		String loc = (n > 0) ? "list" : "javascript:history.back()";

		return util.addMsgLoc(m, str, loc);
	}// ----------------------------

	@RequestMapping("/list")
	public String boardListPaging(Model m,
			HttpServletRequest req,
			@ModelAttribute("paging") PagingVO paging) {
		log.info("paging=   "+paging);
		
		//1. 총 게시글 수 가져오기
		int totalCount=bService.getTotalCount();
		
		paging.setTotalCount(totalCount);
		paging.setPagingBlock(5);
		paging.init();
		log.info("페이징연산 후 paging="+paging);
		//2. 게시 목록 가져오기
		List<BoardVO> bList=bService.selectBoardAllPaging(paging);
		
		//3. 게시판 페이지 네비 문자열 가져오기
		String myctx="/myspring";
		String loc="board/list";
		String str=paging.getPageNavi(myctx, loc);
		
		
		m.addAttribute("boardList", bList);
		m.addAttribute("paging", paging);
		m.addAttribute("pageNavi", str);
		
		return "board/boardList3";
	}
	
	@RequestMapping("/list_old")
	public String boardList(Model m, @RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageSize) {

		// 1.총게시글 수 가져오기
		int totalCount = bService.getTotalCount();

		// 2. pageCount구하기
		// int pageSize=5;
		int pageCount = (totalCount - 1) / pageSize + 1;
		if (cpage <= 0) {
			cpage = 1;
		}
		if (cpage > pageCount) {
			cpage = pageCount;
		}
		Map<String, Integer> map = new HashMap<>();
		int end = cpage * pageSize;
		int start = end - pageSize;
		map.put("start", start);
		map.put("end", end);

		List<BoardVO> bList = bService.selectBoardAll(map);

		m.addAttribute("boardList", bList);
		m.addAttribute("totalCount", totalCount);
		m.addAttribute("pageCount", pageCount);
		m.addAttribute("pageSize", pageSize);
		m.addAttribute("cpage", cpage);
		return "board/boardList";
	}

	/** 게시글 내용 보기 */
	@GetMapping("/view")
	public String boardView(Model m, @RequestParam(defaultValue = "0") int idx) {
		log.info("idx= " + idx);
		if (idx == 0) {
			return "redirect:list";
		}
		// 1. 조회수 증가
		int n = bService.updateReadnum(idx);

		// 2. 해당 게시글 가져오기

		BoardVO board = bService.selectBoardByIdx(idx);

		m.addAttribute("board", board);
		return "board/boardView";
	}

	/** 파일 다운로드 */
	
	@RequestMapping(value = "/fileDown", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> download(HttpServletRequest req, 
			@RequestHeader("User-Agent") String userAgent,
			@RequestParam("filename") String fname, 
			@RequestParam("origin") String originFilename) {
		log.info("fname= " + fname+", originFilename= "+originFilename);
		String up_dir = req.getServletContext().getRealPath("/Upload");
		String filePath = up_dir + File.separator + fname;//fname: 다운로드할 물리적인 파일 명
		log.info("filePath=" + filePath);
		FileSystemResource resource = new FileSystemResource(filePath);

		// 유효성 체크------------------------------------------
		if (!resource.exists()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} // ----------------------------------------------------
			// 파일이름 한글 인코딩처리----------------------------
		boolean checkIE = (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1);// 브라우저가 IE인 경우

		String downloadName = null;
		try {
			if (checkIE) {
				downloadName = URLEncoder.encode(originFilename, "UTF8").replaceAll("\\+", " ");
			} else {
				downloadName = new String(originFilename.getBytes("UTF-8"), "ISO-8859-1");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} // -------------------------------------------------------

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=" + downloadName);

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	@GetMapping("/boardPasswd")
	public String passwdForm(Model m, 
			@RequestParam(defaultValue="0") int idx,
			@RequestParam(defaultValue="") String mode
			){
		
		if(idx==0||mode.isEmpty()) {
			String msg="잘못 들어온 경로입니다.";
			return util.addMsgBack(m, msg);
		}
		
		m.addAttribute("idx",idx);
		m.addAttribute("mode",mode);
		
		return "board/boardPassword";
	}//------------------------------------------
	
	@PostMapping("/edit")
	public String boardEditForm(Model m,
			@RequestParam(defaultValue="0") int idx,
			@RequestParam(defaultValue="") String pwd,
			@RequestParam(defaultValue="") String mode
			) {		

		if(idx==0||mode.isEmpty()||pwd.isEmpty()) {
			String msg="잘못 들어온 경로입니다.";
			return util.addMsgBack(m, msg);
		}
		
		//해당 글의 글번호로 db의 pwd가져와서 사용자가 입력한 pwd와 일치하는지 여부를 체크
		//일치하면 수정폼을 보여준다.
		BoardVO board=bService.selectBoardByIdx(idx);
		if(!board.getPwd().equals(pwd)) {
			String msg="비밀번호가 일치하지 않아요";
			return util.addMsgBack(m, msg);
		}
		
		m.addAttribute("board",board);
		m.addAttribute("mode",mode);
		
		return "board/boardEdit";
	}//------------------------------------------
	
	@PostMapping("/delete")
	public String boardDelete(Model m,
			HttpServletRequest req,
			@RequestParam(defaultValue="0") int idx,
			@RequestParam(defaultValue="") String pwd,
			@RequestParam(defaultValue="") String old_file) {
		//1. 유효성 체크
		String msg="";
		if(idx==0||pwd.isEmpty()) {
			msg="잘못된 경로입니다.";
			return util.addMsgBack(m, msg);
		}
		
		
		//2. 해당글의 비번을 가져와서 사용자가 입력한 비번과 비교
		// 일치하지 않으면 메시지 띄우기
		BoardVO b=bService.selectBoardByIdx(idx);
		if(!b.getPwd().equals(pwd)) {
			msg="비밀번호가 일치하지 않습니다.";
			return util.addMsgBack(m, msg);
		}
		
		//비번이 일치하면
		//2_1. 이전 파일 삭제처리
		if(b.getIsFile()==1) {//첨부파일이 있다면 1이 나온다
			String upDir = req.getServletContext().getRealPath("/Upload");
			File delFile=new File(upDir, b.getFilename());
			boolean c=delFile.delete();
			log.info("글삭제시 파일 삭제처리: "+c);
		
		}
		//2_2. 글 삭제처리
		int n=bService.deleteBoard(idx);
		String msg2=(n>0)?"글 삭제 성공":"글 삭제 실패";
		return util.addMsgLoc(m, msg2, "list");
	}
	
	/**답변글 달기 폼 보여주기*/
	@PostMapping("/rewrite")
	public String rewriteForm(Model m,
			 @RequestParam(defaultValue="0") int idx,
			 @RequestParam(defaultValue="") String subject
			 ) {
		if(idx==0||subject.isEmpty()) {
			return "redirect:list";
		}
		m.addAttribute("idx", idx);
		m.addAttribute("subject",subject);
		
		
		return "board/boardRewrite";
	}
}/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
















