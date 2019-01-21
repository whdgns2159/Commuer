package com.tis.sample;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;
//setter,getter자동으로 만들어주고, 기본생성자 자동으로 만들어준다
@Component
@Data
@Setter
public class Emp {
	private String name;
	private String dept;
	private int salary;
	
}
