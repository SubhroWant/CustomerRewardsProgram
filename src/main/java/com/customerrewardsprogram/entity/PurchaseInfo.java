package com.customerrewardsprogram.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.customerrewardsprogram.utils.CommonUtils;

public class PurchaseInfo {
	private Integer purchaseId;
	private Integer customerId;
	private Date dateOfPurchase;
	private Double purchaseAmount;
	
	public PurchaseInfo(Integer purchaseId, Integer customerId, Date dateOfPurchase, Double purchaseAmount) {
		this.purchaseId = purchaseId;
		this.customerId = customerId;
		this.dateOfPurchase = dateOfPurchase;
		this.purchaseAmount = purchaseAmount;
	}
	public Integer getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public Double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(Double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	
	public Integer getReward() {
		return CommonUtils.calculateRewards(this.purchaseAmount);
	}

	public String getPurchaseMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
		return sdf.format(this.dateOfPurchase);
	}
}
