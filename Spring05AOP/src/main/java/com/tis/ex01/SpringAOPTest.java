package com.tis.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringAOPTest {

	public static void main(String[] args) {
		ApplicationContext ctx=new GenericXmlApplicationContext("classpath:spring/aop-context.xml");
	
		BizService bs=ctx.getBean("obj",BizService.class);
		//�ٽ� ���� �޼ҵ� ȣ��
		bs.insertData("�Խñ� 1�� ����մϴ�.");
	}

}
