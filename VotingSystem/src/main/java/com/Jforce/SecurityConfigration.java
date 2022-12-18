package com.Jforce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Jforce.service.UserSecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfigration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserSecurityService uss;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(uss);
		BCryptPasswordEncoder bycode= new BCryptPasswordEncoder();
		auth.inMemoryAuthentication().withUser("admin").password(bycode.encode("admin")).roles("ADMIN");
	}

}
