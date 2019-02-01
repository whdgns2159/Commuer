package com.user.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.user.domain.NotUserException;
import com.user.domain.UserVO;
import com.user.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Inject
	private UserMapper uMapper;
	
	@Override
	public int createUser(UserVO user) {
		return uMapper.createUser(user);
	}

	@Override
	public List<UserVO> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean idCheck(String userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteUser(Integer midx) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO getUser(Integer midx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findUser(UserVO findUser) throws NotUserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO loginCheck(String userid, String pwd) throws NotUserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMileage(int idx, int opoint) {
		// TODO Auto-generated method stub
		return 0;
	}

}
