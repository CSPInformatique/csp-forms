package com.cspinformatique.forms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.cspinformatique.forms.service.UserService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/img/**", "/js/**", "/libs/**", "/").permitAll()
				.antMatchers(HttpMethod.GET, "/poll/**").permitAll()
				.antMatchers(HttpMethod.POST, "/image", "/pollParticipantAnswers", "/error").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().logoutUrl("/logout")
				.permitAll().and().csrf().disable().httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}
}
