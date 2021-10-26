package com.team3.pms.Controller.MyPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.pms.Service.MyPage.MyCalendarService;


@Controller
public class MyCalendarController {
	@Autowired
	private MyCalendarService service;
	// http://localhost:7080/springweb/calendar.do
	@RequestMapping("/calendar")
	public String calendar() {
		
		return "MyPage/calendar";
	}
}
