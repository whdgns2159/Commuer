package board.model;

import java.util.Date;

public class BoardVO {

	private int num;
	private String subject;
	private String content;
	private String id;
	private int hits;
	private int likes;
	private Date date;
	
	
	public BoardVO() {
		
	}

	public BoardVO(int num, String subject, String content, String id, int hits, int likes, Date date) {
		super();
		this.num = num;
		this.subject = subject;
		this.content = content;
		this.id = id;
		this.hits = hits;
		this.likes = likes;
		this.date = date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
