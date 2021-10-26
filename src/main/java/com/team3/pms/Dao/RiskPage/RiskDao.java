package com.team3.pms.Dao.RiskPage;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.VO.risk.Risk;
import com.team3.pms.VO.risk.RiskAction;
import com.team3.pms.VO.risk.RiskPGS;
import com.team3.pms.VO.risk.RiskResource;
import com.team3.pms.VO.risk.RiskType;

@Mapper
public interface RiskDao {

	public ArrayList<Risk> riskList(String riskpgs_cd);
	public void riskInsert(Risk risk);
	

	public Risk riskDetailPage(String risk_cd);
	
	public void riskUpdate(Risk risk);
	public void riskDelete(String riskNm);
	
	// 등록 셀렉트 리스트-리스크 진행상황
	public ArrayList<RiskPGS> riskpgsList();

	// 등록 셀렉트 리스트-리스크 리소스
	public ArrayList<RiskResource> riskResourceList();
	
	// 등록 셀렉트 리스트- 리스크유형
	public ArrayList<RiskType> riskTypeList();
	
	// 등록 셀렉트 리스트 - 리스크대응
	public ArrayList<RiskAction> riskActionList();
	
}
