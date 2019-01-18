package ex03;

import java.io.Serializable;
import java.util.Date;

public class UserVO implements Serializable{
	
	private int idx;
	private String name,userid,pwd;
	private Date indate;
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVO(int idx, String name, String userid, String pwd, Date indate) {
		super();
		this.idx = idx;
		this.name = name;
		this.userid = userid;
		this.pwd = pwd;
		this.indate = indate;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "UserVO [idx=" + idx + ", name=" + name + ", userid=" + userid + ", pwd=" + pwd + ", indate=" + indate
				+ "]";
	}
	

}
