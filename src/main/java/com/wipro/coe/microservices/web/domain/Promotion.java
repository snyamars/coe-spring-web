package com.wipro.coe.microservices.web.domain;

import java.util.Date;
import java.util.List;


public class Promotion {
	
	private Long id;
	
	private String description;

	private Date promotionStartDate;
	
	private Date promotionEndDate;
	
	private String promotionOwnerName;
	
	
	private String lastAction;
	
	
	private String lastActionBy;
	
	private boolean checked;

	private List<Offer> offers ;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPromotionStartDate() {
		return promotionStartDate;
	}

	public void setPromotionStartDate(Date promotionStartDate) {
		this.promotionStartDate = promotionStartDate;
	}

	public Date getPromotionEndDate() {
		return promotionEndDate;
	}

	public void setPromotionEndDate(Date promotionEndDate) {
		this.promotionEndDate = promotionEndDate;
	}

	public String getPromotionOwnerName() {
		return promotionOwnerName;
	}

	public void setPromotionOwnerName(String promotionOwnerName) {
		this.promotionOwnerName = promotionOwnerName;
	}

	public String getLastAction() {
		return lastAction;
	}

	public void setLastAction(String lastAction) {
		this.lastAction = lastAction;
	}

	public String getLastActionBy() {
		return lastActionBy;
	}

	public void setLastActionBy(String lastActionBy) {
		this.lastActionBy = lastActionBy;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", description=" + description + ", promotionStartDate=" + promotionStartDate
				+ ", promotionEndDate=" + promotionEndDate + ", promotionOwnerName=" + promotionOwnerName
				+ ", lastAction=" + lastAction + ", lastActionBy=" + lastActionBy + ", offers=" + offers + "]";
	}
	
	
	

}
