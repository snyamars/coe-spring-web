package com.wipro.coe.microservices.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.wipro.coe.microservices.web.controller.PromotionBackendController;
import com.wipro.coe.microservices.web.domain.AuthorizationClaimsHolderDTO;
import com.wipro.coe.microservices.web.domain.AuthorizationContextTokenHolderDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PromotionWebController {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PromotionWebController.class);

	@Autowired
	PromotionBackendController promotionController;

	// value only for checking which configs are being read
	@Value("${hello.world}")
	String someValue;

	@Value("${config.security.identity_server_ip}")
	String identity_server;

	@Value("${config.security.identity_server_port}")
	String identity_server_port;

	@Value("${app_key}")
	String app_key;

	@Value("${app_secret}")
	String app_secret;

	// Validate security etc
	@RequestMapping("/managepromotion")
	public String getPromotion(Model model) {

		log.debug("Checking the values set from which config location:", someValue);
		return "staticpromotions";
	}

	// Validate security etc
	@RequestMapping("/login")
	public String getLogin(Model model) {

		log.debug("Checking the values set from which config location:", someValue);
		return "login";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticate(@RequestParam("login") String loginName, @RequestParam("password") String password)
			throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();


		
		Map<String, String> map = new HashMap<String, String>();
		map.put("resOwner", loginName);
		map.put("resPass", password);
		map.put("appKey", app_key);
		map.put("appSecret", app_secret);

		HttpHeaders headers = new HttpHeaders();
		headers.setAll(map);

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		URI url = new URI(
				"http://" + identity_server + ":" + identity_server_port + "/identityoauth-1.0/oauth/gettoken");

		ResponseEntity<AuthorizationContextTokenHolderDTO> responseentity = restTemplate.exchange(url, HttpMethod.GET,
				entity, AuthorizationContextTokenHolderDTO.class);

		String jwttoken = responseentity.getBody().getAuthorizationContextToken().getTokenString();

		Map<String, String> rolemap = new HashMap<String, String>();
		rolemap.put("jwtToken", jwttoken);
		rolemap.put("appKey", app_key);
		rolemap.put("appSecret", app_secret);

		headers = new HttpHeaders();
		headers.setAll(rolemap);
		entity = new HttpEntity<String>(headers);
		URI roleurl = new URI(
				"http://" + identity_server + ":" + identity_server_port + "/identityoauth-1.0/oauth/gettokendetails");

		ResponseEntity<AuthorizationClaimsHolderDTO> responseentity1 = restTemplate.exchange(roleurl, HttpMethod.GET,
				entity, AuthorizationClaimsHolderDTO.class);

		String role = responseentity1.getBody().getJsonClaimObject().getRole();

		if (role.contains("opsAdmin"))
			return "staticpromotions";
		else if (!role.isEmpty() && !role.contains("opsAdmin"))
			return "listonlypromotions";
		else
			return "logindenied";
	}
}
