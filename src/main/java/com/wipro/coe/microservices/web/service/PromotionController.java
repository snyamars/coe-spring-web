package com.wipro.coe.microservices.web.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wipro.coe.microservices.web.client.PromotionsCassandraClient;
import com.wipro.coe.microservices.web.domain.Promotion;

@RestController
public class PromotionController {
	
	@Autowired
	PromotionsCassandraClient cassandraClient;

	
	@RequestMapping( value = "/promotion" , method = RequestMethod.GET)
	public Resources<Resource<Promotion>> getPromotions()
	{
		
		return cassandraClient.getAllPromotions();
		
	}
	
	
	@HystrixCommand(fallbackMethod = "getDummyPromotion")
	@RequestMapping(value = "/promotion/{id}", method = RequestMethod.GET)
	public Resource<Promotion> getPromotion(@PathVariable Long id)
	{
        
        Resource<Promotion> promotionreturned = cassandraClient.get(id);
        Promotion promo = promotionreturned.getContent();
        System.out.println( " the promotion returned is ::" + promotionreturned);
        System.out.println( " the promotion id returned is :: -" + promotionreturned.getId().getHref()+ "-   ##################");

        return promotionreturned;
		
	}
	
	
	@RequestMapping(value = "/promotion", method = RequestMethod.POST)
	public Resource<Promotion> save(@RequestBody Promotion promotion)
	{
        
        Resource<Promotion> promotionreturned = cassandraClient.save( promotion);
        Promotion promo = promotionreturned.getContent();
        System.out.println( " the promotion returned is ::" + promotionreturned);
        System.out.println( " the promotion id returned is :: -" + promotionreturned.getId().getHref()+ "-   ##################");

        return promotionreturned;
		
	}

	@RequestMapping(value = "/promotion/{id}", method = RequestMethod.PUT)
	public Resource<Promotion> update(@PathVariable("id") Long id, @RequestBody Promotion promotion)
	{
        
        Resource<Promotion> promotionreturned = cassandraClient.update(id, promotion);
        Promotion promo = promotionreturned.getContent();
        System.out.println( " the promotion returned is ::" + promotionreturned);
        System.out.println( " the promotion id returned is :: -" + promotionreturned.getId().getHref()+ "-   ##################");

        return promotionreturned;
		
	}
	
	@RequestMapping(value = "/promotion/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id)
	{
        cassandraClient.delete(id);

        System.out.println( " the promotion  id deleted  ::" + id);


        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
		
	}

	
	public Resource<Promotion> getDummyPromotion(Long id)
	{
;
		System.out.println("Dummy Promotion called");
		System.out.println(" Raise an alert with the support team");
		System.out.println(" log the failure");
		System.out.println(" Raise an alert with the support team");

               
		Promotion promo = new Promotion();
		promo.setId(1L);
		promo.setDescription("Dummy Descripion ");
    	promo.setPromotionEndDate(new Date());
    	promo.setPromotionEndDate(new Date());
    	
    	
        
        Link selfLink = new Link("./promotion/"+promo.getId());

        return new Resource<Promotion>(promo, selfLink);    
		
	}
}
