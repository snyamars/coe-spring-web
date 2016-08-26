package com.wipro.coe.microservices.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RestController
@EnableCircuitBreaker 
@EnableHystrixDashboard
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableAutoConfiguration
public class Application {
	
	@Autowired
	private LoadBalancerClient loadBalancer;

	@Autowired
	private DiscoveryClient discoveryClient;


    
	@RequestMapping("/me")
	public ServiceInstance me() {
		return discoveryClient.getLocalServiceInstance();
	}


    public static void main(String[] args) {
  
        SpringApplication.run(Application.class, args);
    }

}
