package com.team3.pms.Controller.MyPage;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team3.pms.Service.MyPage.MyApprovalService;
import com.team3.pms.Service.MyPage.MyCalendarService;
import com.team3.pms.Service.MyPage.MyProductService;
import com.team3.pms.VO.Member.CustomUser;
import com.team3.pms.VO.MyPage.Calendar;
import com.team3.pms.VO.MyPage.Log;
import com.team3.pms.VO.MyPage.Product;
import com.team3.pms.VO.MyPage.Task;



@RestController
public class MyPageRestController {
	
	@Autowired
	MyApprovalService service_app;

	@Autowired
	MyProductService service_pro;
	
	public String loginSuccess(Authentication auth){
        CustomUser member = (CustomUser) auth.getPrincipal();
        String emp_cd_pk = member.getEmp_cd_pk();
        return emp_cd_pk; 
	}
	
	
	
	// MY테스크 정보상세
	@RequestMapping("/taskDetail")
	public ArrayList<Task> taskDetail(@RequestParam String task_pk, Model d){
		return service_app.getTaskDetail(task_pk);
	}

	// MY테스크 로그
	@RequestMapping("/taskLog")
	public ArrayList<Log> taskLog(@RequestParam String task_pk, Model d){
		return service_app.getTaskLog(task_pk);
	}	

	// MY결재 로그
	@RequestMapping("/approvalLog")
	public ArrayList<Log> approvalLog(@RequestParam String approval_cd_pk, Model d){
		return service_app.getApprovalLog(approval_cd_pk);
	}	
	
	// MY결재 정보상세
	@RequestMapping("/approvalDetail")
	public ArrayList<Task> approvalDetail(@RequestParam String task_pk, Model d){
		return service_app.getApprovalDetail(task_pk);
	}
	
	// MY테스크 결재승인요청
	@RequestMapping("/requestApproval")
	public ArrayList<Task> requestApproval(
		@RequestParam(value="taskArr[]") ArrayList <String> taskArr, 
		@RequestParam(value="requestDetail") String requestDetail,
		Authentication auth, Model d){
		Map<String, Object> schobj = new HashMap <String, Object>();
        schobj.put("emp_cd_pk", loginSuccess(auth));
        for (int idx=0; idx < taskArr.size(); idx++) {
			service_app.insertRequestApproval(new Task(requestDetail,
					taskArr.get(idx),loginSuccess(auth)));
			service_app.insertRequestApproval_task(new Task(taskArr.get(idx)));
		}
		return service_app.getTaskList(loginSuccess(auth));
	}
	
	// 결재승인요청취소
	@RequestMapping("/cancelRequest")
	public ArrayList<Task> cancelRequestApproval(@RequestParam String task_pk, 
			Authentication auth, Model d){
		service_app.cancelRequestApproval(task_pk);
		return service_app.getApprovalList(loginSuccess(auth));
	}	
	
	// MY산출물 정보상세
	@RequestMapping("/productDetail")
	public ArrayList<Product> productDetail(
			@RequestParam String prod_cd_pk, Model d){
		return service_pro.getproductDetail(prod_cd_pk);
	}
	
	// MY테스크 산출물 정보상세
	@RequestMapping("/productDetail_task")
	public ArrayList<Product> productDetail_task(@RequestParam String task_pk, Model d){
		return service_app.getproductDetail_task(task_pk);
	}
	
	// MY산출물 프로젝트에따른 테스크이름
	@RequestMapping("/projecttask")
	public ArrayList<Product> productList
		(@RequestParam(value="project_pk") 
		String project_pk, Model d){
		return service_pro.getTaskNm(project_pk);
	}	
	
	
	
	
	
	@Autowired
	private MyCalendarService calservice;	

	@RequestMapping("/calList")
	public List<Calendar> calList(Authentication auth) {
        CustomUser member = (CustomUser) auth.getPrincipal();
		return calservice.calList(member.getEmp_cd_pk());
	}
	@RequestMapping("/calendarInsert")
	public String calendarInsert(Calendar insert, Authentication auth) {
        CustomUser member = (CustomUser) auth.getPrincipal();
		Map<String, Object> ins = new HashMap <String, Object>();
		 ins.put("title", insert.getTitle());
		 ins.put("start", insert.getStart());
		 ins.put("end", insert.getEnd());
		 ins.put("content", insert.getContent());
		 ins.put("backgroundColor", insert.getBackgroundColor());
		 ins.put("textColor", insert.getTextColor());
		 ins.put("allDay", insert.isAllDay());
		 ins.put("emp_cd_pk", member.getEmp_cd_pk());
		calservice.insertCalendar(ins);
		return "등록완료";
	}	
	@RequestMapping("/calendarUpdate")
	public String calendarUpdate(Calendar upt) {
		calservice.uptCalendar(upt);
		return "수정완료";
	}		
	@RequestMapping("/calendarDelete")
	public String calendarDelete(@RequestParam("id") int id) {
		calservice.delCalendar(id);
		return "삭제완료";
	}
	
	
}
