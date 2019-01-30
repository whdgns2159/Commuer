package com.tis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.tis.domain.BoardVO;
import com.tis.domain.PagingVO;

//com.tis.mapper.BoardMapper인터페이스명과
//BoardMapper.xml의 네임스페이스가 반드시 같아야 하며
//메소드명은 BoardMapper.xml의 id와 이름이 동일해야 한다.
public interface BoardMapper {
	//@Select("select count(*) from tab")
	int tabCount();
	int insertBoard(BoardVO board);
	//게시목록 가져오기
	List<BoardVO> selectBoardAll(Map<String,Integer> map);
	List<BoardVO> selectBoardAllPaging(PagingVO paging);
	
	//검색목록 가져오기
	List<BoardVO> findBoard(PagingVO paging);
	
	int getTotalCount();//총 게시글 수 가져오기
	int getTotalCountPaging(PagingVO paging);//검색한 총 게시글 수 가져오기

	//글번호에 해당하는 글 가져오기
	BoardVO selectBoardByIdx(Integer idx);	
	//조회수 증가하기
	int updateReadnum(Integer idx);
	
	String selectPwd(Integer idx);
	int deleteBoard(Integer idx);
	int updateBoard(BoardVO board);

	//답변형(계층형) 게시판에서 답변글 달기
	int rewriteBoard(BoardVO board); //[답변형]
	BoardVO selectRefLevSunbun(int idx);//[답변형]
	int updateSunbun(BoardVO parent);//[답변형]

}
