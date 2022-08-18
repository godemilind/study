package com.iocs.spring;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableScheduling
public class Application
//		extends WebSecurityConfigurerAdapter
{

	@Autowired
	private ApplicationContext appContext;

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		String[] beans = ctx.getBeanDefinitionNames();

		Arrays.stream(beans).forEach(System.out::println);

	}

//	private Connector redirectConnector() {
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setScheme("http");
//		connector.setPort(8080);
//		connector.setSecure(false);
//		connector.setRedirectPort(8443);
//		return connector;
//	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception
//	{
//		http
//				.csrf().disable()
//				.authorizeRequests().anyRequest().authenticated()
//				.and()
//				.httpBasic();
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth)
//			throws Exception
//	{
//		auth.inMemoryAuthentication()
//				.withUser("admin")
//				.password("{noop}password")
//				.roles("USER");
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/spring/h2-ui/**").permitAll()
				.and()
				.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.httpBasic();
		http.headers().frameOptions().disable();
		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User
				.withUsername("admin")
				.password("{noop}password")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

}

