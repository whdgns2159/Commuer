package com.tis.ex02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//���� ���ɻ��� Ŭ����
//@Log4j

@Aspect 
public class CommonAspect {
	/**���� �����ϱ� ���� �۵�*/
	@Before("execution(* com.tis.ex02.BizServiceImpl.insertData(..))")
	public void trace1(JoinPoint jp) {
		Signature sign=jp.getSignature();
		System.out.println("before===========================["+sign.toLongString()+"]");
		
	}
	
	/**������ ���� �ȳ��� ���� ������ �� �Ŀ� �۵�*/
	@After("execution(* com.tis.ex02.BizServiceImpl.insertData(..))")
	public void trace2(JoinPoint jp) {
		Signature sign=jp.getSignature();
		System.out.println("after===========================["+sign.toLongString()+"]");
		
	}
	
	/**��� ���� ���� �� �۵�*/
	@AfterReturning(value="execution(* com.tis.ex02.BizServiceImpl.insertData(..))", returning="result")
	public void trace3(JoinPoint jp, Integer result) {
		Signature sign=jp.getSignature();
		System.out.println("after returning===========================["+sign.toLongString()+"]");
		System.out.println("��ȯ��: "+result+"=================");
	}
	
	/**����������*/
	@AfterThrowing(value="execution(* com.tis.ex02.BizServiceImpl.insertData(..))", throwing="ex")
	public void trace4(JoinPoint jp, Exception ex) {
		Signature sign=jp.getSignature();
		System.out.println("after throwing===========================["+sign.toLongString()+"]");
		if(ex!=null) {
			System.out.println(ex);
		}
	}
	
	@Around("execution(* com.tis.ex02.BizServiceImpl.insertData(..))")
	public Integer trace5(ProceedingJoinPoint jpoint) {
		String s1=jpoint.getSignature().toShortString();
		System.out.println("around(before)==="+s1+"===========");
		Object[] args=jpoint.getArgs();
		if(args!=null) {
			for(Object argv: args) {
				System.out.println("�Ķ���Ͱ�: "+argv.toString());
			}
		}
		long start=System.nanoTime();
		long end=0;
		//target�� �޼ҵ带 ȣ��
		try {
			Integer n = (Integer)jpoint.proceed();
			
			end=System.nanoTime();
			return n;
		} catch (Throwable ex) {
			ex.printStackTrace();
			return null;
		}finally {
			System.out.println("around(after)==="+s1+"===========");
			System.out.println(s1+" �� ����ð�: "+(end-start));
		}
	}
	
}
