package com.team3.pms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.pms.mybatis.T3MemberDao;

@Controller

public class TestController2 {
	
	@RequestMapping("/frame")
	public String root2(){
		return "dashboard/charts";
	}

}
