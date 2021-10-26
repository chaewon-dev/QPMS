package com.team3.pms.Service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.pms.Controller.project.form.MemberListGetForm;
import com.team3.pms.Controller.project.form.ResourceEngagementDeleteForm;
import com.team3.pms.Dao.project.ProjectResourceGetDTO;
import com.team3.pms.Dao.project.ResourceAPIDao;
import com.team3.pms.Dao.project.ResourceEngagementAddDTO;
import com.team3.pms.Dao.project.ResourceMemberDTO;

@Service
public class ResourceAPIService {

	@Autowired
	ResourceAPIDao resourceAPIDao;
	
	@Transactional
	public List<ResourceMemberDTO> getMemberList(MemberListGetForm getForm) {
		return resourceAPIDao.getMemberList(getForm);
	}

	@Transactional
	public List<ResourceMemberDTO> getEngagementMemberList(String projectId) {
		return resourceAPIDao.getEngagementMemberList(projectId);  
	}

	@Transactional
	public void addEngagementMember(String[] emp_cd_pk_arr, String projectId) {
		for(String x : emp_cd_pk_arr) {
			resourceAPIDao.addEngagementMember(new ResourceEngagementAddDTO(x, projectId)); 
		}
		 
	}
	
	@Transactional
	public void deleteEngagementMember(ResourceEngagementDeleteForm deleteForm) {
		resourceAPIDao.deleteEngagementMember(deleteForm);
	}

	public List<ProjectResourceGetDTO> getProjectResource(String projectId) {
		return resourceAPIDao.getProjectResource(projectId);
	}

	public List<String> getApproverManagerList(String projectId) {
		return resourceAPIDao.getApproverManagerList(projectId);
	}
	
	

}
