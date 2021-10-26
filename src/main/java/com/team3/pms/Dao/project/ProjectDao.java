package com.team3.pms.Dao.project;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.Controller.project.form.ProjectRegForm;
import com.team3.pms.Controller.project.form.ProjectUpdateForm;
import com.team3.pms.Controller.project.form.ResourceRoleGetForm;
import com.team3.pms.Controller.project.form.TaskProjectSaveForm;
import com.team3.pms.Controller.project.form.TaskUpdateForm;

@Mapper
public interface ProjectDao {
	List<ProjectDTO> projectListByEmpCdPk(String emp_cd_pk);
	
	List<ProjectDTO> projectList();
	
	void saveProject(ProjectRegForm regForm);
	
	List<DeptDTO> deptList();
	
	List<TaskDTO> callTasks(String projectId);
	
	void saveTask(TaskProjectSaveForm taskProjectSaveForm);

	String getMaxId();

	void updateTask(TaskUpdateForm taskUpdateForm);

	void deleteTask(String taskId);

	String findProjectName(String projectId);

	List<ProjectgetPMListDTO> getPMList(int deptData);

	void savePM(PMSaveDTO SaveDTO);

	String getProjectMaxId();

	ProjectDetailDTO getProjectDetail(String projectId);

	List<ProjectStateDTO> projectStateList();

	ResourceDetailDTO getCurrentPM(String projectId);

	void deleteProject(String projectId);

	void updateProject(ProjectUpdateForm updateForm);

	void updateResourceByProjectEmp(ResourceUpdateDTO resourceUpdateDTO);

	List<String> findResourceByProjectEmp(PMSaveDTO dto);

	String findAuthRoleByEmpCdPk(String emp_cd_pk);

	String findResourceRoleByEmpCdPk(ResourceRoleGetForm resourceRoleGetForm);

	List<TaskStateSummaryDTO> taskSatetSummaryChart(String projectId);

	List<ResourceDeptSummaryChartDTO> resourceDeptSummaryChart(String projectId);

	List<CostListDTO> projectCost(String projectId);
	
	
}
