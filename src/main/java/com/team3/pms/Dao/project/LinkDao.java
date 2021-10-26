package com.team3.pms.Dao.project;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.Controller.project.form.LinkSaveForm;

@Mapper
public interface LinkDao {

	String getMaxId();

	List<LinkDTO> callLinks(String projectId);

	void saveLink(LinkSaveForm linkSaveForm);

	void deleteLink(String linkId);

}
