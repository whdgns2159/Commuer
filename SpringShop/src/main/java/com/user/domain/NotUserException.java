package com.user.domain;
/*1. Exception�� ��ӹ޴´�.
 *2. �����ڸ� ����� ���� �޽����� super()�� ���� ����Ѵ� 
 * */

public class NotUserException extends Exception{
	
	public NotUserException() {
		super("ȸ���� �ƴմϴ�");
	}
	public NotUserException(String msg) {
		super(msg);
	}

}
