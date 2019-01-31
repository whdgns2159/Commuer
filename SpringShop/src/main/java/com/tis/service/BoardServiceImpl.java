package com.tis.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tis.domain.BoardVO;
import com.tis.domain.PagingVO;
import com.tis.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Service("boardService")
@Log4j
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper bMapper;
	
	@Override
	public int testTabCount() {
		return bMapper.tabCount();
	}

	@Override
	public int insertBoard(BoardVO board) {
		return bMapper.insertBoard(board);
	}

	@Override
	public List<BoardVO> selectBoardAll(Map<String, Integer> map) {
		return bMapper.selectBoardAll(map);
	}

	@Override
	public List<BoardVO> selectBoardAllPaging(PagingVO paging) {
		return bMapper.selectBoardAllPaging(paging);
	}

	@Override
	public List<BoardVO> findBoard(PagingVO paging) {
		return bMapper.findBoard(paging);
	}

	@Override
	public int getTotalCount() {
		return bMapper.getTotalCount();
	}

	@Override
	public int getTotalCount(PagingVO paging) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO selectBoardByIdx(Integer idx) {
		
		return bMapper.selectBoardByIdx(idx);
	}

	@Override
	public int updateReadnum(Integer idx) {
		return bMapper.updateReadnum(idx);
	}

	@Override
	public String selectPwd(Integer idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBoard(Integer idx) {
		return bMapper.deleteBoard(idx);
	}

	@Override
	public int updateBoard(BoardVO board) {
		return bMapper.updateBoard(board);
	}

	@Override
	public int rewriteBoard(BoardVO board) {
		//[1] 부모글의 글번호로 부모글의 refer, lev, sunbun값을 가져온다(select문)
		BoardVO parent=bMapper.selectRefLevSunbun(board.getIdx());
		log.info("parent"+parent);
		//[2] 기존에 이미 달린 답변 글들이 있다면 sunbun을 하나씩 뒤로 밀어내기 하자.
		//왜? 내 답변글이 끼어들어야 하므로
		int n=bMapper.updateSunbun(parent);
		
		//[3] 내가 쓴 답변글을 insert한다.(insert문)
		//이 때 부모글의 글그룹 번호(refer)와 동일하게 lev은 부모글의 lev보다 1크게
		//sunbun도 부모글의 sunbun보다 1크게
		
		//부모 원글 => parent(BoardVO)
		//내가 쓴 답변글 => board(BoardVO)
		board.setRefer(parent.getRefer());//부모글과 같은 글 그룹번호 지정
		board.setLev(parent.getLev()+1);
		board.setSunbun(parent.getSunbun()+1);
		
		return bMapper.rewriteBoard(board);
	}

	@Override
	public BoardVO selectRefLevSunbun(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateSunbun(BoardVO parent) {
		// TODO Auto-generated method stub
		return 0;
	}

}
