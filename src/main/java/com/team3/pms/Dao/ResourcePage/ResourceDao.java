package com.team3.pms.Dao.ResourcePage;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.VO.MyPage.Task;
import com.team3.pms.VO.resource.Resource;
import com.team3.pms.VO.resource.ResourceState;

@Mapper
public interface ResourceDao {
	public ArrayList<Resource> resourceList(Resource resource);
	public ArrayList<ResourceState> resourceStateList();
	
	//프로젝트, task 생성 연동
	public int getDept(String emp_cd_pk);
	public String getEmp(String resource_pk);
	public int chkProject(ResourceState rsc);
	public void addProject(ResourceState rsc);
	public void addName(ResourceState rsc);
	public void addTask(ResourceState rsc);
	
	// 프로젝트 삭제 연동
	public int chkName(String project_pk);
	public int chkTask(String project_pk);
	public void deleteProject(String project_pk);
	public void deleteNameByProject(String project_pk);
	public void deleteTaskByProject(String project_pk);
	
	// 프로젝트 수정 연동
	public void updateByProject(ResourceState rsc);
	
	// task 수정 연동
	public int chkTaskManager(String task_pk);
	public void updateTask(ResourceState rsc);
	public void updateRscTaskProg(Task task);
	// task 삭제
	public void deleteTask(String task_pk);
	// 리소스 삭제
	public void deleteRscMem(ResourceState rsc);
	
	// 프로젝트 필터
	public ArrayList<ResourceState> filterByProject(String project_pk);
}
