package com.tis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.tis.domain.BoardVO;
import com.tis.domain.PagingVO;

//com.tis.mapper.BoardMapper�������̽����
//BoardMapper.xml�� ���ӽ����̽��� �ݵ�� ���ƾ� �ϸ�
//�޼ҵ���� BoardMapper.xml�� id�� �̸��� �����ؾ� �Ѵ�.
public interface BoardMapper {
	//@Select("select count(*) from tab")
	int tabCount();
	int insertBoard(BoardVO board);
	//�Խø�� ��������
	List<BoardVO> selectBoardAll(Map<String,Integer> map);
	List<BoardVO> selectBoardAllPaging(PagingVO paging);
	
	//�˻���� ��������
	List<BoardVO> findBoard(PagingVO paging);
	
	int getTotalCount();//�� �Խñ� �� ��������
	int getTotalCountPaging(PagingVO paging);//�˻��� �� �Խñ� �� ��������

	//�۹�ȣ�� �ش��ϴ� �� ��������
	BoardVO selectBoardByIdx(Integer idx);	
	//��ȸ�� �����ϱ�
	int updateReadnum(Integer idx);
	
	String selectPwd(Integer idx);
	int deleteBoard(Integer idx);
	int updateBoard(BoardVO board);

	//�亯��(������) �Խ��ǿ��� �亯�� �ޱ�
	int rewriteBoard(BoardVO board); //[�亯��]
	BoardVO selectRefLevSunbun(int idx);//[�亯��]
	int updateSunbun(BoardVO parent);//[�亯��]

}
