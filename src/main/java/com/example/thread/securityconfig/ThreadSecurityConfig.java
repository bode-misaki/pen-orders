//package com.example.thread.securityconfig;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.example.thread.service.AccountService;
//
//@EnableWebSecurity
//public class ThreadSecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//	AccountService accountService;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//		// 認証するユーザーを設定する(今回はServiceで)
//		authenticationManagerBuilder.userDetailsService(this.accountService)
//				// PasswordEncoderを使用しハッシュ化した値でパスワード認証を行う
//				.passwordEncoder(passwordEncoder());
//	}	
//	
//	@Override
//	protected void configure(HttpSecurity httpSecurity)throws Exception{
//		httpSecurity
//			.csrf()
//			.disable()
//			.formLogin()
//			.defaultSuccessUrl("/top")
//			.permitAll();
//		httpSecurity
//			.authorizeRequests()
//			.antMatchers("/css/**")
//			.permitAll()
//			.anyRequest()
//			.authenticated();
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		
//		return new BCryptPasswordEncoder();
//	}
//}
//
//
