package com.tis.ex02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

//import lombok.extern.log4j.Log4j;

//@Log4j
@Service
public class BizServiceImpl implements BizService {

	List<String> arr=new ArrayList<>();
	//비즈니스계층의 클래스파일
	@Override
	public int insertData(String data) {
		
		System.out.println("==핵심 로직을 수행하는 메소드insertDate()===");
		/*int n=Integer.parseInt(data);*/
		arr.add(data);
		
		
		//[1] 핵심 로직을 수행하는 곳 
		//[2] 공통 관심사항: 로깅, 보안, 트랜잭션 등등
		System.out.println(data+"글을 추가 했어요-----------------------------");
		return arr.size();
	}
}
