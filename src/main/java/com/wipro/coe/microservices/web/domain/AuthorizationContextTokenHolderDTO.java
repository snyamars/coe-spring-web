package com.wipro.coe.microservices.web.domain;

import java.io.Serializable;

public class AuthorizationContextTokenHolderDTO implements Serializable {
	
	Boolean authorizationContextTokenSpecified;
	AuthorizationContextToken authorizationContextToken;
	Boolean authorizedUserSpecified;
	String authorizedUser;
	Boolean errorMsgSpecified;
	String errorMsg;
	Boolean expiryTimeSpecified;
	Long expiryTime;
	Boolean scopeSpecified;
	Boolean validSpecified;
	Boolean valid;
	Boolean scope;
	
	
	public Boolean getAuthorizationContextTokenSpecified() {
		return authorizationContextTokenSpecified;
	}
	public void setAuthorizationContextTokenSpecified(Boolean authorizationContextTokenSpecified) {
		this.authorizationContextTokenSpecified = authorizationContextTokenSpecified;
	}
	public AuthorizationContextToken getAuthorizationContextToken() {
		return authorizationContextToken;
	}
	public void setAuthorizationContextToken(AuthorizationContextToken authorizationContextToken) {
		this.authorizationContextToken = authorizationContextToken;
	}
	public Boolean getAuthorizedUserSpecified() {
		return authorizedUserSpecified;
	}
	public void setAuthorizedUserSpecified(Boolean authorizedUserSpecified) {
		this.authorizedUserSpecified = authorizedUserSpecified;
	}
	public String getAuthorizedUser() {
		return authorizedUser;
	}
	public void setAuthorizedUser(String authorizedUser) {
		this.authorizedUser = authorizedUser;
	}
	public Boolean getErrorMsgSpecified() {
		return errorMsgSpecified;
	}
	public void setErrorMsgSpecified(Boolean errorMsgSpecified) {
		this.errorMsgSpecified = errorMsgSpecified;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Boolean getExpiryTimeSpecified() {
		return expiryTimeSpecified;
	}
	public void setExpiryTimeSpecified(Boolean expiryTimeSpecified) {
		this.expiryTimeSpecified = expiryTimeSpecified;
	}
	public Long getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(Long expiryTime) {
		this.expiryTime = expiryTime;
	}
	public Boolean getScopeSpecified() {
		return scopeSpecified;
	}
	public void setScopeSpecified(Boolean scopeSpecified) {
		this.scopeSpecified = scopeSpecified;
	}
	public Boolean getValidSpecified() {
		return validSpecified;
	}
	public void setValidSpecified(Boolean validSpecified) {
		this.validSpecified = validSpecified;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public Boolean getScope() {
		return scope;
	}
	public void setScope(Boolean scope) {
		this.scope = scope;
	}
	
	
	


}
