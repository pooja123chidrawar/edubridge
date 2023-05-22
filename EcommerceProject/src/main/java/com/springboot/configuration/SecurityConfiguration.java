//package com.springboot.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	
//	
//	@Override
//	protected void configure(HttpSecurity http)throws Exception {
//		
//		http
//		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//		.and()
//		.authorizeRequests()
//		.antMatchers("/public/**").hasRole("NORMAL")
//		.antMatchers("api/user/**").hasRole("ADMIN")
//		.anyRequest()
//		.authenticated()
//		.and()
//		.formLogin();
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//		auth.inMemoryAuthentication().withUser("anji").password("anji123").roles("NORMAL");
//		auth.inMemoryAuthentication().withUser("beeru").password("beeru123").roles("ADMIN");
//		
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//		
//	}
//	
//	
//
//}
