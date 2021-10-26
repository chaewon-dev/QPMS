package com.team3.pms.Controller.RiskPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.team3.pms.Service.RiskPage.RiskService;
import com.team3.pms.Service.project.ProjectService;
import com.team3.pms.VO.risk.Risk;

@Controller
public class RiskController {

	@Autowired
	private RiskService riskSer;
	
	@RequestMapping("/RiskList")
	public String riskPage(String riskpgs_cd, Model d){
		d.addAttribute("riskLisk", riskSer.riskList(riskpgs_cd));
		
		// 오류 확인
		/*
		 * ArrayList<Risk> r = riskSer.riskList(projectCd); for(Risk x : r) {
		 * System.out.println(x); }
		 */
		d.addAttribute("riskpgsList", riskSer.riskpgsList());
		
		
		return "RiskPage/RiskList";
	}
	
	

	@Autowired
	public ProjectService projectService;
	
	@RequestMapping("/RiskRegPage")
	public String riskRegPage(Risk risk, Model d){
		
		// 프로젝트 연결
		d.addAttribute("projects", projectService.projectList());
		// 진행상황 연결
		d.addAttribute("riskpgsList", riskSer.riskpgsList());
		// 리소스 연결
		d.addAttribute("riskResourceList", riskSer.riskResourceList());
		// 리스크 유형
		d.addAttribute("riskTypeList", riskSer.riskTypeList());
		// 리스크 대응
		d.addAttribute("riskActionList", riskSer.riskActionList());
		
		return "RiskPage/RiskRegPage";
	}

	
	
	
	@RequestMapping("/RiskInsert")
	public RedirectView riskInsert(Risk risk, Model d, MultipartFile report){
		riskSer.riskInsert(risk, report);
		return new RedirectView("/RiskList");
	}
	
	
	
	@RequestMapping("/RiskDetailPage")
	public String RiskDetailPage(@RequestParam("risk_cd") String risk_cd, Model d) {
		
		d.addAttribute("projects", projectService.projectList());
		
		d.addAttribute("riskpgsList", riskSer.riskpgsList());
		
		d.addAttribute("riskResourceList", riskSer.riskResourceList());
		
		d.addAttribute("riskTypeList", riskSer.riskTypeList());

		d.addAttribute("riskActionList", riskSer.riskActionList());
		
		
		d.addAttribute("RiskDetailPage", riskSer.riskDetailPage(risk_cd));
		return "RiskPage/RiskDetailPage";
	}
	
	@RequestMapping("/RiskUpdate")
	public RedirectView riskUpdate(Risk risk, Model d){
		// @RequestParam(required = false) MultipartFile report
		riskSer.riskUpdate(risk);
		
		return new RedirectView("/RiskDetailPage?risk_cd="+risk.getRisk_cd());
	}
	
	@RequestMapping("/RiskDelete")
	public RedirectView RiskDelete(@RequestParam("risk_cd") String risk_cd, Model d){
		riskSer.riskDelete(risk_cd);
		return new RedirectView("/RiskList");
	}
	
	@RequestMapping("/RiskFileDownload")
	public RedirectView download(String filePath, HttpServletResponse response) throws Exception {
        try {
        	
        	String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\"+filePath; // 경로에 접근할 때 역슬래시('\') 사용
        	
        	File file = new File(path);
        	response.setHeader("Content-Disposition", "attachment;filename=" + file.getName()); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
        	
        	FileInputStream fileInputStream = new FileInputStream(path); // 파일 읽어오기 
        	OutputStream out = response.getOutputStream();
        	
        	int read = 0;
                byte[] buffer = new byte[1024];
                while ((read = fileInputStream.read(buffer)) != -1) { // 1024바이트씩 계속 읽으면서 outputStream에 저장, -1이 나오면 더이상 읽을 파일이 없음
                    out.write(buffer, 0, read);
                }
                
        } catch (Exception e) {
            throw new Exception("download error");
        }

		return new RedirectView("/RiskList");
	}
        
}
