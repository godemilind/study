package com.iocs.spring;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
public class Application extends WebSecurityConfigurerAdapter {

	@Autowired
	private ApplicationContext appContext;

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		String[] beans = ctx.getBeanDefinitionNames();

		Arrays.stream(beans).forEach(System.out::println);

	}

	private Connector redirectConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
				.csrf().disable()
				.authorizeRequests().anyRequest().authenticated()
				.and()
				.httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception
	{
		auth.inMemoryAuthentication()
				.withUser("admin")
				.password("{noop}password")
				.roles("USER");
	}
}
