package com.wipro.coe.microservices.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.wipro.coe.microservices.web")
public class WebConfig extends WebMvcConfigurerAdapter {

//	
//	@Bean
//	public InternalResourceViewResolver getInternalResourceViewResolver()
//	{
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
	
	
	  @Override
	  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	}
	  
	 @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 
		 if (!registry.hasMappingForPattern("/lib/**")) {
				registry.addResourceHandler("/lib/**").addResourceLocations(
						"classpath:/static/lib/");
		 }
		if (!registry.hasMappingForPattern("/app/**")) {
						registry.addResourceHandler("/app/**").addResourceLocations(
								"classpath:/static/app/");
		}
	}
	 
	 
}
