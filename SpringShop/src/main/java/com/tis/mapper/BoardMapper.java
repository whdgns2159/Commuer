package com.tis.mapper;

import org.apache.ibatis.annotations.Select;

//com.tis.mapper.BoardMapper�������̽����
//BoardMapper.xml�� ���ӽ����̽��� �ݵ�� ���ƾ� �ϸ�
//�޼ҵ���� �� BoardMapper.xml�� id�� �̸��� �����ؾ� �Ѵ�

public interface BoardMapper {
	//@Select("select count(*) from tab")
	int tabCount();
}
