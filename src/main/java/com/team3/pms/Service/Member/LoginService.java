package com.team3.pms.Service.Member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.team3.pms.Dao.Member.MemberDao;
import com.team3.pms.VO.Member.CustomUser;
import com.team3.pms.VO.Member.MemberDto;

@Service
public class LoginService implements UserDetailsService {

	
	@Autowired(required=false)
	private MemberDao mDao;
	private MemberDto member;
	private CustomUser customUser;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		//userId 를 이용하여 DB를 조회한다.
		member = mDao.getMemberByID(userId);
		// DB조회 실패
		if (member == null) {
			System.out.println(userId + "로 조회 결과, 일치하는 회원 정보가 없습니다.");
			throw new InternalAuthenticationServiceException("User '"+userId+"': cannot found ID.");
		}
		// 권한
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		if (member.getEmp_auth_fk() == 0) {
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		} else if (member.getEmp_auth_fk() < 5) {
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		} else if (member.getEmp_auth_fk() == 5) {
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			roles.add(new SimpleGrantedAuthority("ROLE_PM"));
		} else if (member.getEmp_auth_fk() == 10) {
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
			roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else {
			// emp_auth_fk 99 (retired 퇴사)는 인증 불가
			// 인증 요구가 거부됐을 때 던지는 예외
			// throw new AuthenticationCredentialsNotFoundException("퇴사 계정");
			throw new DisabledException("User '"+userId+"': This user has been retired.");
		}
		
		
		
		// 시큐리티의 내용 외 파라미터를 추가하고 싶을 때, 아래 사용
	    //  제약조건: Controller 에서 Auth를 점검할 때, UserCustom 으로 받아야 함.
		customUser = new CustomUser(member.getEmp_id(), member.getEmp_pw(), roles,
				member.getEmp_cd_pk(), member.getEmp_name(), member.getEmp_pos(), member.getEmp_dept());
		
		
		
		

        return customUser;
	}
	
}

/*


@Service
public class LoginService implements UserDetailsService {

	
	@Autowired(required=false)
	private MemberDao mDao;
	private MemberDto member;
	
	@Override
	public MemberDto loadUserByUsername(String userId) throws UsernameNotFoundException {
		//userId 를 이용하여 DB를 조회한다.
		member = mDao.findByID(userId);
        //성공일경우 user 객체 (MemberDto가 userDetails를 상속) 반환
		
		
		//DB조회 실패
		if(member==null) {
			System.out.println(userId+"로 조회 결과, 일치하는 회원 정보가 없습니다.");
			throw new InternalAuthenticationServiceException(userId);
		}
		

        //return new User(userId, member.getEmp_pw(), roles);
		return member;

	}
	
	
}
*/
