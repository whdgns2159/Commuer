package com.tis.myapp;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tis.sample.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//�����׽�Ʈ(Unit Test)�ϴ� Ŭ����
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j //�α׸� ����ִ� ������̼�
public class SampleTests {
	
	@Setter(onMethod_= {@Autowired})
	private Service rest;
	
	//@Test: �׽�Ʈ ����� ǥ���ϴ� ������̼�
	@Test
	public void testService() {
		//rest�� null�� �ƴϾ�߸� �׽�Ʈ�� �����Ѵٴ� ���� �ǹ�
		log.info(rest);
		log.info("-------------------");
		log.info(rest.getEmp());
	}
}
