package com.app.woofer.config;

import com.app.woofer.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableSwagger2
@EnableWebSecurity
public class WooferConfiguration extends WebSecurityConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/user/*").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/user").permitAll()
				.antMatchers("/post").permitAll()
				.antMatchers("/posts").permitAll()
				.antMatchers("/posts/*").permitAll()
				.antMatchers("/post/*").permitAll()
				.antMatchers("/like/*/*").permitAll()
				.antMatchers("/comment").permitAll()
				.antMatchers("/follow/*").permitAll()
				.antMatchers("/follow/*/*").permitAll()
				.antMatchers("/follow").permitAll()
				.antMatchers("/comment/user/*").permitAll()
				.antMatchers("/comment/post/*").permitAll()
				.anyRequest().authenticated();
	}
	@Bean
	public User getUser(){return new User();};
	@Bean
	public Docket generateUserApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.app.woofer"))
				.build();
	}
	
	
}
