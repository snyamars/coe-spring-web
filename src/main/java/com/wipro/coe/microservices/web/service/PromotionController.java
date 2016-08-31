package com.wipro.coe.microservices.web.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@HystrixCommand(fallbackMethod = "getDummyPromotions")
	@RequestMapping( value = "/promotion" , method = RequestMethod.GET)
	public List<Promotion> getPromotions()
	{
		
		//return cassandraClient.getAllPromotions();
		
		Collection<Resource<Promotion>> promocol = cassandraClient.getAllPromotions().getContent();
	    Iterator<Resource<Promotion>> promoiterator = promocol.iterator();
	    
	    List<Promotion> promolist = new ArrayList<Promotion>();
	    
	    while (promoiterator.hasNext()){
	    	
	    	Resource<Promotion> promoresource = promoiterator.next();
		    //System.out.println("\n\n\n  romoresource  -------" +promoresource);
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
        
//        Promotion promo = promotionreturned.getContent();
//        System.out.println( " the promotion returned is ::" + promotionreturned);
//        System.out.println( " the promotion id returned is :: -" + promotionreturned.getId().getHref()+ "-   ##################");
//
//        return promotionreturned;
		
	}
	
	@HystrixCommand(fallbackMethod = "saveDummyPromotion")
	@RequestMapping(value = "/promotion", method = RequestMethod.POST)
	public Promotion save(@RequestBody Promotion promotion)
	{
        
        Resource<Promotion> promotionreturned = cassandraClient.save( promotion);
        Promotion promo = promotionreturned.getContent();
        
        
        String hrefString = promotionreturned.getId().getHref();
	    String idStr = hrefString.substring(hrefString.lastIndexOf('/') +1);
	    
	    
	    promo.setId(new Long (idStr));
     
        System.out.println( " the promotion returned is ::" + promo);
        System.out.println( " the promotion id returned is :: -" + promotionreturned.getId().getHref()+ "-   ##################");

        //return promotionreturned;
        return promo;
		
	}

	@HystrixCommand(fallbackMethod = "updateDummyPromotion")
	@RequestMapping(value = "/promotion/{id}", method = RequestMethod.PUT)
	public Promotion update(@PathVariable("id") Long id, @RequestBody Promotion promotion)
	{
        
        Resource<Promotion> promotionreturned = cassandraClient.update(id, promotion);
        Promotion promo = promotionreturned.getContent();
        
        String hrefString = promotionreturned.getId().getHref();
	    String idStr = hrefString.substring(hrefString.lastIndexOf('/') +1);
	    
	    
	    promo.setId(new Long (idStr));
     
        
        System.out.println( " the promotion returned is ::" + promo);
        System.out.println( " the promotion id returned is :: -" + promotionreturned.getId().getHref()+ "-   ##################");

        return promo;
		
	}

	@HystrixCommand(fallbackMethod = "removeDummyPromotion")
	@RequestMapping(value = "/promotion/{id}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable("id") Long id)
	{
        cassandraClient.delete(id);

        System.out.println( " the promotion  id deleted  ::" + id);


        return Boolean.TRUE;
		
	}

	
	public Promotion getDummyPromotion(Long id)
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
    	
    	
        
        //Link selfLink = new Link("./promotion/"+promo.getId());

        // return new Resource<Promotion>(promo, selfLink);\
    	return promo ;
		
	}

	public Promotion saveDummyPromotion(Promotion promotion)
	{
;
		System.out.println("Dummy remove Promotion called");
		System.out.println(" Raise an alert with the support team");
		System.out.println(" log the failure");
		System.out.println(" Raise an alert with the support team");

               
		Promotion promo = new Promotion();
		promo.setId(1L);
		promo.setDescription("Dummy Descripion ");
    	promo.setPromotionEndDate(new Date());
    	promo.setPromotionEndDate(new Date());
    	
    	
        
        //Link selfLink = new Link("./promotion/"+promo.getId());

        //return new Resource<Promotion>(promo, selfLink);  
        return promo;
		
	}
	public Boolean removeDummyPromotion(Long id)
	{
;
		System.out.println("Dummy remove Promotion called");
		System.out.println(" Raise an alert with the support team");
		System.out.println(" log the failure");
		System.out.println(" Raise an alert with the support team");

               
		Promotion promo = new Promotion();
		promo.setId(1L);
		promo.setDescription("Dummy Descripion ");
    	promo.setPromotionEndDate(new Date());
    	promo.setPromotionEndDate(new Date());
    	
    	
        
        Link selfLink = new Link("./promotion/"+promo.getId());

        //return new Resource<Promotion>(promo, selfLink);    
        return Boolean.TRUE;
		
	}
	
	public Promotion updateDummyPromotion(Long id ,Promotion promotion)
	{
;
		System.out.println("Dummy update Promotion called");
		System.out.println(" Raise an alert with the support team");
		System.out.println(" log the failure");
		System.out.println(" Raise an alert with the support team");

               
		Promotion promo = new Promotion();
		promo.setId(1L);
		promo.setDescription("Dummy Descripion ");
    	promo.setPromotionEndDate(new Date());
    	promo.setPromotionEndDate(new Date());
    	
    	
        
       // Link selfLink = new Link("./promotion/"+promo.getId());

        //return new Resource<Promotion>(promo, selfLink);  
    	return promo;
		
	}
	
	public Promotion[] getDummyPromotions()
	{
		System.out.println(" Dummy all Promotions called");
		System.out.println(" Raise an alert with the support team");
		System.out.println(" log the failure");
		System.out.println(" Raise an alert with the support team");

		//List<Resource<Promotion>> productList = new ArrayList<Resource<Promotion>>();
		
		List<Promotion> promolist = new ArrayList<Promotion>();
               
		Promotion promo;
		Link selfLink ;
		
		promo = new Promotion();
		promo.setId(1L);
		promo.setDescription("Dummy Descripion 1");
    	promo.setPromotionEndDate(new Date());
    	promo.setPromotionEndDate(new Date());
        //selfLink = new Link("./promotion/"+promo.getId());     
    	// productList.add(new Resource<Promotion>(promo, selfLink));
        
        promolist.add(promo);
        
		promo = new Promotion();
		promo.setId(2L);
		promo.setDescription("Dummy Descripion 2");
    	promo.setPromotionEndDate(new Date());
    	promo.setPromotionEndDate(new Date());
        //selfLink = new Link("./promotion/"+promo.getId());
        //productList.add(new Resource<Promotion>(promo, selfLink));
        
        promolist.add(promo);
        //Resources<Resource<Promotion>> wrapped = new Resources<Resource<Promotion>>(productList, new Link(
		//		"/promotion", "describedBy"));
        //return wrapped;
        return (Promotion[])promolist.toArray();
	}
}
