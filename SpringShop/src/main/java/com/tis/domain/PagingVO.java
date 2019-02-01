package com.tis.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
public class PagingVO {

	
	// ����¡ ó�� ���� ������Ƽ ����
	private int cpage;// ���� ������ ������ ��ȣ
	private int pageSize =0;// �� ������ �� ������ ��� ����
	private int totalCount;// �� �Խñ� ��
	private int pageCount;// ��������

	// DB���� ���ڵ带 ����� �� ����� ���۰�, ����
	private int start;
	private int end;

	// ����¡ �� ó�� ���� ������Ƽ
	private int pagingBlock = 5;// �� �� �� ������ ������ ��
	private int prevBlock;// ���� 5��
	private int nextBlock;// ���� 5��

	// �˻� ���� ������Ƽ
	private String findType;// �˻� ����
	private String findKeyword;// �˻���
	
	public void init(HttpSession ses) {
		if(pageSize<0) {
			pageSize=5;
		}
		if(pageSize==0) {
			//�Ķ���ͷ� �Ѿ���� pageSize�� ���ٸ�
			//���ǿ� ����� pageSize�� �ִ��� ã�ƺ���.
			Integer ps=(Integer)ses.getAttribute("pageSize");
			
			if(ps==null) {//���ǿ��� ���ٸ�
				pageSize=5;
			}else {
				pageSize=ps;
			}
		}
		ses.setAttribute("pageSize", pageSize);
		
		pageCount=(totalCount-1)/pageSize+1;
		if(cpage<=0) {
			cpage=1;
		}
		if(cpage>pageCount) {
			cpage=pageCount;
		}
		end=cpage*pageSize;
		start=end-pageSize;
		//����¡ �� ����
		prevBlock=(cpage-1)/pagingBlock * pagingBlock;
		nextBlock= prevBlock + (pagingBlock+1);
	}//init()
	
	/**
	 * 
	 * cpage              pagingBlock                prevBlock                 nextBlock
	 *									5 
	 * 	1~5															  x									6
	 * 6~10															  5								11
	 * ...	
	 * 
	 * (cpage-1)/pagingBlock * pagingBlock
	 * 
	 * prevBlock=(cpage-1)/pagingBlock * pagingBlock;
	 * nextBlock= prevBlock + (pagingBlock+1);
	 * */
	
	/**������ �׺���̼� ���ڿ��� ��ȯ�ϴ� �޼ҵ�*/
	public String getPageNavi(String myctx, String loc) {
		//myctx: context��
		//loc: �Խ��� ��ϰ�� /board/list 
		//qStr : Query String
		findType=(findType==null)?"":findType;
		try {
			findKeyword=(findKeyword==null)?"":
				URLEncoder.encode(findKeyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.info(e);
		}
		
		
		String qStr="?pageSize="+pageSize+"&findType="+findType+"&findKeyword="+findKeyword;
		//String�� �Һ���(immutablility) ������ StringBuffer/StringBuilder
		//�� �̿��Ͽ� ���ڿ��� ������ �� String���� ����� ��ȯ����.
		StringBuilder buf=new StringBuilder().append("<ul class='pagination'>");
		if(prevBlock>0) {
			//���� 5��
			buf.append("<li><a href='"+myctx+"/"+loc+qStr+"&cpage="+prevBlock+"'>");
			buf.append("Prev");
			buf.append("</a></li>");
		}
		for(int i=prevBlock+1; i<=nextBlock-1 && i<=pageCount;i++) {
			String css="";
			if(i==cpage) {
				css="class='active'";
			}			
			
			buf.append("<li "+css+"><a href='"+myctx+"/"+loc+qStr+"&cpage="+i+"'>");
			buf.append(i);
			buf.append("</a></li>");
		}
		
		if(nextBlock<pageCount) {
			//���� 5��
			buf.append("<li><a href='"+myctx+"/"+loc+qStr+"&cpage="+nextBlock+"'>");
			buf.append("Next");
			buf.append("</a></li>");
		}
				
				buf.append("</ul>");
		String str=buf.toString();
		
		return str;
	}
}//-----------------------------------------------
