package com.tis.sample;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;
//setter,getter�ڵ����� ������ְ�, �⺻������ �ڵ����� ������ش�
@Component
@Data
@Setter
public class Emp {
	private String name;
	private String dept;
	private int salary;
	
}
