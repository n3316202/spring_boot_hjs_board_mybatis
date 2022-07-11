package edu.hi.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.hi.ex.security.CustomUserDetailsService;

//지금부터 하는거는 시큐리티 설정 클래스 만들기
@Configuration // 이 클래스는 설정 파일인것을 알려 주고, 부모가 @Component + 설정
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	//우선 정적파일들은 시큐리티에 적용되지 않도록 아래와 같이 설정을 한다.
	// 이제 더이상 리소스파일들은 스프링 시큐리티에서 관리를 하지 않는다.	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**","/css/**", "/fonts/**", "/images/**", "/js/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//우선 CSRF설정을 해제한다.
		//초기 개발시만 해주는게 좋다.
		http.csrf().disable();
				
		//http://localhost:8282/user/userHome
		//http://localhost:8282/admin/adminHome
		
		http.authorizeHttpRequests()		
			.antMatchers("/user/**").hasAnyRole("USER","ADMIN")
			.antMatchers("/admin/**").hasAnyRole("ADMIN","ADMIN")
			.antMatchers("/member/**").hasAnyRole("MEMBER","ADMIN")
			.antMatchers("/**").permitAll();
		
		//스프링 시큐리티에서 제공하는 기본 로그인 폼을 사용하겠다.
		//http://localhost:8282/login
		http.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/");       //loginPage() 는 말그대로 로그인할 페이지 url 이고
			
		
	  
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("user").password("{noop}user").roles("USER") .and()
		 * .withUser("admin").password("{noop}admin").roles("ADMIN","MEMBER","USER")
		 * .and() .withUser("member").password("{noop}member").roles("MEMBER");
		 */
		auth.userDetailsService(customUserDetailsService)
		    .passwordEncoder(new BCryptPasswordEncoder());
		
	            
	}
	
	
}
