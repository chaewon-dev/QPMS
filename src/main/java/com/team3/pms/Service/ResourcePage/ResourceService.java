package com.team3.pms.Service.ResourcePage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.team3.pms.Controller.project.form.ProjectRegForm;
import com.team3.pms.Controller.project.form.ProjectUpdateForm;
import com.team3.pms.Controller.project.form.TaskSaveForm;
import com.team3.pms.Controller.project.form.TaskUpdateForm;
import com.team3.pms.Dao.ResourcePage.ResourceDao;
import com.team3.pms.Dao.project.ProjectDao;
import com.team3.pms.VO.resource.Resource;
import com.team3.pms.VO.resource.ResourceState;
import com.team3.pms.VO.resource.RscStateForm;

@Controller
public class ResourceService {
	
	@Autowired
	private ResourceDao resourceDao;
	@Autowired
	private ProjectDao projectDao;
	
	public ArrayList<Resource> resourceList(Resource resource) {
		return resourceDao.resourceList(resource);
	}
	
	// 배정현황 리스트
	public ArrayList<RscStateForm> resourceStateList(){
		ArrayList<ResourceState> rscStateTmpList = resourceDao.resourceStateList();
		ArrayList<RscStateForm> rscStateList = new ArrayList<RscStateForm>();
		for(int i=0;i<rscStateTmpList.size();i++) {
			rscStateList.add(new RscStateForm(
					rscStateTmpList.get(i).getRsc_pk(),
					rscStateTmpList.get(i).getRsc_cat_nm(),
					rscStateTmpList.get(i).getRsc_start_dt(),
					rscStateTmpList.get(i).getRsc_end_dt(),
					rscStateTmpList.get(i).getRsc_prog(),
					rscStateTmpList.get(i).getRsc_parent()
					));
		}
		return rscStateList;
	}
	
	// 배정현황 프로젝트 필터
	public ArrayList<RscStateForm> filteredList(String project_pk){
		ArrayList<ResourceState> rscStateTmpList = resourceDao.filterByProject(project_pk);
		ArrayList<RscStateForm> rscStateList = new ArrayList<RscStateForm>();
		for(int i=0;i<rscStateTmpList.size();i++) {
			rscStateList.add(new RscStateForm(
					rscStateTmpList.get(i).getRsc_pk(),
					rscStateTmpList.get(i).getRsc_cat_nm(),
					rscStateTmpList.get(i).getRsc_start_dt(),
					rscStateTmpList.get(i).getRsc_end_dt(),
					rscStateTmpList.get(i).getRsc_prog(),
					rscStateTmpList.get(i).getRsc_parent()
					));
		}
		return rscStateList;
	}
	// 배정현황 pm 등록
	public void regRscPm(ProjectRegForm regForm) {
		String pmNum = regForm.getProjectPM();
		int dept = resourceDao.getDept(pmNum);
		String maxId = projectDao.getProjectMaxId();
		ResourceState rsc = new ResourceState(maxId, dept);
		resourceDao.addProject(rsc);
		resourceDao.addName(new ResourceState(maxId, dept, pmNum));
	}
	
	// 배정현황 프로젝트, 이름 등록
	public void addPrjName(String[] emp_cd_pk_arr, String project_pk) {
		for(String x : emp_cd_pk_arr) {
			int dept = resourceDao.getDept(x);
			int projectChk = resourceDao.chkProject(new ResourceState(project_pk, dept));
			if(projectChk==0) {
				resourceDao.addProject(new ResourceState(project_pk, dept));
			}
			//deptSet.add(dept);
			resourceDao.addName(new ResourceState(project_pk, dept, x));
		}
	}
	
	// 배정현황 task 등록
	public void addRscTask(TaskSaveForm taskSaveForm, String project_pk) {
		if(taskSaveForm.getManager()!=null) {
			String task_manager = taskSaveForm.getManager();
			String emp_cd_pk = resourceDao.getEmp(task_manager);
			resourceDao.addTask(new ResourceState(project_pk, emp_cd_pk, task_manager));
		}
	}
	
	
	// 배정현황 프로젝트 수정 연동
	public void updateRscProject(ProjectUpdateForm updateForm) {
		String rsc_cat_nm = updateForm.getProject_nm();
		Date start_dt = updateForm.getProject_start_dt();
		Date end_dt = updateForm.getProject_comp_dt();
		SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd");
		String rsc_start_dt = tf.format(start_dt);
		String rsc_end_dt = tf.format(end_dt);
		String rsc_cat_num = updateForm.getProject_pk();
		ResourceState rsc = new ResourceState(rsc_cat_num, rsc_cat_nm, rsc_start_dt, rsc_end_dt);
		resourceDao.updateByProject(rsc);
	}
	
	// 배정현황 프로젝트 삭제 연동
	public void deleteRscProject(String project_pk) {
		int taskCount = resourceDao.chkTask(project_pk);
		System.out.println("task개수:"+taskCount);
		if(taskCount>0) {
			resourceDao.deleteTaskByProject(project_pk);
		}
		int nameCount = resourceDao.chkName(project_pk);
		System.out.println("이름개수:"+nameCount);
		if(nameCount >0) {
			resourceDao.deleteNameByProject(project_pk);
		}
		resourceDao.deleteProject(project_pk);
	}
	
	// 배정현황 task 수정 연동
	public void updateRscTask(TaskUpdateForm updateForm) {
		String task_pk = updateForm.getId();
		String manager = updateForm.getManager();
		int exist = resourceDao.chkTaskManager(task_pk);
		if(exist==0) {
			String emp_cd_pk = resourceDao.getEmp(manager);
			resourceDao.addTask(new ResourceState(updateForm.getProjectId(), emp_cd_pk, manager));
		}
		String rsc_cat_nm = updateForm.getText();
		//날짜 변환
		SimpleDateFormat transFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date start = null;
		Date end = null;
		try {
			start = transFormat.parse(updateForm.getStart_date());
			end = transFormat.parse(updateForm.getEnd_date());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat transFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		String rsc_start_dt = transFormat2.format(start);
		String rsc_end_dt = transFormat2.format(end);
		String rsc_cat_num = updateForm.getProjectId();
		String emp_cd_pk = resourceDao.getEmp(updateForm.getManager());
		int emp_dept_pk = resourceDao.getDept(emp_cd_pk);
		ResourceState rsc = new ResourceState(rsc_cat_num,rsc_cat_nm,
				rsc_start_dt, rsc_end_dt, emp_dept_pk, emp_cd_pk, task_pk);
		resourceDao.updateTask(rsc);
	}
	
	// task 삭제
	public void deleteRscTask(String task_pk) {
		resourceDao.deleteTask(task_pk);
	}
	
	// 리소스 삭제
	public void deleteRscMem(String resourceId, String project_pk) {
		resourceDao.deleteRscMem(new ResourceState(project_pk, resourceId));
	}
}
