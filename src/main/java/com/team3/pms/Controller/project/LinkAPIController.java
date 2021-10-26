package com.team3.pms.Controller.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team3.pms.Controller.project.form.LinkForm;
import com.team3.pms.Controller.project.form.LinkSaveForm;
import com.team3.pms.Dao.project.LinkDTO;
import com.team3.pms.Service.project.LinkService;

@RestController
public class LinkAPIController {
	
	@Autowired
	LinkService linkService;
	
	@GetMapping("/api/link/maxId")
	public String getMaxId() {
		return linkService.getMaxId();
	}
	
	@GetMapping("/api/wbs/{projectId}/link")
	public List<LinkForm> callLinks(@PathVariable String projectId){
		List<LinkDTO> linkDTO = linkService.callLinks(projectId);
		List<LinkForm> linkForm = new ArrayList<>();
		for(int i=0; i<linkDTO.size(); i++) {
			linkForm.add(new LinkForm(
					linkDTO.get(i).getLink_pk(),
					linkDTO.get(i).getLink_source(),
					linkDTO.get(i).getLink_target(),
					linkDTO.get(i).getLink_type()
			));
		}
		return linkForm;
	}
	
	@PostMapping("/api/wbs/{projectId}/link")
	public void saveLink(@RequestBody LinkSaveForm linkSaveForm, 
			@PathVariable String projectId) {
		linkSaveForm.setProjectId(projectId);
		linkService.saveLink(linkSaveForm);
		System.out.println("-----------ADD LINK----------");
	}
	
	@DeleteMapping("/api/wbs/{projectId}/link/{linkId}")
	public void deleteLink(@PathVariable String linkId) {
		linkService.deleteLink(linkId);
		System.out.println("-----------DELETE LINK----------");
	}
}
