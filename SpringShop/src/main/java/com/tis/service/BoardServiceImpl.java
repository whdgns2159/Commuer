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
		//[1] �θ���� �۹�ȣ�� �θ���� refer, lev, sunbun���� �����´�(select��)
		BoardVO parent=bMapper.selectRefLevSunbun(board.getIdx());
		log.info("parent"+parent);
		//[2] ������ �̹� �޸� �亯 �۵��� �ִٸ� sunbun�� �ϳ��� �ڷ� �о�� ����.
		//��? �� �亯���� ������� �ϹǷ�
		int n=bMapper.updateSunbun(parent);
		
		//[3] ���� �� �亯���� insert�Ѵ�.(insert��)
		//�� �� �θ���� �۱׷� ��ȣ(refer)�� �����ϰ� lev�� �θ���� lev���� 1ũ��
		//sunbun�� �θ���� sunbun���� 1ũ��
		
		//�θ� ���� => parent(BoardVO)
		//���� �� �亯�� => board(BoardVO)
		board.setRefer(parent.getRefer());//�θ�۰� ���� �� �׷��ȣ ����
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
