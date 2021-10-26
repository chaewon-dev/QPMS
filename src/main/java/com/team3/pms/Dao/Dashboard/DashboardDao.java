package com.team3.pms.Dao.Dashboard;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.VO.Dashboard.DashboardDto;
import com.team3.pms.VO.Dashboard.ProjectListDto;

@Mapper
public interface DashboardDao {
	
	public List<DashboardDto> getDash1();
	
	public List<DashboardDto> getDash2();
	
	public List<DashboardDto> getDash3(int project_state_pk);
	
	public List<ProjectListDto> getProjectList(String emp_cd_pk);
	
}
