package com.pluralsight.conferencedemoboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages={"com.pluralsight.conferencedemoboot"})
@EntityScan( basePackages = "com.pluralsight.conferencedemoboot.*" )
@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ConferenceDemoBootApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(ConferenceDemoBootApplication.class, args);
		System.out.println("Hello World");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ConferenceDemoBootApplication.class);
	}

}
