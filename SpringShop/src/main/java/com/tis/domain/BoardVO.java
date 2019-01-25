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
}
