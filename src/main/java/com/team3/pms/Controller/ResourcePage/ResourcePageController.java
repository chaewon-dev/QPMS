package com.team3.pms.Controller.ResourcePage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.pms.Service.ResourcePage.ResourceService;
import com.team3.pms.Service.project.ProjectService;
import com.team3.pms.VO.resource.Resource;

@Controller
public class ResourcePageController {
	@Autowired
	private ResourceService resourceSer;
	@Autowired
	public ProjectService projectService;
	
	@RequestMapping("/ResourceList")
	public String ResourceList(Resource resource, Model d){
		d.addAttribute("resourceList", resourceSer.resourceList(resource));
		
		return "ResourcePage/ResourceList";
	}
	
	
	@RequestMapping("/ResourceStatePage")
	public String ResourceStatePage(Model d){
		d.addAttribute("projectList", projectService.projectList());
		return "ResourcePage/ResourceStatePage2";
	}
	

}
