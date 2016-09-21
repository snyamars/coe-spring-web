package com.wipro.coe.microservices.web.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *    "http://wso2.org/claims/username" : "opsUser",
    "sub" : "opsUser@carbon.super",
    "http://wso2.org/gateway/applicationname" : "OpenAppService",
    "http://wso2.org/claims/role" : "Application/OpenAppService,opsAdmin,Internal/everyone",
    "http://wso2.org/claims/fullname" : "opsUser",
    "iss" : "http://wso2.org/gateway",
    "http://wso2.org/claims/lastname" : "opsUser",
    "exp" : 1474494422,
    "iat" : 1474490599,
    "http://wso2.org/gateway/subscriber" : "admin@carbon.super",
    "http://wso2.org/gateway/enduser" : "opsUser@carbon.super"
 * 
 * 
 * 
 * @author root
 *
 */

@JsonSerialize
public class JsonClaimObject implements Serializable {
	
	@JsonProperty(value="http://wso2.org/claims/username")
	String username;
	
	@JsonProperty(value="http://wso2.org/claims/role")
	String role;
	
	@JsonProperty( value="http://wso2.org/claims/fullname")
	String fullname;
	
	String sub;
	
	String iss;
	
	@JsonProperty(value="http://wso2.org/claims/lastname")
	String lastname;
	
	Long exp;
	
	Long iat;
 
	@JsonProperty(value="http://wso2.org/gateway/subscriber")
	String subscriber;
	
	@JsonProperty(value="http://wso2.org/gateway/enduser")
	String enduser;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getExp() {
		return exp;
	}

	public void setExp(Long exp) {
		this.exp = exp;
	}

	public Long getIat() {
		return iat;
	}

	public void setIat(Long iat) {
		this.iat = iat;
	}

	public String getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

	public String getEnduser() {
		return enduser;
	}

	public void setEnduser(String enduser) {
		this.enduser = enduser;
	}

	@Override
	public String toString() {
		return "JsonClaimObject [username=" + username + ", role=" + role + ", fullname=" + fullname + ", sub=" + sub
				+ ", iss=" + iss + ", lastname=" + lastname + ", exp=" + exp + ", iat=" + iat + ", subscriber="
				+ subscriber + ", enduser=" + enduser + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
		

}
