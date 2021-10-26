package com.team3.pms.Dao.project;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.Controller.project.form.CostSaveForm;

@Mapper
public interface ProjectCostDao {

	void saveCost(CostSaveForm saveForm);

	CostEditDTO costInfo(String cost_pk);

	void updateCost(CostSaveForm saveForm);

	void deleteCost(String cost_pk);

}
