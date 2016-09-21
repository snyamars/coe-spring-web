package com.wipro.coe.microservices.web.domain;

import java.io.Serializable;

public class JsonHeaderObject implements Serializable {
	
	String x5t;
	String alg;
	public String getX5t() {
		return x5t;
	}
	public void setX5t(String x5t) {
		this.x5t = x5t;
	}
	public String getAlg() {
		return alg;
	}
	public void setAlg(String alg) {
		this.alg = alg;
	}
	@Override
	public String toString() {
		return "JsonHeaderObject [x5t=" + x5t + ", alg=" + alg + "]";
	}
	
	
	
	

}
