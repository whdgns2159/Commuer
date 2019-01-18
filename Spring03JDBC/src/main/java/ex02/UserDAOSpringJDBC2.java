package ex02;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import ex02.UserVO;

public class UserDAOSpringJDBC2 extends JdbcDaoSupport
implements UserDAO {
	
	private RowMapper<UserVO> rowMapper=new RowMapper<UserVO>(){

		@Override
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO u=new UserVO();
			u.setIdx(rs.getInt("idx"));
			u.setName(rs.getString("name"));
			u.setUserid(rs.getString("userid"));
			u.setPwd(rs.getString("pwd"));
			u.setIndate(rs.getDate("indate"));
			//System.out.println("rowNum="+rowNum+", "+u.getName());
			return u;
		}
		
	};

	@Override
	public int createUser(UserVO user) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO spring_user VALUES("
				+"spring_user_idx_seq.nextval,?,?,?,sysdate)";
		Object[] data={user.getName(),user.getUserid(),user.getPwd()};
		int n=this.getJdbcTemplate().update(sql,data);
		System.out.println("n="+n);
		return n;
	}

	@Override
	public List<UserVO> listUser() {
		String sql="select * from spring_user order by idx desc";
		List<UserVO> userList
		=this.getJdbcTemplate().query(sql,
				rowMapper);
		return userList;
	}

	@Override
	public int deleteUser(int idx) {
		String sql="DELETE FROM spring_user WHERE idx=?";
		Object[] args=new Object[]{idx};
		return this.getJdbcTemplate().update(sql,args);
	}

	@Override
	public int updateUser(UserVO user) {
		String sql="UPDATE spring_user SET name=?, userid=?, pwd=? WHERE idx=?";
		Object[] args={user.getName(),user.getUserid(), user.getPwd(),user.getIdx()};
		return this.getJdbcTemplate().update(sql,args);
	}

	@Override
	public UserVO getUser(int idx) {
		String sql="SELECT * FROM spring_user WHERE idx=?";
		UserVO user=(UserVO)this.getJdbcTemplate().queryForObject(sql,rowMapper,new Object[]{idx});
		return user;
	}

	@Override
	public int getUserCount() {
		String sql="SELECT count(*) FROM spring_user";
		//int cnt=this.getJdbcTemplate().queryForInt(sql);//[x] deprecated
		int cnt=this.getJdbcTemplate().queryForObject(sql, new RowMapper<Integer>(){
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1);
			}
			
		});
		return cnt;
	}

}
