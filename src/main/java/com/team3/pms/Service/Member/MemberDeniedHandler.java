package com.team3.pms.Service.Member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.access.AccessDeniedHandler;

public class MemberDeniedHandler implements AccessDeniedHandler {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		request.setAttribute("ERRORMSG", "접근 권한이 없습니다!");
		request.setAttribute("isLoggedIn", "yes");
		logger.error( accessDeniedException.getMessage(), accessDeniedException.getClass().toString());
		request.getRequestDispatcher("/loginDenied").forward(request, response);
	}

}
