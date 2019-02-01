package com.user.domain;

import java.io.Serializable;
import java.sql.Date;

//domain��ü. VO(Value Object), DTO(Data Transfer Object)
public class UserVO implements Serializable{
	
	//property : �������
	/*html�� input name�� VO�� ������Ƽ���� ��ġ�����ִ� ���� ����.
	 * --�ڹ� ���� �Ծ�
	 * 	  [1] �⺻ �����ڰ� �־�� ��
	 * 	  [2] ������Ƽ�� ĸ��ȭ �Ǿ�� ��
	 *    [3] setter/getter�� �ݵ�� �����ؾ� ��.
	 * */
	private int idx; 
	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String hp1,hp2,hp3;
	private String zipcode;	
	private String addr1, addr2;
	private java.sql.Date indate;
	
	private int mileage;
	private int mstate;
	
	public UserVO() {
		System.out.println("UserVO�⺻ ������");
	}

	public UserVO(int idx, String name, String userid, String pwd, String email, String hp1, String hp2, String hp3,
			String zipcode, String addr1, String addr2, Date indate, int mileage, int mstate) {
		super();
		this.idx = idx;
		this.name = name;
		this.userid = userid;
		this.pwd = pwd;
		this.email = email;
		this.hp1 = hp1;
		this.hp2 = hp2;
		this.hp3 = hp3;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.indate = indate;
		this.mileage = mileage;
		this.mstate = mstate;
	}

	public UserVO(String name, String userid, String pwd, String email, String hp1, String hp2, String hp3,
			String zipcode, String addr1, String addr2) {
		super();
		this.name = name;
		this.userid = userid;
		this.pwd = pwd;
		this.email = email;
		this.hp1 = hp1;
		this.hp2 = hp2;
		this.hp3 = hp3;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
	}


	//setter, getter----------
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHp1() {
		return hp1;
	}

	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}

	public String getHp2() {
		return hp2;
	}

	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}

	public String getHp3() {
		return hp3;
	}

	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public java.sql.Date getIndate() {
		return indate;
	}

	public void setIndate(java.sql.Date indate) {
		this.indate = indate;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getMstate() {
		return mstate;
	}

	public void setMstate(int mstate) {
		this.mstate = mstate;
	}
	
	public String getAllHp() {
		return hp1+"-"+hp2+"-"+hp3;
	}
	public String getAllAddr() {
		return addr1+" "+addr2;
	}
	public String getMstateInfo() {
		String str=(mstate==0)?
				"�Ϲ�ȸ��":(mstate==-1)?"����ȸ��":"Ż��ȸ��";
		return str;
	}
	

	/*@Override
	public String toString() {
		return "UserVO [idx=" + idx + ", name=" + name + ", userid=" + userid + ", pwd=" + pwd + ", email=" + email
				+ ", hp1=" + hp1 + ", hp2=" + hp2 + ", hp3=" + hp3 + ", zipcode=" + zipcode + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", indate=" + indate + ", mileage=" + mileage + ", mstate=" + mstate + "]";
	}*/

}



