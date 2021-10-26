package com.team3.pms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.pms.mybatis.T3MemberDao;

@Controller

public class TestController {
	
	@Autowired
	public T3MemberDao memberDao;
	
	@RequestMapping("/")
	public String root(){
		return "redirect:dashboard";
	}	
	
	@GetMapping("/testlist")
	public String getList(Model model) {
		
		model.addAttribute("members",memberDao.list());
		return "memberlist";
	}
	

	

}
