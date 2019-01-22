package com.tis.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tis.domain.MemoVO;
import com.tis.persistence.MemoDAO;
//����Ͻ� ����(���� �߿��ѳ༮) ����ó��, Ʈ�����ó���� ����Ѵ�.
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
