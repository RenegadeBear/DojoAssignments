package com.rnc.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class CounterController {
	@RequestMapping("")
	public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if (count == null) {
			count = 0;
		}
		count ++;
		session.setAttribute("count", count);
		System.out.println(count);
		return "index.jsp";
	}
	
	@RequestMapping("count")
	public String count(HttpSession session) {
		return "counter.jsp";
	}
}
