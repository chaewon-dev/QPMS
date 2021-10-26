package com.team3.pms.Service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.pms.Controller.project.form.ProjectRegForm;
import com.team3.pms.Controller.project.form.ProjectUpdateForm;
import com.team3.pms.Controller.project.form.ResourceRoleGetForm;
import com.team3.pms.Controller.project.form.TaskProjectSaveForm;
import com.team3.pms.Controller.project.form.TaskSaveForm;
import com.team3.pms.Controller.project.form.TaskUpdateForm;
import com.team3.pms.Dao.project.CostListDTO;
import com.team3.pms.Dao.project.DeptDTO;
import com.team3.pms.Dao.project.PMSaveDTO;
import com.team3.pms.Dao.project.ProjectDTO;
import com.team3.pms.Dao.project.ProjectDao;
import com.team3.pms.Dao.project.ProjectDetailDTO;
import com.team3.pms.Dao.project.ProjectStateDTO;
import com.team3.pms.Dao.project.ProjectgetPMListDTO;
import com.team3.pms.Dao.project.ResourceDeptSummaryChartDTO;
import com.team3.pms.Dao.project.ResourceDetailDTO;
import com.team3.pms.Dao.project.ResourceUpdateDTO;
import com.team3.pms.Dao.project.TaskDTO;
import com.team3.pms.Dao.project.TaskStateSummaryDTO;

@Service
public class ProjectService {
	
	@Autowired
	public ProjectDao projectDao;
	
	@Transactional
	public List<ProjectDTO> projectListByEmpCdPk(String emp_cd_pk) {
		return projectDao.projectListByEmpCdPk(emp_cd_pk);
	}
	
	@Transactional
	public List<ProjectDTO> projectList() {
		return projectDao.projectList();
	}
	
	@Transactional 
	public void saveProject(ProjectRegForm regForm) {
		projectDao.saveProject(regForm);	
		String maxId = projectDao.getProjectMaxId();	
		projectDao.savePM(new PMSaveDTO(maxId, regForm.getProjectPM()));	
	}
	
	@Transactional
	public List<DeptDTO> deptList(){ 
		return projectDao.deptList();
	}
	 
	@Transactional
	public List<TaskDTO> callTasks(String projectId) {
		return projectDao.callTasks(projectId);
	}

	

	@Transactional
	public String getMaxId() {
		return projectDao.getMaxId();
	}
	
	@Transactional
	public void saveTask(TaskSaveForm taskSaveForm, String projectId) {
		TaskProjectSaveForm taskProjectSaveForm = new TaskProjectSaveForm(
					taskSaveForm.getApprover(),
					taskSaveForm.getText(),
					taskSaveForm.getState(),
					taskSaveForm.getStart_date(),
					taskSaveForm.getEnd_date(),
					taskSaveForm.getProgress(),
					taskSaveForm.getType(),
					taskSaveForm.getDescription(),
					taskSaveForm.getParent(),
					taskSaveForm.getSortorder(),
					projectId,
					taskSaveForm.getManager()
				);
		projectDao.saveTask(taskProjectSaveForm);
	}
	
	@Transactional
	public void updateTask(TaskUpdateForm taskUpdateForm) {
		projectDao.updateTask(taskUpdateForm);
		
	}

	@Transactional
	public void deleteTask(String taskId) {
		projectDao.deleteTask(taskId);
	}

	@Transactional
	public String findProjectName(String projectId) {
		
		return projectDao.findProjectName(projectId);
	}

	@Transactional
	public List<ProjectgetPMListDTO> getPMList(int deptData) {
		return projectDao.getPMList(deptData);
	}

	@Transactional
	public ProjectDetailDTO getProjectDetail(String projectId) {
		return projectDao.getProjectDetail(projectId);
	}

	@Transactional
	public List<ProjectStateDTO> projectStateList() {
		return projectDao.projectStateList();
	}

	@Transactional
	public ResourceDetailDTO getCurrentPM(String projectId) {
		// TODO Auto-generated method stub
		return projectDao.getCurrentPM(projectId);
	}

	@Transactional
	public void deleteProject(String projectId) {
		projectDao.deleteProject(projectId);
	}

	@Transactional
	public void updateProject(ProjectUpdateForm updateForm) {
		projectDao.updateProject(updateForm);
	}

	@Transactional
	public void updateProjectPM(ProjectUpdateForm updateForm) {
		//cur -> role -> 1, updateResourceByProjectEmp
		projectDao.updateResourceByProjectEmp(
				new ResourceUpdateDTO(updateForm.getCur_emp_cd_pk(), updateForm.getProject_pk(), 1)
			);
		
		//new -> role -> 5 수정, 존재하지 않으면 추가, findResourceByProjectEmp
		System.out.println("길이: "+findResourceByProjectEmp(new PMSaveDTO(updateForm.getProject_pk(), updateForm.getNew_emp_cd_pk())).size());
		if(findResourceByProjectEmp(new PMSaveDTO(updateForm.getProject_pk(), updateForm.getNew_emp_cd_pk())).size() != 0) {
			
			projectDao.updateResourceByProjectEmp(
					new ResourceUpdateDTO(updateForm.getNew_emp_cd_pk(), updateForm.getProject_pk(), 5)
				);
		}else {
			projectDao.savePM(new PMSaveDTO(updateForm.getProject_pk(), updateForm.getNew_emp_cd_pk()));	//리소스 추가
			projectDao.updateResourceByProjectEmp(
					new ResourceUpdateDTO(updateForm.getNew_emp_cd_pk(), updateForm.getProject_pk(), 5)		//추가한 뒤 role update
				);
		}
	}
	
	@Transactional
	public List<String> findResourceByProjectEmp(PMSaveDTO dto){
		return projectDao.findResourceByProjectEmp(dto);
	}

	@Transactional
	public String findAuthRoleByEmpCdPk(String emp_cd_pk) {
		return projectDao.findAuthRoleByEmpCdPk(emp_cd_pk);
	}

	@Transactional
	public String findResourceRoleByEmpCdPk(ResourceRoleGetForm resourceRoleGetForm) {
		return projectDao.findResourceRoleByEmpCdPk(resourceRoleGetForm);
	}

	@Transactional
	public List<TaskStateSummaryDTO> taskSatetSummaryChart(String projectId) {
		return projectDao.taskSatetSummaryChart(projectId); 
	}

	@Transactional
	public List<ResourceDeptSummaryChartDTO> resourceDeptSummaryChart(String projectId) {
		
		return projectDao.resourceDeptSummaryChart(projectId);
	}

	@Transactional
	public List<CostListDTO> projectCost(String projectId) {
		return projectDao.projectCost(projectId);
	}

}
