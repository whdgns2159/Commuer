package com.tis.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tis.domain.MemoVO;
import com.tis.persistence.MemoDAO;
//비즈니스 계층(아주 중요한녀석) 로직처리, 트랜잭션처리를 담당한다.
@Service("memoSerivceImpl")
public class MemoServiceImpl implements MemoService {
	
	@Resource(name="memoDAOMyBatis")
	private MemoDAO memoDao;

	@Override
	public int getTotalCount() {
		return memoDao.getTotalCount();
	}

	@Override
	public int createMemo(MemoVO memo) {		
		return memoDao.createMemo(memo);
	}

	@Override
	public List<MemoVO> listMemo(Map<String, Integer> map) {
		return memoDao.listMemo(map);
	}

	@Override
	public int deleteMemo(int idx) {
		return memoDao.deleteMemo(idx);
	}

	@Override
	public int updateMemo(MemoVO memo) {
		return memoDao.updateMemo(memo);
	}

	@Override
	public MemoVO getMemo(int idx) {
		return memoDao.getMemo(idx);
	}

}
