package com.team3.pms.Controller.Admin;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team3.pms.Controller.Member.form.IDValidationForm;
import com.team3.pms.Service.Log.LogService;
import com.team3.pms.Service.Member.MemberService;
import com.team3.pms.VO.Log.LogDto;
import com.team3.pms.VO.Member.RegTokenDto;


@Controller
public class AdminController {
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private MemberService regService;
	@Autowired
	private LogService lService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/adminMember")
	public String Register(Model d){
		
		d.addAttribute("MemberList", regService.getMemberList());
		d.addAttribute("AuthList", regService.getAuthList());
		d.addAttribute("DeptList", regService.getDeptList());
		d.addAttribute("PosList", regService.getPosList());
		return "admin/member";
	}

	@RequestMapping(value = "/admin/getMember",method = RequestMethod.POST)
	public String dataSend(Model d, String pk){
		d.addAttribute("MemberDetail", regService.getMemberByPK_Detailed(pk));
		d.addAttribute("ProjectList", regService.getPersonalProjectListByPK(pk));
		return "admin/member :: #memberModal";
	}
	 
	 //회원가입 안내 메일 보내기
	 @GetMapping("/sendRegisterEmail")
		public String SendEmail(Model d, @RequestParam("email") String email, 
				@RequestParam("name") String name, @RequestParam("auth") int auth, 
				@RequestParam("dept") int dept, @RequestParam("pos") int pos) throws NoSuchAlgorithmException{

		 String setRegToken_Result = regService.setRegToken(email, name, auth, dept, pos);
		 if(setRegToken_Result.equals("")){
			 //실패시...?
			 d.addAttribute("ERRORMSG", "잘못된 접근이거나 만료된 요청입니다!");
	         return "login/fail";
		 }
		 //메일 작업
		 String subject = "QPMS 회원가입 메일";
		 String text = name+"님, QPMS입니다~\n\n 아래 링크를 통해 회원가입 절차를 완료해주세요~ \n "
		 		+ "www.qpms.co.kr/register?id="+setRegToken_Result+"\n\n"
		 		+ "http://localhost:3333/register?id="+setRegToken_Result+"\n\n"
		 				+ "http://106.10.104.82:3333/register?id="+setRegToken_Result+"\n\n";
		 SimpleMailMessage message = new SimpleMailMessage();
		 message.setTo(email);
		 message.setSubject(subject);
		 message.setText(text);
		 emailSender.send(message);
		 //로그
		 logger.info("New register token (id="+setRegToken_Result+")");
		 d.addAttribute("MSG", "메일 전송 완료!");
		 d.addAttribute("hrefURL", "/adminMember");
		return "admin/sendEmail";
	 } 
	
	@RequestMapping("/loglist")
	public String errLog(Model d){
		d.addAttribute("LogList_INFO", lService.getINFOcom()  );
		d.addAttribute("LogList_ERROR", lService.getERROR()  );
		return "admin/log";
	}
	
	
	
}
