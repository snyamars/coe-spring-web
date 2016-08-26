package com.wipro.coe.microservices.web.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("testConsulApp")
public interface SampleClient {

	@RequestMapping(value = "/choose", method = RequestMethod.GET)
	String choose();
	
	
	
	
	@RequestMapping(value = "/prop", method = RequestMethod.GET)
	String check();
	
}