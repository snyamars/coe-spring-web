package com.wipro.coe.microservices.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wipro.coe.microservices.web.client.PromotionsCassandraClient;
import com.wipro.coe.microservices.web.domain.Promotion;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PromotionBackendController {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PromotionBackendController.class);
	
	@Autowired
	PromotionsCassandraClient cassandraClient;

	@HystrixCommand(fallbackMethod = "getDummyPromotions")
	@RequestMapping( value = "/promotion" , method = RequestMethod.GET)
	public List<Promotion> getPromotions()
	{

		return retriveAllPromotions();
		
	}


	private List<Promotion> retriveAllPromotions() {
		Collection<Resource<Promotion>> promocol = cassandraClient.getAllPromotions().getContent();
	    Iterator<Resource<Promotion>> promoiterator = promocol.iterator();
	    
	    List<Promotion> promolist = new ArrayList<Promotion>();
	

	    while (promoiterator.hasNext()){
	    	
	    	Resource<Promotion> promoresource = promoiterator.next();
		    Promotion promoObject = promoresource.getContent();
		    String hrefString = promoresource.getId().getHref();
		    String idStr = hrefString.substring(hrefString.lastIndexOf('/') +1);
		    
		    Long id = new Long(idStr);
		    promoObject.setId(id);
		    promolist.add(promoObject);
		
	    }

		return  promolist;
	}
	
	
	@HystrixCommand(fallbackMethod = "getDummyPromotion")
	@RequestMapping(value = "/promotion/{id}", method = RequestMethod.GET)
	public Promotion getPromotion(@PathVariable Long id)
	{
        
        Resource<Promotion> promotionreturned = cassandraClient.get(id);
        Promotion promo = promotionreturned.getContent();
	    String hrefString = promotionreturned.getId().getHref();
	    String idStr = hrefString.substring(hrefString.lastIndexOf('/') +1);
	    
	    
	    promo.setId(new Long (idStr));
	    
        System.out.println( " the promotion returned is ::" + promo);
        return promo;

		
	}
	
	@HystrixCommand(fallbackMethod = "saveDummyPromotion")
	@RequestMapping(value = "/promotion/", method = RequestMethod.POST)
	public List<Promotion> save(@RequestBody Promotion promotion)
	{
		
	
		Date nowDate = new Date();
        Long newId = nowDate.getTime();
        
        promotion.setId(newId);
        
        cassandraClient.save( promotion);


        return retriveAllPromotions();

		
	}

	@HystrixCommand(fallbackMethod = "updateDummyPromotion")
	@RequestMapping(value = "/promotion/{id}", method = RequestMethod.PUT)
	public List<Promotion> update(@PathVariable("id") Long id, @RequestBody Promotion promotion)
	{

        Resource<Promotion> promotionreturned = cassandraClient.update(id, promotion);
        Promotion promo = promotionreturned.getContent();
        

        return retriveAllPromotions();

		
	}

	@HystrixCommand(fallbackMethod = "removeDummyPromotion")
	@RequestMapping(value = "/promotion/{id}", method = RequestMethod.DELETE)
	public List<Promotion> delete(@PathVariable("id") Long id)
	{
        cassandraClient.delete(id);
        

        
        System.out.println( " the promotion  id deleted  ::" + id);



        return retriveAllPromotions();

		
	}

	
	public Promotion getDummyPromotion(Long id)
	{

       
		log.error("Hystrix service break called at getPromotion");



               
		Promotion promo = new Promotion();
		promo.setId(1L);
		promo.setDescription("Hystrix fallback Description");
    	promo.setPromotionStartDate(new Date());
    	promo.setPromotionEndDate(new Date());
    	
    	
        
    	return promo ;
		
	}

	public List<Promotion> saveDummyPromotion(Promotion promotion)
	{

		log.error("Hystrix service break called at savePromotion");
    	
        return createDummyPromotions();
		
	}
	public List<Promotion>  removeDummyPromotion(Long id)
	{

		log.error("Hystrix service break called at deletePromotion");


        return createDummyPromotions();
		
	}
	
	public List<Promotion> updateDummyPromotion(Long id ,Promotion promotion)
	{

		log.error("Hystrix service break called at updatePromotion");

    	
        
    	return createDummyPromotions();
		
	}
	
	public List<Promotion> getDummyPromotions()
	{
		log.error("Hystrix service break called at getPromotions");

		
		List<Promotion> promolist = createDummyPromotions();
        return promolist;
	}


	private List<Promotion> createDummyPromotions() {
		List<Promotion> promolist = new ArrayList<Promotion>();
               
		Promotion promo;

		promo = new Promotion();
		promo.setId(1L);
		promo.setDescription("Hystrix fallback Description 1");
    	promo.setPromotionStartDate(new Date());
    	promo.setPromotionEndDate(new Date());
        
        promolist.add(promo);
        
		promo = new Promotion();
		promo.setId(2L);
		promo.setDescription("Hystrix fallback Description 2");
    	promo.setPromotionStartDate(new Date());
    	promo.setPromotionEndDate(new Date());
        
        promolist.add(promo);
		return promolist;
	}
	
	
}
