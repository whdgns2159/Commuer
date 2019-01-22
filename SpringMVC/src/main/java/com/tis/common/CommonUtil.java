package com.tis.common;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class CommonUtil {

	public String addMsgLoc(Model m, String msg, String loc) {
		m.addAttribute("message",msg);
		m.addAttribute("loc",loc);
		return "memo/message";
	}
	
	public String addMsgBack(Model m, String msg) {
		m.addAttribute("message",msg);
		m.addAttribute("loc","javascript:history.back()");
		return "memo/message";
	}
}
