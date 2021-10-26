package com.team3.pms.Service.Dashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.pms.Dao.Dashboard.DashboardDao;
import com.team3.pms.VO.Dashboard.DashboardDto;
import com.team3.pms.VO.Dashboard.ProjectListDto;

@Service
public class DashboardService {

	@Autowired
	private DashboardDao dDao;
	
	public List<DashboardDto> getDash3(int project_state_pk){
		return dDao.getDash3(project_state_pk);
	}
	public List<DashboardDto> getDash2(){
		return dDao.getDash2();
	}
	public List<DashboardDto> getDash1(){
		return dDao.getDash1();
	}
	public List<ProjectListDto> getProjectList(String emp_cd_pk){
		return dDao.getProjectList(emp_cd_pk);
	}
}
