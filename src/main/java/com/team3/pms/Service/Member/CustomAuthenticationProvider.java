package com.team3.pms.Service.Member;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.team3.pms.VO.Member.CustomUser;
import com.team3.pms.VO.Member.MemberDto;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginService loginService;
    @Autowired
    private PasswordEncoder passwordEncoder;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = (String)authentication.getPrincipal();
        String userPassword = (String)authentication.getCredentials();
        System.out.println("입력한 정보: "+userId+", "+userPassword);
        //DB에서 구해온 정보
        CustomUser customUser = (CustomUser)loginService.loadUserByUsername(userId);
        //DB에서 가져온 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(customUser.getPassword());
        System.out.println("DB조회 결과: "+customUser.getUsername()+", "+encodedPassword);
        if(passwordEncoder.matches(userPassword, encodedPassword)) {
        	//인증 실패
        	if(!customUser.isEnabled() || !customUser.isCredentialsNonExpired()) {
        	    throw new AuthenticationCredentialsNotFoundException("User '"+userId+"': Authentication not Found.");
        	}
        	//인증성공 시 Principal에 customUser, Credential에 encodedPAssword, Authentication에 cutomUser의 권한을 넣고 return!
        	//이후에 Controller단에서 (매개변수에 Authentication auth를 넣고) result.getPrincipal로 customUser에 접근할 수 있다.
        	//view단에서는 sec 태그로 'Principal.CustomUser변수이름' <<으로 접근 가능
        	UsernamePasswordAuthenticationToken result = 
        			new UsernamePasswordAuthenticationToken(customUser, encodedPassword, customUser.getAuthorities());
        	logger.info("User '"+userId+"': Logged In."); 
        	return result;
        } else if (!passwordEncoder.matches(userPassword, encodedPassword)) {
        	//비밀번호 불일치
        	throw new BadCredentialsException("User '"+userId+"': Password inccorect");
        } else {
        	//로그인 실패
        	return null;
        } 
    }
    
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}



/*

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginService loginService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = (String)authentication.getPrincipal();
        String userPassword = (String)authentication.getCredentials();
        
        System.out.println("입력한 정보: "+userId+", "+userPassword);
        
        //----------------로그인 로직 구현

        //MemberDto member = loginService.loadUserByUsername(userId); //load에서 null일경우 예외 던짐.
        MemberDto member = loginService.getMemberByID(userId); //load에서 null일경우 예외 던짐.
        UserDetails user = loginService.loadUserByUsername(userId); //load에서 null일경우 예외 던짐.
        
        
        //DB에서 가져온 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(member.getEmp_pw());
        member.setEmp_pw(encodedPassword);
        System.out.println("DB조회 결과: "+member.getEmp_id()+", "+member.getEmp_pw());
        
        
        
        //권한 설정
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        
        if(passwordEncoder.matches(userPassword, member.getEmp_pw())) {
        	//User가 null이 아닐 때(DB조회 성공). 입력된 패스워드와 User의 패스워드가 같으면 
        	//로그인 성공
        	
        	// 권한
        	if( member.getEmp_auth_fk()==0   ) {
	        	roles.add(new SimpleGrantedAuthority("ROLE_GUEST"));
			} else if (member.getEmp_auth_fk()<5) {
	        	roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			} else if (member.getEmp_auth_fk()==5) {
	        	roles.add(new SimpleGrantedAuthority("ROLE_USER"));
				roles.add(new SimpleGrantedAuthority("ROLE_PM"));
			} else if (member.getEmp_auth_fk()==10) {
				roles.add(new SimpleGrantedAuthority("ROLE_USER"));
				roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			} else {
				//emp_auth_fk 99 (retired 퇴사)는 인증 불가 
				//인증 요구가 거부됐을 때 던지는 예외
				//throw new AuthenticationCredentialsNotFoundException("퇴사 계정");
				throw new DisabledException("퇴사 계정");
			}
        	
        	//인증 검사
        	User user = new User(member.getEmp_id(), member.getEmp_pw(), roles);
        	
        	//System.out.println("member.isEnabled(): "+user.isEnabled());
        	//System.out.println("member.isCredentialsNonExpired(): "+user.isCredentialsNonExpired());
        	//인증 실패
        	if(!user.isEnabled() || !user.isCredentialsNonExpired()) {
        		System.out.println("인증실패?: "+(!user.isEnabled() || !user.isCredentialsNonExpired()));
        	    throw new AuthenticationCredentialsNotFoundException(userId);
        	}
        	
        	//인증성공 시 member session 생성 후 반환
        	UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userId, userPassword, roles);
        	result.setDetails(member);
     		return result;
        	
        } else if (!passwordEncoder.matches(userPassword, member.getEmp_pw())) {
        	//비밀번호 불일치
        	throw new BadCredentialsException("아이디 비밀번호 불일치");
        } else {
        	//로그인 실패
        	return null;
        }
        
        
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
*/