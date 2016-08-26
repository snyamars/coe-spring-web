package com.wipro.coe.microservices.web.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wipro.coe.microservices.web.domain.Promotion;

@FeignClient("coe-cassandra-promotions")
public interface PromotionsCassandraClient {
	
	@RequestMapping(value = "/promotions", method = RequestMethod.GET)
	Resources<Resource<Promotion>>  getAllPromotions();
	
	
	@RequestMapping(value = "/promotions/{id}", method = RequestMethod.GET)
	Resource<Promotion> get(@PathVariable("id") Long id);
	
	@RequestMapping(value = "/promotions", method = RequestMethod.POST)
	Resource<Promotion> save(Promotion Promotion);
	
	@RequestMapping(value = "promotions/{id}" ,method = RequestMethod.PUT) 
	Resource<Promotion> update(@PathVariable("id") long id, Promotion promotion);

	@RequestMapping(value = "promotions/{id}"  , method = RequestMethod.DELETE)  
	void delete(@PathVariable("id") long id);
}	