package com.wipro.coe.microservices.web.domain;

import java.io.Serializable;

public class AuthorizationClaimsHolderDTO implements Serializable {

	JsonClaimObject jsonClaimObject;
	
	JsonHeaderObject jsonHeaderObject;

	public JsonClaimObject getJsonClaimObject() {
		return jsonClaimObject;
	}

	public void setJsonClaimObject(JsonClaimObject jsonClaimObject) {
		this.jsonClaimObject = jsonClaimObject;
	}

	public JsonHeaderObject getJsonHeaderObject() {
		return jsonHeaderObject;
	}

	public void setJsonHeaderObject(JsonHeaderObject jsonHeaderObject) {
		this.jsonHeaderObject = jsonHeaderObject;
	}

	@Override
	public String toString() {
		return "AuthorizationClaimsHolderDTO [jsonClaimObject=" + jsonClaimObject + ", jsonHeaderObject="
				+ jsonHeaderObject + "]";
	}
	
	
	
}
