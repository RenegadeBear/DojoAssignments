package com.rnc.ninjagold.controllers;

//import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGold {
	@RequestMapping("")
	public String index(HttpSession session) {
		Integer yourgold = (Integer) session.getAttribute("yourgold");
		if (yourgold == null) {
			yourgold = 0;
		}
		session.setAttribute("yourgold", yourgold);
//		System.out.println(yourgold);
		String log = (String) session.getAttribute("log");
		if (log == null){
			session.setAttribute("log", "");
		}
//		session.setAttribute("log","");
//		ArrayList<String> msg = (ArrayList<String>) session.getAttribute("msg");
//		session.setAttribute("msg", new ArrayList<String>());
		return "index.jsp";

	}
	
	public int randomWithRange(int min, int max) {
		   int range = (max - min) + 1;     
		   return (int)(Math.random() * range) + min;
		}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(path="/process_money", method=RequestMethod.POST)
	public String process_money(HttpSession session, @RequestParam(value="place") String place) {
//		System.out.println(place);
		String log = (String) session.getAttribute("log");
		Integer gold =0;
		if (place.equals("farm")) {
			gold = randomWithRange(10,20);
		}
		if (place.equals("cave")) {
			gold = randomWithRange(5,10);
		}
		if (place.equals("house")) {
			gold = randomWithRange(2,5);
		}
		if (place.equals("casino")) {
			gold = randomWithRange(-50,50);
		}
		if (place.equals("spa")) {
			gold = randomWithRange(-20,-5);
		}
		Integer yourgold = (Integer) session.getAttribute("yourgold");
		session.setAttribute("yourgold", (yourgold + gold));
		String earnings = Integer.toString(gold);
		Date now = new Date();
		if (gold > 0) {
			log = "<p style= 'color:green;'>Earned " + earnings + " golds from the "+place+". ("+ now+ ")</p>" + log;
//			ArrayList<String> x = (ArrayList<String>) session.getAttribute("msg");
//			x.add(log_msg);
//			session.setAttribute("msg", x);
		}
		else {
			log = "<p style= 'color:red;'>Entered "+place+" and lost"+earnings+" golds... Ouch! ("+now+")</p>" + log;
		}
//		msg.add(log_msg);
//		session.setAttribute("msg", msg);
		session.setAttribute("log", log);
//		session.setAttribute("log", (String)session.getAttribute("log")+log+"\r\n");
//		System.out.println(session.getAttribute("log"));
//		model.addAttribute("log", log);
		return "redirect:/";
	}


	
}
