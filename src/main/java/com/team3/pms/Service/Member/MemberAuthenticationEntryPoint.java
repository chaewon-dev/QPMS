package com.team3.pms.Service.Member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class MemberAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.error( authException.getMessage(), authException.getClass().toString());
		request.setAttribute("ERRORMSG", "접근 권한이 없습니다!");
		request.getRequestDispatcher("/loginDenied").forward(request, response);
	}

}
