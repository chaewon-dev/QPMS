package com.team3.pms.Controller.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.pms.Controller.project.form.ProjectRegForm;
import com.team3.pms.Controller.project.form.ProjectUpdateForm;
import com.team3.pms.Controller.project.form.ResourceRoleGetForm;
import com.team3.pms.Controller.project.form.TaskForm;
import com.team3.pms.Controller.project.form.TaskSaveForm;
import com.team3.pms.Controller.project.form.TaskUpdateForm;
import com.team3.pms.Dao.project.DeptDTO;
import com.team3.pms.Dao.project.ProjectDetailDTO;
import com.team3.pms.Dao.project.ProjectStateDTO;
import com.team3.pms.Dao.project.ProjectgetPMListDTO;
import com.team3.pms.Dao.project.ResourceDeptSummaryChartDTO;
import com.team3.pms.Dao.project.TaskDTO;
import com.team3.pms.Dao.project.TaskStateSummaryDTO;
import com.team3.pms.Service.ResourcePage.ResourceService;
import com.team3.pms.Service.project.ProjectService;
import com.team3.pms.VO.Member.CustomUser;

@Controller
public class ProjectController {
	
	@Autowired
	public ProjectService projectService;
	@Autowired
	ResourceService rsService;
	
	//프로젝트 리스트 화면
	@GetMapping("/project")
	public String projectList(Model model, Authentication auth) {
		CustomUser member = (CustomUser) auth.getPrincipal();
		System.out.println(member.getEmp_cd_pk());
		//findAuthRoleByEmpCdPk -> emp_cd_pk로 emp_auth_pk값 조회
		String authRole = projectService.findAuthRoleByEmpCdPk(member.getEmp_cd_pk());
		System.out.println(authRole);
		if(authRole.equals("10")) {	//authRole이 10인경우 -> Admin처리
			//모든 항목 조회
			model.addAttribute("projects",projectService.projectList());
		}else {
			//Admin이 아닌 경우 -> 리소스에 포함된 항목만 조회
			model.addAttribute("projects",projectService.projectListByEmpCdPk(member.getEmp_cd_pk()));
		}
		
		
		//emp_cd_pk로 role 조회 후 10이면 admin -> 모든 목록 조회
		
		// 10이 아니면 해당 emp_cd_pk가 리소스에 투입된 project 목록만 조회
		return "project/projectList";
	}
	
	//프로젝트 등록 화면
	@GetMapping("/project/create")
	public String projectReg() {
		
		return "project/projectReg";
	}
	


	
	//프로젝트 요약정보 화면
	@GetMapping("/project/summary/{projectId}")
	public String projectSummary(@PathVariable String projectId, Model model, Authentication auth) {
		CustomUser member = (CustomUser) auth.getPrincipal();
		String authRole = projectService.findAuthRoleByEmpCdPk(member.getEmp_cd_pk());
		model.addAttribute("authRole",authRole);
		
		String resourceRole = projectService.findResourceRoleByEmpCdPk(new ResourceRoleGetForm(projectId, member.getEmp_cd_pk()));
		model.addAttribute("resourceRole",resourceRole);

		if(!authRole.equals("10") && resourceRole == null) {
			return "error/404";	//admin이 아니고 resource 할당이 되어있지 않으면 404에러 처리
		}
		
		model.addAttribute("projectId",projectId);
		model.addAttribute("projectName",projectService.findProjectName(projectId));
		
		ProjectDetailDTO projectDetail = projectService.getProjectDetail(projectId);
		List<DeptDTO> deptList = projectService.deptList();
		for(DeptDTO x : deptList) {
			if(x.getEmp_dept_pk() == projectDetail.getEmp_dept_pk()) {
				String dept_name = x.getDept_name();
				model.addAttribute("dept_name", dept_name);
				break;
			}
		}
		
		model.addAttribute("projectDetail", projectDetail);
		//PM정보
		model.addAttribute("currentPM", projectService.getCurrentPM(projectId));
		List<ProjectStateDTO> projectStateList = projectService.projectStateList();
		for(ProjectStateDTO x : projectStateList) {
			if(x.getProject_state_pk() == projectDetail.getProject_state_pk()) {
				String project_state_nm = x.getProject_state_nm();
				model.addAttribute("project_state_nm", project_state_nm);
			}
		}
		List<TaskDTO> tasks = projectService.callTasks(projectId);
		if(tasks.size() > 0) {
			float sum = 0;
			for(TaskDTO x : tasks) {
				sum += x.getTask_progress();
			}
			model.addAttribute("progress_rate", Math.round(sum/tasks.size()*1000)/10.0 + " %");
		}else {
			model.addAttribute("progress_rate", "0 %");
		}
		
		
		return "project/projectSummary";
	}

	
	//프로젝트 기본정보 화면
	@GetMapping("/project/basic/{projectId}")
	public String projectBasic(@PathVariable String projectId, Model model, Authentication auth) {
		CustomUser member = (CustomUser) auth.getPrincipal();
		String authRole = projectService.findAuthRoleByEmpCdPk(member.getEmp_cd_pk());
		model.addAttribute("authRole",authRole);
		
		String resourceRole = projectService.findResourceRoleByEmpCdPk(new ResourceRoleGetForm(projectId, member.getEmp_cd_pk()));
		model.addAttribute("resourceRole",resourceRole);

		if(!authRole.equals("10") && resourceRole == null) {
			return "error/404";	//admin이 아니고 resource 할당이 되어있지 않으면 404에러 처리
		}
		
		model.addAttribute("projectId",projectId);
		model.addAttribute("projectName",projectService.findProjectName(projectId));
		model.addAttribute("projectDetail", projectService.getProjectDetail(projectId));
		model.addAttribute("deptList", projectService.deptList());
		//PM정보
		model.addAttribute("currentPM", projectService.getCurrentPM(projectId));
		model.addAttribute("projectStateList", projectService.projectStateList());
		return "project/projectBasic";
	}
	
	//프로젝트 리소스 화면
	@GetMapping("/project/resource/{projectId}")
	public String projectResource(@PathVariable String projectId, Model model, Authentication auth) {
		CustomUser member = (CustomUser) auth.getPrincipal();
		String authRole = projectService.findAuthRoleByEmpCdPk(member.getEmp_cd_pk());
		model.addAttribute("authRole",authRole);
		
		String resourceRole = projectService.findResourceRoleByEmpCdPk(new ResourceRoleGetForm(projectId, member.getEmp_cd_pk()));
		model.addAttribute("resourceRole",resourceRole);

		if(!authRole.equals("10") && resourceRole == null) {
			return "error/404";	//admin이 아니고 resource 할당이 되어있지 않으면 404에러 처리
		}
		
		model.addAttribute("projectId",projectId);
		model.addAttribute("projectName",projectService.findProjectName(projectId));
		model.addAttribute("currentPM", projectService.getCurrentPM(projectId));
		return "project/projectResource";
	}
	
	//프로젝트 WBS 화면
	@GetMapping("/project/wbs/{projectId}")
	public String projectWBS(@PathVariable String projectId, Model model, Authentication auth) {
		
		CustomUser member = (CustomUser) auth.getPrincipal();
		String authRole = projectService.findAuthRoleByEmpCdPk(member.getEmp_cd_pk());
		model.addAttribute("authRole",authRole);
		
		//findResourceRoleByEmpCdPk
		String resourceRole = projectService.findResourceRoleByEmpCdPk(new ResourceRoleGetForm(projectId, member.getEmp_cd_pk()));
		model.addAttribute("resourceRole",resourceRole);
		
		//1. admin인지 확인 (role = 10) -> resourceRole이 null이어도 조회 가능
		//2. PM인지 확인 (role = 5)
		//3. admin, PM 둘 다 아니면 수정권한 없음. -> resourceRole이 null이면 조회 불가
		if(!authRole.equals("10") && resourceRole == null) {
			return "redirect:/project";	//admin이 아니고 resource 할당이 되어있지 않으면 404에러 처리
		}
			
		model.addAttribute("projectId",projectId);
		model.addAttribute("projectName",projectService.findProjectName(projectId));
		return "project/projectWBS";
	}
	
	//프로젝트 비용 화면
	@GetMapping("/project/cost/{projectId}")
	public String projectCost(@PathVariable String projectId, Model model, Authentication auth) {
		CustomUser member = (CustomUser) auth.getPrincipal();
		String authRole = projectService.findAuthRoleByEmpCdPk(member.getEmp_cd_pk());
		model.addAttribute("authRole",authRole);
		
		String resourceRole = projectService.findResourceRoleByEmpCdPk(new ResourceRoleGetForm(projectId, member.getEmp_cd_pk()));
		model.addAttribute("resourceRole",resourceRole);

		if(!authRole.equals("10") && resourceRole == null) {
			return "error/404";	//admin이 아니고 resource 할당이 되어있지 않으면 404에러 처리
		}
		
		model.addAttribute("projectId",projectId);
		model.addAttribute("projectName",projectService.findProjectName(projectId));
		
		model.addAttribute("costList",projectService.projectCost(projectId));
		
		return "project/projectCost";
	}
		
		
	
	
	//-----------------------------project api-----------------------------
	// 프로젝트 등록 api
	@PostMapping("/project")
	@ResponseBody
	public void saveProject(@RequestBody ProjectRegForm regForm) {
		projectService.saveProject(regForm);
		rsService.regRscPm(regForm);
	}
	
	// 프로젝트 삭제 api
	@DeleteMapping("/project/{projectId}")
	@ResponseBody
	public void deleteProject(@PathVariable String projectId) {
		projectService.deleteProject(projectId);
		rsService.deleteRscProject(projectId);
	}
	
	@PutMapping("/project/{projectId}")
	@ResponseBody
	public void updateProject(@PathVariable String projectId, @RequestBody ProjectUpdateForm updateForm) {
		projectService.updateProject(updateForm);
		
		projectService.updateProjectPM(updateForm);
		//cur -> role -> 1
		//new -> role -> 5 수정, 존재하지 않으면 추가
		System.out.println(updateForm.getCur_emp_cd_pk());
		System.out.println(updateForm.getNew_emp_cd_pk());
		//PM수정 및 추가 
		
		rsService.updateRscProject(updateForm);
	}
	
	// 등록 화면에서 PM List 표시
	@GetMapping("/api/PMList/{deptData}")
	@ResponseBody
	public List<ProjectgetPMListDTO> getPMList(@PathVariable int deptData) {
		return projectService.getPMList(deptData);
	}
	
	//-----------------------------task api-----------------------------
	
	@GetMapping("/api/task/maxId")
	@ResponseBody
	public String getMaxId() {
		return projectService.getMaxId();
	}
	
	
	@GetMapping("/api/wbs/{projectId}")
	@ResponseBody
	public List<TaskForm> callTasks(@PathVariable String projectId){
		List<TaskDTO> temp = projectService.callTasks(projectId);
		System.out.println("tasks.size(): "+temp.size());
		
		List<TaskForm> taskFormList = new ArrayList<>();
		for(int i=0; i<temp.size(); i++) {
			taskFormList.add(new TaskForm(
				temp.get(i).getTask_pk(),
				temp.get(i).getTask_approver(),
				temp.get(i).getTask_nm(),
				temp.get(i).getTask_state(),
				temp.get(i).getTask_start_dt(),
				temp.get(i).getTask_comp_dt(),
				temp.get(i).getTask_progress(),
				temp.get(i).getTask_type(),
				temp.get(i).getTask_description(),
				temp.get(i).getTask_parent(),
				temp.get(i).getTask_sortorder(),
				temp.get(i).getTask_manager()
			));
		}
		
		
		return taskFormList;
	}
	
	@GetMapping("/api/summary/{projectId}/task/chart")
	@ResponseBody
	public List<TaskStateSummaryDTO> taskSatetSummaryChart(@PathVariable String projectId){
		return projectService.taskSatetSummaryChart(projectId);
		
	}
	
	@GetMapping("/api/summary/{projectId}/resource/chart")
	@ResponseBody
	public List<ResourceDeptSummaryChartDTO> resourceDeptSummaryChart(@PathVariable String projectId){
		return projectService.resourceDeptSummaryChart(projectId);
	}
	
	@PostMapping("/api/wbs/{projectId}/task")
	@ResponseBody
	public void addTask(@RequestBody TaskSaveForm taskSaveForm, 
			@PathVariable String projectId) {
	
		taskSaveForm.setStart_date(taskSaveForm.getStart_date().split(" ")[0]);
		taskSaveForm.setEnd_date(taskSaveForm.getEnd_date().split(" ")[0]);
		if(taskSaveForm.getApprover().length() == 0) {	//approver 공백입력시 null 처리
			taskSaveForm.setApprover(null);
		}
		if(taskSaveForm.getManager().length() == 0) {	//manager 공백입력시 null 처리
			taskSaveForm.setManager(null);
		}
		projectService.saveTask(taskSaveForm, projectId);
		rsService.addRscTask(taskSaveForm, projectId);
		System.out.println("-----ADD TASK-----");
	}
	
	@PutMapping("/api/wbs/{projectId}/task/{taskId}")
	@ResponseBody
	public void updateTask(@RequestBody TaskUpdateForm taskUpdateForm, 
			@PathVariable String taskId, @PathVariable String projectId) {
		//System.out.println("parent: "+taskUpdateForm.getParent());
		taskUpdateForm.setStart_date(taskUpdateForm.getStart_date().split(" ")[0]);
		taskUpdateForm.setEnd_date(taskUpdateForm.getEnd_date().split(" ")[0]);
		taskUpdateForm.setId(taskId);
		taskUpdateForm.setProjectId(projectId);
		if(taskUpdateForm.getApprover().length() == 0) {	//approver 공백입력시 null 처리
			taskUpdateForm.setApprover(null);
		}
		if(taskUpdateForm.getManager().length() == 0) {	//manager 공백입력시 null 처리
			taskUpdateForm.setManager(null);
		}
		projectService.updateTask(taskUpdateForm);
		rsService.updateRscTask(taskUpdateForm);
		System.out.println("-----UPDATE TASK-----");
	}
	
	@DeleteMapping("/api/wbs/{projectId}/task/{taskId}")
	@ResponseBody
	public void deleteTask(@PathVariable String taskId) {
		projectService.deleteTask(taskId);
		rsService.deleteRscTask(taskId);
		System.out.println("-----DELETE TASK-----");
	}
	
	
	
	
	//-----------------------------dept api-----------------------------
	@GetMapping("/api/dept")
	@ResponseBody
	public List<DeptDTO> deptList(){
		return projectService.deptList();
	}

}
