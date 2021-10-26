package com.team3.pms.Service.Member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, "/main");
	}
	//10.12
		//이 redirect의 이유,..
		//1. 만약, /frame의 접근권한이 최소 "ROLE_USER"였을 때. 로그인하지 하지 않고 "ROLE_ANNONYMUS"로 접근하면 SecurityConfig에 의해서 /login/login으로 이동 함
		//2. /login/login에서 인증 성공 시 /login/perform을 거쳐 다시 /frame으로 이동함. (/login/success를 거치지 않음.)
		//3. 그런데 MemberController의 /login/success를 매핑한 함수에서만 세션 작업을 하기 떄문에.... 
		//		/login/success를 거치지 않으면 Topbar에 회원 정보를 표시할 수 없음.
		//4. 그러므로, 어떤 상황에서든 로그인에 성공했을 때 /login/success로 redirect 하도록 설정 함.
		
		//10.12 (2번째)
		//(remember-me 로그인 때 출력되지 않는 이슈)
		//Authentication을 활용해서, session을 사용하지 않도록 내용 수정함 
		//그러므로 success를 들렸다가 다시 frame으로 redirect할 필요 없어짐
	

}
