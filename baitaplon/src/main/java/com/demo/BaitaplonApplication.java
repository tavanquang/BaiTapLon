package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.demo.service.impl.UserLoginServiceImpl;

@SpringBootApplication
public class BaitaplonApplication extends WebSecurityConfigurerAdapter{

	@Autowired
	UserLoginServiceImpl userLoginServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(BaitaplonApplication.class, args);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/admin/them-phieu-chi").permitAll()
		.antMatchers("/admin/them-phieu-de-xuat").permitAll()
		
		.anyRequest().authenticated().and().formLogin().loginPage("/login")
		.defaultSuccessUrl("/admin/").failureUrl("/login?e=error").permitAll().and()
		.logout().permitAll().and().exceptionHandling().accessDeniedPage("/login?e=deny");
		
}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/js/**","/images/**","/fonts/**");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userLoginServiceImpl);
	}
	
}
