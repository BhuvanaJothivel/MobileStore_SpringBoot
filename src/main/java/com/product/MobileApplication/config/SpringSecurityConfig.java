package com.product.MobileApplication.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("customer").password("cuspassword").roles("CUSTOMER")
			.and()
			.withUser("admin").password("adminpassword").roles("CUSTOMER","ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/getAllMobile").hasRole("CUSTOMER")
			.antMatchers(HttpMethod.GET, "/getAllMobile").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/addmobile").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT, "/updateMobile").hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/deleteAllMobile").hasRole("ADMIN")
			.and()
			.csrf().disable()
			.formLogin().disable();
	}
}
