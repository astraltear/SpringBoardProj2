package com.youngjee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/responsebodysample/*")
public class ResponseBodySampleController {

	@ResponseBody
	@RequestMapping("/hello")
	public String sayHello() {
		return "ResponseBody Hello";
	}
	
}

