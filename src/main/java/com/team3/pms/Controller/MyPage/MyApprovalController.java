package com.team3.pms.Controller.MyPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team3.pms.Service.MyPage.MyApprovalService;
import com.team3.pms.Service.MyPage.MyProductService;
import com.team3.pms.VO.Member.CustomUser;
import com.team3.pms.VO.MyPage.Task;



@Controller
public class MyApprovalController {
	
	@Autowired
	MyApprovalService service;

	@Autowired
	MyProductService service_pro;	
	
	public String loginSuccess(Authentication auth){
        CustomUser member = (CustomUser) auth.getPrincipal();
        String emp_cd_pk = member.getEmp_cd_pk();
        return emp_cd_pk; 
	}
		
	
	// MY테스크 리스트
	@RequestMapping("/taskList")
	public String taskList(Authentication auth, Model d){
		d.addAttribute("categoryList", service_pro.getCategoryNm());
		d.addAttribute("taskList", service.getTaskList(loginSuccess(auth)));
		d.addAttribute("projectList", service_pro.getProjectNm());
		d.addAttribute("categoryList", service_pro.getCategoryNm());
		return "MyPage/taskList";
	}
	
	// MY 테스크 상세내용 수정
	@RequestMapping("/taskUpdate")
	public String taskUpdate(Task upt) {
		service.taskUpdate(upt);
		return "redirect:/taskList";
	}	
	
	
	// MY 결재 리스트
	@RequestMapping("/approvalList")
	public String approvalList(Authentication auth, Model d){
		d.addAttribute("approvalList", 
				service.getApprovalList(loginSuccess(auth)));
		d.addAttribute("categoryList", service_pro.getCategoryNm());
		return "MyPage/approvalList";
	}
	
	// 승인요청내역 리스트
	@RequestMapping("/approvalRequestList")
	public String approvalRequestList(Authentication auth, Model d){
		d.addAttribute("approvalList", 
				service.getApprovalRequestList(loginSuccess(auth)));
		d.addAttribute("categoryList", service_pro.getCategoryNm());
		return "MyPage/approvalRequestList";
	}
	
	// 잠초내역 리스트
	@RequestMapping("/approvalReferList")
	public String approvalReferList(Task sch, Model d){
		return "MyPage/approvalReferList";
	}
	
	// 테스크 결재 반려
	@RequestMapping("/rejectApproval")
	public String rejectApproval(@RequestParam String task_pk, Model d) {
		service.rejectApproval(task_pk);
		return "redirect:/approvalList";
	}
	
	// 테스크 최종 승인
	@RequestMapping("/taskApprovalPermit")
	public String taskProgressUpdate(Task upt) {
		service.taskApprovalPermit(upt);
		return "redirect:/approvalList";
	}	


	@RequestMapping("/app")
	public String test(){
		return "MyPage/approvaltotal";
	}
	
	
}
