package com.tis.myapp;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tis.sample.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//단위테스트(Unit Test)하는 클래스
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j //로그를 띄워주는 어노테이션
public class SampleTests {
	
	@Setter(onMethod_= {@Autowired})
	private Service rest;
	
	//@Test: 테스트 대상을 표시하는 어노테이션
	@Test
	public void testService() {
		//rest가 null이 아니어야만 테스트가 성공한다는 것을 의미
		log.info(rest);
		log.info("-------------------");
		log.info(rest.getEmp());
	}
}
