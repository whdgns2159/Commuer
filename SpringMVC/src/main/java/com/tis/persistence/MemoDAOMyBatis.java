package com.tis.persistence;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;



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
}
