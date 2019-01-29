package com.tis.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {
	
	private int idx;
	private String name;
	private String pwd;
	private String subject;
	private String content;
	private Timestamp wdate;
	private int readnum;
	
	private String filename;
	private String originFilename;
	private long filesize;
	
	private int refer;
	private int lev;
	private int sunbun;
	
	private int isFile;//첨부파일이 있으면1, 없으면 0값을 갖는다.
	private int newImg;//24시간 이내 쓴 글
}
