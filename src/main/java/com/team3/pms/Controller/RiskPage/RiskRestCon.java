package com.team3.pms.Controller.RiskPage;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.pms.Service.RiskPage.RiskService;
import com.team3.pms.VO.risk.Risk;

@RestController
public class RiskRestCon {

	@Autowired
	private RiskService riskSer;
	
	// json 처리
	@RequestMapping("/RiskListJson")
	public ArrayList<Risk> riskPageJson(String riskpgs_cd, Model d){
		d.addAttribute("riskLisk", riskSer.riskList(riskpgs_cd));
		d.addAttribute("riskpgsList", riskSer.riskpgsList());
		return riskSer.riskList(riskpgs_cd) ;
	}

	
}
