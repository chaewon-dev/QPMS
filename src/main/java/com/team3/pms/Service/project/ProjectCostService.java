package com.team3.pms.Service.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.pms.Controller.project.form.CostSaveForm;
import com.team3.pms.Dao.project.CostEditDTO;
import com.team3.pms.Dao.project.ProjectCostDao;

@Service
public class ProjectCostService {
	
	@Autowired
	ProjectCostDao projectCostDao;

	public void saveCost(CostSaveForm saveForm) {
		projectCostDao.saveCost(saveForm);
		
	}

	public CostEditDTO costInfo(String cost_pk) {
		return projectCostDao.costInfo(cost_pk);
	}

	public void updateCost(CostSaveForm saveForm) {
		projectCostDao.updateCost(saveForm);
	}

	public void deleteCost(String cost_pk) {
		projectCostDao.deleteCost(cost_pk);
	}
	
	
	
	

}
