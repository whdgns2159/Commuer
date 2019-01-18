package ex01;

import java.util.List;

public interface UserDAO {
	
	int createUser(UserVO user);
	List<UserVO> listUser();
	int deleteUser(int idx);
	int updateUser(UserVO user);
	UserVO getUser(int idx);
	int getUserCount();
	

}
