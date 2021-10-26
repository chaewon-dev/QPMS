package com.team3.pms.Service.RiskPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team3.pms.Dao.RiskPage.RiskDao;
import com.team3.pms.VO.risk.Risk;
import com.team3.pms.VO.risk.RiskAction;
import com.team3.pms.VO.risk.RiskPGS;
import com.team3.pms.VO.risk.RiskResource;
import com.team3.pms.VO.risk.RiskType;

@Service
public class RiskService {
	
	@Autowired
	private RiskDao riskDao;
	
	@Transactional
	public ArrayList<Risk> riskList(String riskpgs_cd){
		if(riskpgs_cd==null) {
			riskpgs_cd = "";
		}
		System.out.println(riskpgs_cd);
		if(riskpgs_cd.equals("null")) {
			riskpgs_cd = "";
		}
		return riskDao.riskList(riskpgs_cd);
	};
	
	@Transactional
	public void riskInsert(Risk risk, MultipartFile report){
		System.out.println("#첨부파일#"+risk.getReport().getOriginalFilename());
		
		
		String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
		
		System.out.println(projectPath);
		// 식별자
		UUID uuid = UUID.randomUUID();
		
		String fileName = uuid+"_"+report.getOriginalFilename();
		
		
		File saveFile = new File (projectPath, fileName);
		
		try {
			report.transferTo(saveFile);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		risk.setRisk_file("files/"+fileName);
		
		riskDao.riskInsert(risk);
	};

	
	
	
	@Transactional
	public Risk riskDetailPage(String risk_cd){
		return riskDao.riskDetailPage(risk_cd);
	};
	
	@Transactional
	public void riskUpdate(Risk risk) {
			// , MultipartFile report
			/*
			 * if(report!=null) { String projectPath = System.getProperty("user.dir") +
			 * "\\src\\main\\resources\\static\\files"; // 식별자 UUID uuid =
			 * UUID.randomUUID(); String fileName = uuid+"_"+report.getOriginalFilename();
			 * 
			 * File saveFile = new File (projectPath, fileName);
			 * 
			 * try { report.transferTo(saveFile);
			 * 
			 * } catch (IllegalStateException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); } risk.setRisk_file("/files/"+fileName); }
			 * 
			 * if(report==null) { risk.setRisk_file("첨부파일 오류 수정중"); }
			 */
		riskDao.riskUpdate(risk);
	}
	
	@Transactional
	public void riskDelete(String risk_cd) {
		riskDao.riskDelete(risk_cd);
	}
	
	@Transactional
	public ArrayList<RiskPGS> riskpgsList() {
		
		return riskDao.riskpgsList();
	}
	
	@Transactional
	public ArrayList<RiskResource> riskResourceList() {
		
		return riskDao.riskResourceList();
	}
	
	@Transactional
	public ArrayList<RiskType> riskTypeList() {
		
		return riskDao.riskTypeList();
	}
	
	@Transactional
	public ArrayList<RiskAction> riskActionList() {
		
		return riskDao.riskActionList();
	}
}
