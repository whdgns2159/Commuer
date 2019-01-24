package com.tis.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringAOPTest {

	public static void main(String[] args) {
		ApplicationContext ctx=new GenericXmlApplicationContext("classpath:spring/aop-context.xml");
	
		BizService bs=ctx.getBean("obj",BizService.class);
		//핵심 로직 메소드 호출
		bs.insertData("게시글 1을 등록합니다.");
	}

}
