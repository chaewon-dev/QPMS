package com.team3.pms.Controller.project;

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

import com.team3.pms.Controller.project.form.CostSaveForm;
import com.team3.pms.Controller.project.form.ResourceRoleGetForm;
import com.team3.pms.Service.project.ProjectCostService;
import com.team3.pms.Service.project.ProjectService;
import com.team3.pms.VO.Member.CustomUser;

@Controller
public class ProjectCostController {
	
	@Autowired
	public ProjectService projectService;
	
	@Autowired
	public ProjectCostService projectCostService;
	
	@GetMapping("/project/cost/{projectId}/create")
	public String projectCostReg(@PathVariable String projectId, Model model, Authentication auth) {
		CustomUser member = (CustomUser) auth.getPrincipal();
		String authRole = projectService.findAuthRoleByEmpCdPk(member.getEmp_cd_pk());
		model.addAttribute("authRole",authRole);
		
		String resourceRole = projectService.findResourceRoleByEmpCdPk(new ResourceRoleGetForm(projectId, member.getEmp_cd_pk()));
		model.addAttribute("resourceRole",resourceRole);
		model.addAttribute("projectId",projectId);
		model.addAttribute("projectName",projectService.findProjectName(projectId));

		if(!authRole.equals("10") && resourceRole == null) {
			return "error/404";	//admin이 아니고 resource 할당이 되어있지 않으면 404에러 처리
		}
		
		
		return "project/projectCostReg";
	}
	
	@GetMapping("/project/cost/{projectId}/edit/{cost_pk}")
	public String projectCostEdit(@PathVariable String projectId,
			@PathVariable String cost_pk, Model model, Authentication auth) {
		CustomUser member = (CustomUser) auth.getPrincipal();
		String authRole = projectService.findAuthRoleByEmpCdPk(member.getEmp_cd_pk());
		model.addAttribute("authRole",authRole);
		model.addAttribute("user_pk",member.getEmp_cd_pk());
		
		String resourceRole = projectService.findResourceRoleByEmpCdPk(new ResourceRoleGetForm(projectId, member.getEmp_cd_pk()));
		model.addAttribute("resourceRole",resourceRole);
		model.addAttribute("projectId",projectId);
		model.addAttribute("projectName",projectService.findProjectName(projectId));
		model.addAttribute("costInfo",projectCostService.costInfo(cost_pk));

		if(!authRole.equals("10") && resourceRole == null) {
			return "error/404";	//admin이 아니고 resource 할당이 되어있지 않으면 404에러 처리
		}
		
		
		return "project/projectCostEdit";
	}
	
	@PostMapping("/cost/{projectId}")
	@ResponseBody
	public void saveCost(@PathVariable String projectId, @RequestBody CostSaveForm saveForm,Authentication auth) {
		CustomUser member = (CustomUser) auth.getPrincipal();
		String authRole = projectService.findAuthRoleByEmpCdPk(member.getEmp_cd_pk());
		
		String resourceRole = projectService.findResourceRoleByEmpCdPk(new ResourceRoleGetForm(projectId, member.getEmp_cd_pk()));
		
		if(!authRole.equals("10") && resourceRole == null) {
		}else {
			saveForm.setProject_pk(projectId);
			saveForm.setEmp_cd_pk(member.getEmp_cd_pk());
			projectCostService.saveCost(saveForm);
		}
		
	}
	
	@PutMapping("/cost/{cost_pk}")
	@ResponseBody
	public void updateCost(@PathVariable String cost_pk, @RequestBody CostSaveForm saveForm) {
		saveForm.setProject_pk(cost_pk);
		projectCostService.updateCost(saveForm);
		
	}
	
	@DeleteMapping("/cost/{cost_pk}")
	@ResponseBody
	public void deleteCost(@PathVariable String cost_pk) {
		projectCostService.deleteCost(cost_pk);
		
	}

}
