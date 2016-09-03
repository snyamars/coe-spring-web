package com.wipro.coe.microservices.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.wipro.coe.microservices.web")
public class WebConfig extends WebMvcConfigurerAdapter {


	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	
	/**
	 * Overriding the resource handler to include all the contents into the package 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		if (!registry.hasMappingForPattern("/lib/**")) {
			registry.addResourceHandler("/lib/**").addResourceLocations("classpath:/static/lib/");
		}
		if (!registry.hasMappingForPattern("/app/**")) {
			registry.addResourceHandler("/app/**").addResourceLocations("classpath:/static/app/");
		}
		if (!registry.hasMappingForPattern("/Partials/**")) {
			registry.addResourceHandler("/Partials/**").addResourceLocations("classpath:/static/Partials/");
		}
		if (!registry.hasMappingForPattern("/webjars/**")) {
			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
	}

}
