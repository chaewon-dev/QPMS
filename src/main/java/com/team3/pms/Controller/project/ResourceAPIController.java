package com.team3.pms.Controller.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team3.pms.Controller.project.form.MemberListGetForm;
import com.team3.pms.Controller.project.form.ProjectResourceGetForm;
import com.team3.pms.Controller.project.form.ResourceEngagementDeleteForm;
import com.team3.pms.Dao.project.ProjectResourceGetDTO;
import com.team3.pms.Dao.project.ResourceMemberDTO;
import com.team3.pms.Service.ResourcePage.ResourceService;
import com.team3.pms.Service.project.ResourceAPIService;

@RestController
public class ResourceAPIController {
	
	@Autowired
	ResourceAPIService resourceAPIService;
	@Autowired
	ResourceService rsService;
	
	@GetMapping("/resource/member/dept/{deptData}/{projectId}")
	public List<ResourceMemberDTO> getMemberList(@PathVariable int deptData, 
			@PathVariable String projectId) {
		return resourceAPIService.getMemberList(new MemberListGetForm(deptData, projectId));
	}
	
	@GetMapping("/resource/enegagementMember/{projectId}")
	public List<ResourceMemberDTO> getEngagementMemberList(@PathVariable String projectId) {
		System.out.println("getEngagementMemberList(), projectId:" + projectId);
		
		return resourceAPIService.getEngagementMemberList(projectId);
		
	}
	
	@PostMapping("/resource/enegagementMember/{projectId}")
	public void addEngagementMember(@RequestBody String[] emp_cd_pk_arr, @PathVariable String projectId) {
		System.out.println("addEngagementMember(), projectId:" + projectId);
		for(String x : emp_cd_pk_arr) {
			System.out.println(x);
		}
		resourceAPIService.addEngagementMember(emp_cd_pk_arr, projectId);
		rsService.addPrjName(emp_cd_pk_arr, projectId);
	}
	
	@DeleteMapping("/resource/enegagementMember/{resourceId}/{projectId}")
	public void deleteEngagementMember(@PathVariable String resourceId, @PathVariable String projectId) {
		System.out.println("DELETE: " + resourceId);
		resourceAPIService.deleteEngagementMember(new ResourceEngagementDeleteForm(resourceId, projectId));
		rsService.deleteRscMem(resourceId, projectId);
	}
	
	
	@GetMapping("/api/project/resource/{projectId}")
	public List<ProjectResourceGetForm> getProjectResource(@PathVariable String projectId) {
		List<ProjectResourceGetForm> formList = new ArrayList<>();
		List<ProjectResourceGetDTO> dtoList = resourceAPIService.getProjectResource(projectId);
		formList.add(new ProjectResourceGetForm("", "선택안함"));
		for(ProjectResourceGetDTO x : dtoList) {
			formList.add(new ProjectResourceGetForm(x.getResource_pk(), x.getEmp_cd_pk() + " / " + x.getEmp_name()));
		}
		return formList;
	}
	
	//approver와 manager의 emp_cd_pk list 반환
	@GetMapping("/api/project/resource/approvermanager/{projectId}")
	public List<String> getApproverManagerList(@PathVariable String projectId){
		return resourceAPIService.getApproverManagerList(projectId);
	}

}
