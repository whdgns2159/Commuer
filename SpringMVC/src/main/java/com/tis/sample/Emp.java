package com.tis.sample;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data //setter,getter�ڵ����� ������ְ�, �⺻������ �ڵ����� ������ش�
@Setter
public class Emp {
	private String name;
	private String dept;
	private int salary;
	
}
