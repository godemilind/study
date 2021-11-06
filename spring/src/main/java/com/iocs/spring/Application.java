package com.iocs.spring;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
public class Application {

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

}
