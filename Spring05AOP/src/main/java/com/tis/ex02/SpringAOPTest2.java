package com.tis.ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringAOPTest2 {

	public static void main(String[] args) {
		ApplicationContext ctx=new GenericXmlApplicationContext("classpath:spring/aop-context2.xml");
		 BizService bs=ctx.getBean("bizServiceImpl", BizService.class);
		 bs.insertData("게시글 2 를 등록합니다");
	}

}
