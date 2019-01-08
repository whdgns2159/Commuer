package board.model;

import java.util.Date;

public class ReplyVO {

	private int ReplyNum;
	private int BoardNum;
	private String id;
	private String content;
	private Date wdate;
	
	public ReplyVO(int replyNum, int boardNum, String id, String content, Date wdate) {
		super();
		ReplyNum = replyNum;
		BoardNum = boardNum;
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

	public int getBoardNum() {
		return BoardNum;
	}

	public void setBoardNum(int boardNum) {
		BoardNum = boardNum;
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
