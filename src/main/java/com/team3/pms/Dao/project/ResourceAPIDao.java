package com.team3.pms.Dao.project;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.Controller.project.form.MemberListGetForm;
import com.team3.pms.Controller.project.form.ResourceEngagementDeleteForm;

@Mapper
public interface ResourceAPIDao {

	List<ResourceMemberDTO> getMemberList(MemberListGetForm getForm);

	List<ResourceMemberDTO> getEngagementMemberList(String projectId);

	void addEngagementMember(ResourceEngagementAddDTO addDTO);

	void deleteEngagementMember(ResourceEngagementDeleteForm deleteForm);

	List<ProjectResourceGetDTO> getProjectResource(String projectId);

	List<String> getApproverManagerList(String projectId); 

}
