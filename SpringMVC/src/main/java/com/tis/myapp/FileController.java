package com.tis.myapp;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.extern.log4j.Log4j;
/*파일 업로드 하기
 * [1] MultipartFile을 이용하는 방법
 * [2] MultipartHttpServletReques를 이용하는 방법
 * 		=>이 경우는 동일한 파라미터명으로 여러개의 파일을 업로드하는경우에 유용함
 * */
@Controller("fileController")
@Log4j
public class FileController {
	
	@javax.annotation.Resource(name="upDir")
	private String upDir;
	
	//스프링 단일 업로드 처리------------------------------------------------------------------
	//fileUp ==> fileTest.jsp가 출력되도록 매핑하세요
	@RequestMapping(value="/fileUp", method=RequestMethod.GET)// fileUp주소로 파라미터없이 접속 했을때
	public String showForm() {
		
		return "fileup/fileTest";
		//WEB-INF/views/fileup/fileTest.jsp
	}
	
	@RequestMapping(value="/fileUp", method=RequestMethod.POST)
	public String fileUpload(@RequestParam("name") String name, 
			@RequestParam("filename") MultipartFile filename, Model m) {
		log.info("name="+name+"  file="+filename);
		
		//업로드한 파일명과 사이즈 알아내기
		String fname=filename.getOriginalFilename();
		long fsize=filename.getSize();
		
		//업로드 처리 =>transFerTo()메소드 사용
		if(!filename.isEmpty()) {
			try {
				filename.transferTo(new File(upDir, fname));
				log.info("파일 업로드 성공 "+upDir+"에 저장되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		m.addAttribute("file1",fname);
		m.addAttribute("file1size",fsize);
		m.addAttribute("upDir",upDir);
		
		return "fileup/fileUpload";
	}
	// 해당jsp의 form태그엔 multipart/form-data 속성이 들어가서 
	//파라미터나 업로드한 파일데이터를 받아올 수 없다
	
	// 스프링 다중 업로드 --------------------------------------------------------------------------
	@RequestMapping(value="/fileUp2", method=RequestMethod.GET)// fileUp주소로 파라미터없이 접속 했을때
	public String showForm2() {
		
		return "fileup/fileTest2";
		//WEB-INF/views/fileup/fileTest.jsp
	}
	
	//MultipartHttpServletRequest를 이용
	@RequestMapping(value="/fileUp2", method=RequestMethod.POST)
	public String fileUpload2(Model m, HttpServletRequest req) {
		//올린이 파라미터값 받기
		String name=req.getParameter("name");
		log.info("name=="+name);
		//첨부파일 목록 받기
		MultipartHttpServletRequest mr=(MultipartHttpServletRequest)req;
		List<MultipartFile> arr=mr.getFiles("filename");
		if(arr!=null) {
			for(int i=0;i<arr.size();i++) {
				MultipartFile mf=arr.get(i);
				//[1] 파라미터명 얻기
				String param=mf.getName();
				//[2] 첨부파일명 얻기
				String fname=mf.getOriginalFilename();
				//[3] 파일 크기얻기
				long fsize=mf.getSize();
				log.info("param="+param+", fname="+fname+", fsize="+fsize);
				
				try {
					//업로드 처리
					mf.transferTo(new File(upDir, fname));
					m.addAttribute("file"+(i+1),fname);
					m.addAttribute("file"+(i+1)+"size",fsize);
					m.addAttribute("upDir", upDir);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return "fileup/fileUpload2";
	}
	
	//ResponseEntity타입: 데이터와 함께 헤더 상태 메시지를 전달하고자 할 때 사용
	//HTTP헤더를 다뤄야 할 경우 ResponseEntity를 통해 헤더 정보나 데이터를 전달 할 수 있다.
	@RequestMapping(value="/fileDown", 
			produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> download(HttpServletRequest req,@RequestHeader("User-Agent") String userAgent, @RequestParam("fname") String fname){
		log.info("fname= "+fname);
		String up_dir=req.getServletContext().getRealPath("/images");
		String filePath=up_dir+File.separator+fname;
		log.info("filePath="+filePath);
		FileSystemResource resource=new FileSystemResource(filePath);
		
		//유효성 체크------------------------------------------
		if(!resource.exists()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}//----------------------------------------------------
		//파일이름 한글 인코딩처리----------------------------
		boolean checkIE = (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1);//브라우저가 IE인 경우

		String downloadName = null;
		try {
			if (checkIE) {
				downloadName = URLEncoder.encode(fname, "UTF8").replaceAll("\\+", " ");
			} else {
				downloadName = new String(fname.getBytes("UTF-8"), "ISO-8859-1");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}//-------------------------------------------------------
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename="+downloadName);
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}/////////////////////////////////////////////
