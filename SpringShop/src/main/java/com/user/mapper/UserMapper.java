package com.user.mapper;

import java.util.List;

import com.user.domain.NotUserException;
import com.user.domain.UserVO;

public interface UserMapper{
	//UserMapper.xml ¿¡ namespace´Â com.user.mapper.UserMapper
	int createUser(UserVO user);
	List<UserVO> listUser();
	
	boolean idCheck(String userid);
	int deleteUser(Integer midx);
	int updateUser(UserVO user);
	
	UserVO getUser(Integer midx);
	UserVO findUser(UserVO findUser) throws NotUserException;
	
	int updateMileage(Integer midx, int opoint);

}
