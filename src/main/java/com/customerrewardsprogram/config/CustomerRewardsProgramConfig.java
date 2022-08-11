package com.customerrewardsprogram.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class CustomerRewardsProgramConfig  extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		super.configure(auth);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			.antMatchers("/customerRewardsProgram/",
					"/customerRewardsProgram/getTotalRewardsByCustomerId/customerId/{customerId}",
					"/customerRewardsProgram/getRewardsOfCustomerByMonth/customerId/{customerId}",
					"/customerRewardsProgram/getTotalRewardsByCustomer")
			.permitAll().anyRequest().authenticated();		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

}
