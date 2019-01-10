package board.model;

import java.util.Date;

public class ReplyVO {

	private int ReplyNum;
	private int ArticleNum;
	private String id;
	private String content;
	private Date wdate;
	

	public ReplyVO(int replyNum, int articleNum, String id, String content, Date wdate) {
		super();
		ReplyNum = replyNum;
		ArticleNum = articleNum;
		this.id = id;
		this.content = content;
		this.wdate = wdate;
	}


	public int getReplyNum() {
		return ReplyNum;
	}


	public void setReplyNum(int replyNum) {
		ReplyNum = replyNum;
	}


	public int getArticleNum() {
		return ArticleNum;
	}


	public void setArticleNum(int articleNum) {
		ArticleNum = articleNum;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getWdate() {
		return wdate;
	}


	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}


	public ReplyVO(){
		
	}
	
}
