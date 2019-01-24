package com.tis.ex01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
//공통 관심사항 클래스
//@Log4j
public class CommonAspect {
	public void trace1(JoinPoint jp) {
		Signature sign=jp.getSignature();
		System.out.println("before===========================["+sign.toLongString()+"]");
		
	}
	public void trace2(JoinPoint jp) {
		Signature sign=jp.getSignature();
		System.out.println("after===========================["+sign.toLongString()+"]");
		
	}
	public void trace3(JoinPoint jp, Integer result) {
		Signature sign=jp.getSignature();
		System.out.println("after returning===========================["+sign.toLongString()+"]");
		System.out.println("반환값: "+result+"=================");
	}
	public void trace4(JoinPoint jp, Exception ex) {
		Signature sign=jp.getSignature();
		System.out.println("after throwing===========================["+sign.toLongString()+"]");
		if(ex!=null) {
			System.out.println(ex);
		}
	}
	
	public Integer trace5(ProceedingJoinPoint jpoint) {
		String s1=jpoint.getSignature().toShortString();
		System.out.println("around(before)==="+s1+"===========");
		Object[] args=jpoint.getArgs();
		if(args!=null) {
			for(Object argv: args) {
				System.out.println("파라미터값: "+argv.toString());
			}
		}
		long start=System.nanoTime();
		long end=0;
		//target의 메소드를 호출
		try {
			Integer n = (Integer)jpoint.proceed();
			
			end=System.nanoTime();
			return n;
		} catch (Throwable ex) {
			ex.printStackTrace();
			return null;
		}finally {
			System.out.println("around(after)==="+s1+"===========");
			System.out.println(s1+" 의 수행시간: "+(end-start));
		}
	}
	
}
