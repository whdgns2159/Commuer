package com.tis.persistence;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tis.domain.MemoVO;



//영속성 계층에 주는 어노테이션 => @Repository("빈이름")
@Repository("memoDAOMyBatis")
public class MemoDAOMyBatis implements MemoDAO{
	
	private final String NS="com.tis.mapper.MemoMapper";
	
	//root-context.xml에 등록된 빈을 주입하도록 하자
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	@Override
	public int getTotalCount() {
		System.out.println("session==="+session);
		return session.selectOne(NS+".memoCount");
	}

	@Override
	public int createMemo(MemoVO memo) {
		return session.insert(NS+".createMemo",memo);
	}

	@Override
	public List<MemoVO> listMemo(Map<String, Integer> map) {
		return session.selectList(NS+".listMemo",map);
	}

	@Override
	public int deleteMemo(int idx) {
		return session.delete(NS+".deleteMemo",idx);
	}

	@Override
	public int updateMemo(MemoVO memo) {
		return session.update(NS+".editMemo",memo);
	}

	@Override
	public MemoVO getMemo(int idx) {
		return session.selectOne(NS+".getMemo",idx);
	}
}
