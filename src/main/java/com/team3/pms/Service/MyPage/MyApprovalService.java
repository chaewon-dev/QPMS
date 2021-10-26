package com.team3.pms.Service.MyPage;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.pms.Dao.MyPage.MyApprovalDao;
import com.team3.pms.Dao.ResourcePage.ResourceDao;
import com.team3.pms.VO.MyPage.Log;
import com.team3.pms.VO.MyPage.Product;
import com.team3.pms.VO.MyPage.Task;


@Service
public class MyApprovalService {
	
	@Autowired(required=false)
	public MyApprovalDao dao;
	@Autowired
	private ResourceDao rdao;
	

	// MY테스크 리스트 조회
	public ArrayList<Task> getTaskList(String emp_cd_pk) {
		return dao.getTaskList(emp_cd_pk);
	}
	// MY테스크 상세정보 조회
	public ArrayList<Task> getTaskDetail(String task_pk) {
		return dao.getTaskDetail(task_pk);
	}
	// MY테스크 로그 조회	
	public ArrayList<Log> getTaskLog(String task_pk) {
		return dao.getTaskLog(task_pk);
	}	
	
	// MY결재 로그 조회	
	public ArrayList<Log> getApprovalLog(String approval_cd_pk) {
		return dao.getApprovalLog(approval_cd_pk);
	}	
	
	// MY결재 상세정보 조회
	public ArrayList<Task> getApprovalDetail(String task_pk) {
		return dao.getApprovalDetail(task_pk);
	}
	// MY테스크 상세정보 조회_산출물
	public ArrayList<Product> getproductDetail_task (String prod_cd_pk) {
		return dao.getproductDetail_task(prod_cd_pk);
	}
	
	
	
	// MY테스크 상세내용 업데이트
	public void taskUpdate (Task upt) {
		dao.taskUpdate(upt);
		dao.taskProgressUpdate(upt);
	}
	
	// MY결재 리스트 조회
	public ArrayList<Task> getApprovalList(String emp_cd_pk) {
		return dao.getApprovalList(emp_cd_pk);
	}
	// MY결재 결재내역 조회
	public ArrayList<Task> getApprovalRequestList(String emp_cd_pk) {

		return dao.getApprovalRequestList(emp_cd_pk);
	}
	
	// 최초 결재 승인 요청 
	public void insertRequestApproval(Task ins) {
		dao.insertRequestApproval(ins);
	}
	// 테스크 승인요청상태변경
	public void insertRequestApproval_task(Task upt) {
		dao.insertRequestApproval_task(upt);
	}

	// 테스크 승인회수 요청
	public void cancelRequestApproval(String task_pk) {
		dao.cancelRequestApproval_task(task_pk);
		dao.cancelRequestApproval_app(task_pk);
	}
	
	// 테스크 결재 반려
	public void rejectApproval(String task_pk) {
		dao.cancelRequestApproval_task(task_pk);
		dao.rejectApproval(task_pk);
	}
	
	// 전자결재 최종 승인	
	public void taskApprovalPermit (Task upt) {
		dao.taskApprovalPermit(upt);
		dao.taskPermitUpdate(upt);
		dao.taskProgressPermit(upt);
		dao.taskPermitNoUpdate(upt);
		rdao.updateRscTaskProg(upt);
	}


}
