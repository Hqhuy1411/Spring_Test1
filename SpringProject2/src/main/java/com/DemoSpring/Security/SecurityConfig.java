package com.DemoSpring.Security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		auth.jdbcAuthentication()
//			.dataSource(dataSource)
//			.passwordEncoder(new BCryptPasswordEncoder())
//			.usersByUsernameQuery("select username, password , enabled from user_table where username = ?")
//			.authoritiesByUsernameQuery("select username , role from user_table where username =?")
//			; 
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(new BCryptPasswordEncoder())
			.usersByUsernameQuery("SElECT username, password,enabled FROM user_table WHERE username= ?")
			.authoritiesByUsernameQuery("SELECT username, role FROM user_table WHERE username= ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()	
			.antMatchers("/images/**").permitAll()
			.antMatchers("/product/**").permitAll()
			.antMatchers("/category/**").hasAnyRole("ADMIN","USER")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.and()
			.logout()
			.and()
			.exceptionHandling().accessDeniedPage("/403");
	}
	
	
	
}
