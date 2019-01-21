package com.tis.persistence;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;



//���Ӽ� ������ �ִ� ������̼� => @Repository("���̸�")
@Repository("memoDAOMyBatis")
public class MemoDAOMyBatis implements MemoDAO{
	
	private final String NS="com.tis.mapper.MemoMapper";
	
	//root-context.xml�� ��ϵ� ���� �����ϵ��� ����
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	@Override
	public int getTotalCount() {
		System.out.println("session==="+session);
		return session.selectOne(NS+".memoCount");
	}
}
