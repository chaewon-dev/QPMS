package com.team3.pms.Controller.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.jdi.connect.Connector.StringArgument;
import com.team3.pms.Controller.Member.form.IDValidationForm;
import com.team3.pms.Controller.Member.form.MemberRegForm;
import com.team3.pms.Service.Member.MemberService;
import com.team3.pms.VO.Member.CustomUser;
import com.team3.pms.VO.Member.MemberDto;
import com.team3.pms.VO.Member.RegTokenDto;



@Controller
public class MemberController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private MemberService regService;
	
	@GetMapping("/login")
    public String loginForm(Authentication auth){
		try {
			auth.getPrincipal();
		}catch (Exception e) {
			//인증된 사용자 정보 없을 경우에만 login 화면 로드
			return "login/login";
		}
		return "redirect:/main";
    }
    
    @GetMapping("/getLogout")
    public String getLogout(Authentication auth){
    	//로그아웃 하기 전 로그 남기기....
        CustomUser member = (CustomUser)auth.getPrincipal();
    	logger.info("User '"+member.getUsername()+"': Logged Out."); 
    	return "redirect:/logout";
    }

    @GetMapping("/logout")
    public String logout(Authentication auth){
        //실제 로그아웃 수행 후 이동
        return "redirect:/login";
    }

    @RequestMapping(value = "/loginFail", method= {RequestMethod.GET, RequestMethod.POST})
    public String loginFail(){
        return "login/fail";
    }

    @RequestMapping(value = "/loginDenied", method= {RequestMethod.GET, RequestMethod.POST})
    public String loginDenied(){
        return "login/denied";
    }
    
    @GetMapping("/register")
    public String registerForm( Model d, @RequestParam(value="id", required=false) String sha){
    	
    	RegTokenDto token;
    	
    	try {
    		token = regService.getRegTokenByID(sha);
    	} catch (Exception e) {
    		d.addAttribute("ERRORMSG", "잘못된 접근이거나 만료된 요청입니다!");
            return "login/fail";
		}
    	//만료날짜 String to Date
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date expiration_dt  = null; 
        Date now = new Date();
        try {
			expiration_dt = transFormat.parse(token.getExpiration_dt());
		} catch (ParseException e) {
			e.printStackTrace();
		}
        int compare = now.compareTo(expiration_dt);
        if(compare > 0 || token.getExpired()==1) {
        	logger.error("Wrong access. This register token (id="+token.getId()+") has expired. ");
	        d.addAttribute("ERRORMSG", "잘못된 접근이거나 만료된 요청입니다!");
	        return "login/fail";
		} 
        
        // 만료X 정상적인 토큰일 ㄸㅐ!
        d.addAttribute("Token", token);
        d.addAttribute("isID_verified", false);
        return "login/registerForm";
    }
    
    @RequestMapping(value="/register/perform", method= {RequestMethod.GET, RequestMethod.POST})
    public String registerPerform( Model d, @RequestParam("sha") String sha, 
    		@RequestParam("auth") String auth, @RequestParam("dept") String dept, @RequestParam("pos") String pos,
    		@RequestParam("name") String name, @RequestParam("id") String id, @RequestParam("pass1") String pass, 
    		@RequestParam("email") String email, @RequestParam("tel") String tel, @RequestParam("birth") String birth)
    																throws NoSuchAlgorithmException{
    	int auth_pk = Integer.parseInt(auth);
    	int dept_pk = Integer.parseInt(dept);
    	int pos_pk = Integer.parseInt(pos);
    	// 회원 등록
    	MemberRegForm regForm = new MemberRegForm(auth_pk,dept_pk, pos_pk, id, pass, name, birth, tel, email );
    	regService.insertMember(regForm);
    	regService.updateRegToken_expired(sha);
    	//메일 작업
		 String subject = "QPMS 회원 등록 완료 안내";
		 String text = name+"님, QPMS입니다~\n\n 회원 등록 절차를 완료하였습니다 \n id: "+id+", pass: "+pass+"\n\n";
		 SimpleMailMessage message = new SimpleMailMessage();
		 message.setTo(email);
		 message.setSubject(subject);
		 message.setText(text);
		 emailSender.send(message);
		// 로그
	    String regDate = regService.getRegTokenByID(sha).getLast_modified_dt();
	    logger.info("New user registration: "+id+" ("+regDate+")");
		d.addAttribute("MSG", id+"님 회원 등록 성공!");
    	return "login/registerPerform";
    }
    
    @RequestMapping(value="/checkID", method= {RequestMethod.GET, RequestMethod.POST})
    public String checkID(Model d, @RequestParam(value="id", required=false) String id) {
    	
    	d.addAttribute("id", id);
    	d.addAttribute("icon", "display:none;");
    	return "login/checkID";
    }
    
    @RequestMapping(value = "/getIDValidation",method = RequestMethod.POST)
    public String dataSend(Model model,  IDValidationForm dto){

        String id = dto.getId();
        int result = regService.checkID(id);
        if(result>0) {
        	model.addAttribute("result", "false");
            model.addAttribute("msg", id+"는 사용할 수 없습니다..");
            model.addAttribute("icon", "display:none;");
        }else {
        	model.addAttribute("result", "true");
        	model.addAttribute("msg", id+"는 사용할 수 있습니다!");
        	model.addAttribute("icon", "display:'';");
        }
        return "login/checkID :: #check-result";
    }


}
