package board.dao;

import java.util.List;
import java.util.Map;

import board.domain.BoardVO;
import board.domain.PagingVO;

public interface BoardDAO {
	int insertBoard(BoardVO board);

	// 게시목록 가져오기
	List<BoardVO> selectBoardAll(Map<String, Integer> map);

	List<BoardVO> selectBoardAll(PagingVO paging);

	// 검색목록 가져오기
	List<BoardVO> findBoard(PagingVO paging);

	int getTotalCount();// 총 게시글 수 가져오기

	int getTotalCount(PagingVO paging);// 검색한 총 게시글 수 가져오기

	// 글 번호에 해당하는 글 가져오기(글내용)
	BoardVO selectBoardByIdx(Integer idx);

	// 조회수 증가하기
	int updateReadnum(Integer idx);

	String selectPwd(Integer idx);

	int deleteBoard(Integer idx);

	int updateBoard(BoardVO board);

	// 답변형(계층형) 게시판에서 답변글 달기
	int rewriteBoard(BoardVO board); // [답변형]

	BoardVO selectRefLevSunbun(int idx);// [답변형]

	int updateSunbun(BoardVO parent);// [답변형]

}///////////////////////////////////////
