package com.customerrewardsprogram.entity;

import java.util.List;

public class CustomerPurchaseInfo {
	private Integer customerId;
	private String customerName;
	private List<PurchaseInfo> lstPurchaseInfo;
	
	public CustomerPurchaseInfo(Integer customerId, String customerName, List<PurchaseInfo> lstPurchaseInfo) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.lstPurchaseInfo = lstPurchaseInfo;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<PurchaseInfo> getLstPurchaseInfo() {
		return lstPurchaseInfo;
	}
	public void setLstPurchaseInfo(List<PurchaseInfo> lstPurchaseInfo) {
		this.lstPurchaseInfo = lstPurchaseInfo;
	}
	
	
}
