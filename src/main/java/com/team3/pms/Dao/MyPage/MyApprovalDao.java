package com.team3.pms.Dao.MyPage;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.team3.pms.VO.MyPage.Log;
import com.team3.pms.VO.MyPage.Product;
import com.team3.pms.VO.MyPage.Task;


@Mapper
public interface MyApprovalDao {
	// MY테스크 리스트 조회
	ArrayList <Task> getTaskList (String emp_cd_pk);

	// MY테스크 상세정보 조회
	ArrayList <Task> getTaskDetail (String task_pk);
	
	// MY테스크 로그 조회
	ArrayList <Log> getTaskLog (String task_pk);

	// MY결재 로그 조회
	ArrayList <Log> getApprovalLog (String task_pk);	
	
	// MY결재 상세정보 조회
	ArrayList <Task> getApprovalDetail (String task_pk);
	
	// 전자결재 승인등록 - 최조 결재등록
	public void insertRequestApproval(Task ins);
	
	// 전자결재 테스크상태 변경
	public void insertRequestApproval_task(Task upt);
	
	// MY테스크 상세내용 업데이트
	public void taskUpdate(Task upt);
	public void taskProgressUpdate(Task upt);

	// 전자결재 리스트 조회
	ArrayList <Task> getApprovalList (String emp_cd_pk);
	
	// 전자결재 요청내역 리스트 조회
	ArrayList <Task> getApprovalRequestList (String emp_cd_pk);
	
	// 전자결재 승인요청 취소 - 테스크상태 변경
	public void cancelRequestApproval_task (String task_pk);
	
	// 전자결재 승인요청 취소 - 결재상태변경 변경
	public void cancelRequestApproval_app (String task_pk);
	
	// 전자결재 승인요청 반려
	public void rejectApproval (String task_pk);
	
	// 전자결재 최종 승인
	public void taskApprovalPermit (Task upt);
	public void taskPermitUpdate (Task upt);
	public void taskProgressPermit (Task upt);
	public void taskPermitNoUpdate (Task upt);

	// 테스크 상세조회
	ArrayList <Product> getproductDetail_task (String task_pk);
}
