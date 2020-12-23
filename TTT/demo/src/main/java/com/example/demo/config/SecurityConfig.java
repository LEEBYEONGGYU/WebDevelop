//package com.example.demo.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.authorizeRequests()
//		.antMatchers("/**").permitAll() // 모든 권한을 줌.=로그인 필요 없음.
//		.antMatchers("/files/**").hasRole("USER") // user 권한만 접근 가능.
//        .antMatchers("/android/fileUpload").permitAll()
//		.antMatchers("/logout").permitAll()
//		.antMatchers("/testf/**").permitAll()
//		.anyRequest().authenticated() // 로그인 체크함.
//		.and()
//		.formLogin()
//		.loginPage("/login") //이 줄을 지우면 스프링이 제공하는 폼이 출력됨.
//		.permitAll()
//		.successHandler(successHandler())
//		.and()
//		.logout()
//		.logoutUrl("/logout")
//		.logoutSuccessUrl("/")
//		.invalidateHttpSession(true)
//		.and()
//		.exceptionHandling().accessDeniedPage("/403")
//		.and()
//		.csrf();
//		//api이후의 주소들은 csrf토큰검사를 패쓰한다
//		http.csrf().ignoringAntMatchers("/api/**");
//		http.csrf().ignoringAntMatchers("/riding/**");
//		http.csrf().ignoringAntMatchers("/android/**");
//		http.csrf().ignoringAntMatchers("/android/login");
//		http.csrf().ignoringAntMatchers("/*/**");
//		http.csrf().ignoringAntMatchers("/app/riding/scrap/del/**");
//		//.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//		}
//
//	public AuthenticationSuccessHandler successHandler() {
//		SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
//		return handler;
//	}
//	
//	@Override
//    public void configure(WebSecurity web) throws Exception
//    {
//        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
//        web.ignoring().antMatchers("/css/**", "/js/**", "/imgs/**");
//    }
//}