package com.tis.ex01;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j;

@Log4j
public class BizServiceImpl implements BizService {

	List<String> arr=new ArrayList<>();
	//����Ͻ������� Ŭ��������
	@Override
	public int insertData(String data) {
		//log.info("==�ٽ� ������ �����ϴ� �޼ҵ�insertDate()===");
		System.out.println("==�ٽ� ������ �����ϴ� �޼ҵ�insertDate()===");
		/*int n=Integer.parseInt(data);*/
		arr.add(data);
		//
		//[1] �ٽ� ������ �����ϴ� �� 
		//[2] ���� ���ɻ���: �α�, ����, Ʈ����� ���
		System.out.println(data+"���� �߰� �߾��-----------------------------");
		return arr.size();
	}
}
