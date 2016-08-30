package com.wipro.coe.microservices.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.coe.microservices.web.domain.Promotion;
import com.wipro.coe.microservices.web.service.PromotionController;

@Controller
public class PromotionWebController {
	

	
	@Autowired
	PromotionController  promotionController;
	
    @Value("${hello.world}")
    String  someValue;
    
	
    //Validate security etc
    @RequestMapping("/managepromotion")
   public String getPromotion(Model model  ) {
        
        Long id = 119L;
    	Promotion promotion = new Promotion();
        promotion.setId(id);
        promotion.setDescription("added via feign 9");
        promotion.setLastAction("add");
        promotion.setLastActionBy("Ranajit 9Jana");
        promotion.setPromotionEndDate(new Date());
        promotion.setPromotionStartDate(new Date());
        promotion.setPromotionOwnerName("RJ 9dosp Feign");
        
        
        promotionController.save(promotion);
        
    	Resources<Resource<Promotion>> promotions = promotionController.getPromotions();
        System.out.println(" \n\n\n\nPromotion returned from the service layer -" + promotions);;

        promotion.setDescription("added via feign 5 updated");
        promotionController.update(id, promotion);
        
    	promotions = promotionController.getPromotions();
        System.out.println(" \n\n\n\nPromotion returned from the service layer -" + promotions);;
        
        promotionController.delete(id);
        
//        Resources<Resource<Promotion>> promotionsResources = cassandraClient.getAllPromotions();
//    
//    	System.out.println(" ********  promotions : " + promotionsResources.getContent().size());
//    	
//    	
//    	Iterator<Resource<Promotion>> iterator = promotionsResources.getContent().iterator();
//    	
//    	while (iterator.hasNext())
//    	{
//    		System.out.println("\n\n\n this is the iterator object" + iterator.next().getContent().toString());
//    	}
//    	System.out.println(" ********  promotions : " + promotionsResources.getContent().iterator());
//    	
        
       promotions = promotionController.getPromotions();
       System.out.println(" \n\n\n\nPromotion returned from the service layer -" + promotions);;
       
       System.out.println(" ### some value printed got via configuration:" + someValue);
       model.addAttribute("name",promotions);
        
        return "staticpromotions";
    }

}
