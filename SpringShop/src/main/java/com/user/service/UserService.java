package com.user.service;

import java.util.List;

import com.user.domain.NotUserException;
import com.user.domain.UserVO;

public interface UserService {
	
	int createUser(UserVO user);
	List<UserVO> listUser();
	
	boolean idCheck(String userid);
	int deleteUser(Integer midx);
	int updateUser(UserVO user);
	
	UserVO getUser(Integer midx);
	UserVO findUser(UserVO findUser) throws NotUserException;
	
	UserVO loginCheck(String userid, String pwd) throws NotUserException;
	
	int updateMileage(int idx, int opoint);

}
