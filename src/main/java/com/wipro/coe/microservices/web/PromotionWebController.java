package com.wipro.coe.microservices.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.coe.microservices.web.controller.PromotionBackendController;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PromotionWebController {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PromotionWebController.class);
	
	@Autowired
	PromotionBackendController  promotionController;
	
	//value only for checking which configs are being read
    @Value("${hello.world}")
    String  someValue;
    
	
    //Validate security etc
    @RequestMapping("/managepromotion")
   public String getPromotion(Model model  ) {
        
        log.debug("Checking the values set from which config location:" , someValue);
        return "staticpromotions";
    }

}
