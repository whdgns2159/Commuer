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
/*���� ���ε� �ϱ�
 * [1] MultipartFile�� �̿��ϴ� ���
 * [2] MultipartHttpServletReques�� �̿��ϴ� ���
 * 		=>�� ���� ������ �Ķ���͸����� �������� ������ ���ε��ϴ°�쿡 ������
 * */
@Controller("fileController")
@Log4j
public class FileController {
	
	@javax.annotation.Resource(name="upDir")
	private String upDir;
	
	//������ ���� ���ε� ó��------------------------------------------------------------------
	//fileUp ==> fileTest.jsp�� ��µǵ��� �����ϼ���
	@RequestMapping(value="/fileUp", method=RequestMethod.GET)// fileUp�ּҷ� �Ķ���;��� ���� ������
	public String showForm() {
		
		return "fileup/fileTest";
		//WEB-INF/views/fileup/fileTest.jsp
	}
	
	@RequestMapping(value="/fileUp", method=RequestMethod.POST)
	public String fileUpload(@RequestParam("name") String name, 
			@RequestParam("filename") MultipartFile filename, Model m) {
		log.info("name="+name+"  file="+filename);
		
		//���ε��� ���ϸ��� ������ �˾Ƴ���
		String fname=filename.getOriginalFilename();
		long fsize=filename.getSize();
		
		//���ε� ó�� =>transFerTo()�޼ҵ� ���
		if(!filename.isEmpty()) {
			try {
				filename.transferTo(new File(upDir, fname));
				log.info("���� ���ε� ���� "+upDir+"�� ����Ǿ����ϴ�.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		m.addAttribute("file1",fname);
		m.addAttribute("file1size",fsize);
		m.addAttribute("upDir",upDir);
		
		return "fileup/fileUpload";
	}
	// �ش�jsp�� form�±׿� multipart/form-data �Ӽ��� ���� 
	//�Ķ���ͳ� ���ε��� ���ϵ����͸� �޾ƿ� �� ����
	
	// ������ ���� ���ε� --------------------------------------------------------------------------
	@RequestMapping(value="/fileUp2", method=RequestMethod.GET)// fileUp�ּҷ� �Ķ���;��� ���� ������
	public String showForm2() {
		
		return "fileup/fileTest2";
		//WEB-INF/views/fileup/fileTest.jsp
	}
	
	//MultipartHttpServletRequest�� �̿�
	@RequestMapping(value="/fileUp2", method=RequestMethod.POST)
	public String fileUpload2(Model m, HttpServletRequest req) {
		//�ø��� �Ķ���Ͱ� �ޱ�
		String name=req.getParameter("name");
		log.info("name=="+name);
		//÷������ ��� �ޱ�
		MultipartHttpServletRequest mr=(MultipartHttpServletRequest)req;
		List<MultipartFile> arr=mr.getFiles("filename");
		if(arr!=null) {
			for(int i=0;i<arr.size();i++) {
				MultipartFile mf=arr.get(i);
				//[1] �Ķ���͸� ���
				String param=mf.getName();
				//[2] ÷�����ϸ� ���
				String fname=mf.getOriginalFilename();
				//[3] ���� ũ����
				long fsize=mf.getSize();
				log.info("param="+param+", fname="+fname+", fsize="+fsize);
				
				try {
					//���ε� ó��
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
	
	//ResponseEntityŸ��: �����Ϳ� �Բ� ��� ���� �޽����� �����ϰ��� �� �� ���
	//HTTP����� �ٷ�� �� ��� ResponseEntity�� ���� ��� ������ �����͸� ���� �� �� �ִ�.
	@RequestMapping(value="/fileDown", 
			produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> download(HttpServletRequest req,@RequestHeader("User-Agent") String userAgent, @RequestParam("fname") String fname){
		log.info("fname= "+fname);
		String up_dir=req.getServletContext().getRealPath("/images");
		String filePath=up_dir+File.separator+fname;
		log.info("filePath="+filePath);
		FileSystemResource resource=new FileSystemResource(filePath);
		
		//��ȿ�� üũ------------------------------------------
		if(!resource.exists()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}//----------------------------------------------------
		//�����̸� �ѱ� ���ڵ�ó��----------------------------
		boolean checkIE = (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1);//�������� IE�� ���

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