package com.team3.pms.Service.Member;

import java.io.IOException;

import javax.annotation.Resource;
import javax.security.auth.login.CredentialExpiredException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.bind.annotation.RequestMapping;

public class LoginFailureHandler implements AuthenticationFailureHandler{

	private String defaultFailureUrl = "/loginFail"; //로그인 실패 시 보여줄 화면 url
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String errormsg = null;
		//에러메시지
		if(exception instanceof BadCredentialsException) {
			//비밀번호가 틀림
			errormsg = "아이디나 비밀번호가 맞지 않습니다.";
		} else if(exception instanceof InternalAuthenticationServiceException) {
			//존재하지 않는 아이디
			errormsg = "아이디나 비밀번호가 맞지 않습니다.";
		} else if(exception instanceof DisabledException) {
			errormsg = "계정이 비활성화 되었습니다. 관리자에게 문의하세요.";
		} else {
			errormsg = "알 수 없는 이유로 로그인에 실패했습니다. 관리자에게 문의하세요.";
		}
		logger.error( exception.getMessage(), exception.getClass().toString());
		request.setAttribute("ERRORMSG", errormsg);
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
	}

	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

}
