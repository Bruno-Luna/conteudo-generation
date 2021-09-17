package com.generation.blogPessoal_II.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService service;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override protected void configure(HttpSecurity http) throws Exception { 
		http.authorizeRequests() 
		.antMatchers("/usuario/salvar").permitAll() 
		.antMatchers("/usuario/credenciais").permitAll() 
		.antMatchers(HttpMethod.OPTIONS)
		.permitAll() .anyRequest().authenticated() 
		.and().httpBasic() .and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
		.and().cors() .and().csrf().disable(); }
	
	
	@Override protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		auth.userDetailsService(service); 
		auth.inMemoryAuthentication() .withUser("root").password(passwordEncoder()
				.encode("root")).authorities("ROLE_USER"); 
		}
}
