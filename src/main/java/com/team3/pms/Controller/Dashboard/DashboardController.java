package com.team3.pms.Controller.Dashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.pms.Service.Dashboard.DashboardService;
import com.team3.pms.VO.Member.CustomUser;

@Controller
public class DashboardController {
	
	@Autowired
	private DashboardService dService;
	
	@RequestMapping("/main")
	public String MainPage() {
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard")
	public String Dashboard(Model d, Authentication auth) {
		CustomUser member = (CustomUser)auth.getPrincipal();
		d.addAttribute("Dash3_10", dService.getDash3(10));
		d.addAttribute("Dash3_20", dService.getDash3(20));
		d.addAttribute("Dash3_40", dService.getDash3(40));
		d.addAttribute("Dash2", dService.getDash2());
		d.addAttribute("Dash1", dService.getDash1());
		d.addAttribute("ProjectList", dService.getProjectList(member.getEmp_cd_pk()));
		d.addAttribute("Auth", member.getAuthorities());
		return "dashboard/charts";
	}
}
