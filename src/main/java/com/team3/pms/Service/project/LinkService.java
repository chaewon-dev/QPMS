package com.team3.pms.Service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.pms.Controller.project.form.LinkSaveForm;
import com.team3.pms.Dao.project.LinkDTO;
import com.team3.pms.Dao.project.LinkDao;

@Service
public class LinkService {

	@Autowired
	LinkDao linkDao;
	
	@Transactional
	public String getMaxId() {
		return linkDao.getMaxId();
	}

	@Transactional
	public List<LinkDTO> callLinks(String projectId) {
		return linkDao.callLinks(projectId);
	}

	@Transactional
	public void saveLink(LinkSaveForm linkSaveForm) {
		linkDao.saveLink(linkSaveForm);
	}

	@Transactional
	public void deleteLink(String linkId) {
		linkDao.deleteLink(linkId);
	}

}
