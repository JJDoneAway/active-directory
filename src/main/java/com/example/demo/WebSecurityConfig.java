package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();
		http.logout().logoutSuccessUrl("/hello");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth//
				.ldapAuthentication()//
				.userDnPatterns("uid={0},ou=people")//
				.groupSearchBase("ou=groups")//
				.contextSource()//
				.url("ldap://localhost:8389/dc=springframework,dc=org")//
				.and()//
				.passwordCompare()
				.passwordEncoder(new BCryptPasswordEncoder())//
				.passwordAttribute("userPassword");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/api/**");
	}

}