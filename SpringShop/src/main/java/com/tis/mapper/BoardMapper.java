package com.tis.mapper;

import org.apache.ibatis.annotations.Select;

//com.tis.mapper.BoardMapper인터페이스명과
//BoardMapper.xml의 네임스페이스가 반드시 같아야 하며
//메소드명은 각 BoardMapper.xml의 id와 이름이 동일해야 한다

public interface BoardMapper {
	//@Select("select count(*) from tab")
	int tabCount();
}
