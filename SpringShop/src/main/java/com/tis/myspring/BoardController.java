package com.tis.myspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/input")
	public String boardWrite() {
		return "board/boardWrite";
	}
}
