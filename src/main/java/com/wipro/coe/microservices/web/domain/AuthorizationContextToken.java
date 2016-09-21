package com.wipro.coe.microservices.web.domain;

import java.io.Serializable;

public class AuthorizationContextToken implements Serializable{

	String tokenType;
	
	Boolean tokenTypeSpecified;
	String tokenString;
	Boolean tokenStringSpecified;
	
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public Boolean getTokenTypeSpecified() {
		return tokenTypeSpecified;
	}
	public void setTokenTypeSpecified(Boolean tokenTypeSpecified) {
		this.tokenTypeSpecified = tokenTypeSpecified;
	}
	public String getTokenString() {
		return tokenString;
	}
	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}
	public Boolean getTokenStringSpecified() {
		return tokenStringSpecified;
	}
	public void setTokenStringSpecified(Boolean tokenStringSpecified) {
		this.tokenStringSpecified = tokenStringSpecified;
	}
	
	

}
