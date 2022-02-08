package com.learning.springsecurityjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.learning.springsecurityjwt.service.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailsService userDetailService;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().antMatchers("/authenticate").permitAll().anyRequest().authenticated();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
}
