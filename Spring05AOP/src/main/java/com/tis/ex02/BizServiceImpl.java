package com.tis.ex02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

//import lombok.extern.log4j.Log4j;

//@Log4j
@Service
public class BizServiceImpl implements BizService {

	List<String> arr=new ArrayList<>();
	//����Ͻ������� Ŭ��������
	@Override
	public int insertData(String data) {
		
		System.out.println("==�ٽ� ������ �����ϴ� �޼ҵ�insertDate()===");
		/*int n=Integer.parseInt(data);*/
		arr.add(data);
		
		
		//[1] �ٽ� ������ �����ϴ� �� 
		//[2] ���� ���ɻ���: �α�, ����, Ʈ����� ���
		System.out.println(data+"���� �߰� �߾��-----------------------------");
		return arr.size();
	}
}
