package user.model;

import java.util.Date;

public class UserVO {
	private int userIndex;
	private String id;
	private String pwd;
	private String nickname;
	private String email;
	private String tel;
	private Date regDate;
	
	public UserVO(int userIndex, String id, String pwd, String nickname, String email, String tel, Date regDate) {
		super();
		this.userIndex = userIndex;
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
		this.email = email;
		this.tel = tel;
		this.regDate = regDate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname; 
	}
	public int getUserIndex() {
		return userIndex;
	}
	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public UserVO() {
		
	}

}
