package com.tis.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	//��ûURL����
	@RequestMapping("/test")
	public String mytest(Model model) {
		
		model.addAttribute("msg","���� ���� �Ǽ���");
		//req.addAttribute("msg","���� ���� �Ǽ���");�� ����
		//������������ Model �Ǵ� ModelMap, ModelAndView��ü��
		//�ַ� �����Ѵ�.
		
		return "sample";//�� �̸��� ���ڿ��� ��ȯ�Ѵ�.
		/*servlet-context.xml�� ������ InternalResourceViewResolver
		 * ���� ���̸� �տ� ���ξ�(WEB-INF/views)�� ���̰�
		 * ���̾�(.jsp)�� �ٿ� ���������� ã�ư����� �Ѵ�.
		 * 
		 * /WEB-INF/views/sample.jsp
		 * */
	}
}
