package com.team3.pms.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team3.pms.Service.Member.LoginFailureHandler;
import com.team3.pms.Service.Member.LoginService;
import com.team3.pms.Service.Member.LoginSuccessHandler;
import com.team3.pms.Service.Member.MemberAuthenticationEntryPoint;
import com.team3.pms.Service.Member.MemberDeniedHandler;


@Configuration
@Order(1)  
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	LoginService loginService = new LoginService();
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/css/**","/images/**","/font/**","/html/**", "/vendor/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.antMatchers("/adminMember").hasRole("ADMIN")
        		.antMatchers("/sendRegisterEmail").hasRole("ADMIN")
        		.antMatchers("/loglist").hasRole("ADMIN")
        		.antMatchers("/login/success").hasRole("USER")
        		.antMatchers("/logout").hasRole("USER")
        		.antMatchers("/login").permitAll()
        		.antMatchers("/register").permitAll()
        		.antMatchers("/register/**").permitAll()
        		.antMatchers("/checkID").permitAll()
        		.antMatchers("/getIDValidation").permitAll()
        		.antMatchers("/loginFail").permitAll()
        		.antMatchers("/loginDenied").permitAll()
        		.antMatchers("/**").hasRole("USER")
        	.and()
    			.csrf()
    			.ignoringAntMatchers("/**")
    		.and()
                .formLogin()
                .loginPage("/login") 
                .usernameParameter("login-id")
                .passwordParameter("login-password")
                .loginProcessingUrl("/login/perform")
                .failureHandler( loginFailureHandler() )
                .successHandler( loginSuccessHandler() )
            .and()
            	.rememberMe()
            	.key("QPMS") //token 생성에 사용되는 필수 값
            	.rememberMeParameter("QPMS-remember-me")
            	.rememberMeCookieName("QPMS-remember-me")
            	.tokenValiditySeconds(88640*7) //토큰 일주일동안 유효
            	.userDetailsService(  loginService  )
            	//.authenticationSuccessHandler(  loginSuccessHandler())  
            .and()
                .logout() 
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login") 
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "QPMS-remember-me")
            .and()
            	.exceptionHandling()
            	.accessDeniedHandler( memberDeniedHandler() )
        		.authenticationEntryPoint( authEntry() );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //BCrypt라는 해시 함수를 이용하여 패스워드를 암호화하는 구현체
    }
    
    @Bean
    public AuthenticationFailureHandler loginFailureHandler() {
    	return new LoginFailureHandler();
    }
    
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
    	return new LoginSuccessHandler();
    }
    
    @Bean
    public AuthenticationEntryPoint authEntry() {
    	return new MemberAuthenticationEntryPoint();
    }
    
    @Bean
    public AccessDeniedHandler memberDeniedHandler() {
    	return new MemberDeniedHandler();
    }
    
    @Bean
    public SessionRegistry sessionRegistry() {
    	return new SessionRegistryImpl();
    }
    
   /*  
    @Bean
    public UserDetailsService loginService2() {
    	return new LoginService();
    }
   
    @Bean
    public RememberMeServices rememberMeService(PersistentTokenRepository ptr) {
    	PersistentTokenBasedRememberMeServices rememberMeService = new PersistentTokenBasedRememberMeServices("QPMS", loginService2(), ptr);
    	rememberMeService.setParameter("3wh-remember-me");
    	rememberMeService.setCookieName("3wh-remember-me");
    	
    	return rememberMeService;
    }
*/

}