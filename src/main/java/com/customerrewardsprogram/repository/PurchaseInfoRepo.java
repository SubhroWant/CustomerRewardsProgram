package com.customerrewardsprogram.repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.customerrewardsprogram.entity.CustomerPurchaseInfo;
import com.customerrewardsprogram.entity.PurchaseInfo;
import com.customerrewardsprogram.utils.CommonUtils;

@Repository
public class PurchaseInfoRepo {
	
	public static Map<Integer, CustomerPurchaseInfo> getPurchaseInfoDetails() throws ParseException{
		CustomerPurchaseInfo customerPurchaseInfo = null;
		Map<Integer, CustomerPurchaseInfo> mapCustomerPurchaseInfo = new HashMap<Integer, CustomerPurchaseInfo>();
		List<PurchaseInfo> lstPurchaseInfo = new ArrayList<PurchaseInfo>();
		
		Integer purchaseId = 10000;
		Integer customerId = 1000;
		
		customerId++;
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("02/02/2022"), 120.00));
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("02/03/2022"), 100.00));
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("03/22/2022"), 50.11));
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("04/20/2022"), 60.91));
		customerPurchaseInfo = new CustomerPurchaseInfo(customerId, "Scott", new ArrayList<>(lstPurchaseInfo));
		mapCustomerPurchaseInfo.put(customerPurchaseInfo.getCustomerId(), customerPurchaseInfo);
				
		lstPurchaseInfo.clear();
		
		customerId++;
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("02/02/2022"), 130.00));
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("02/04/2022"), 101.55));		
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("03/24/2022"), 56.11));
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("04/15/2022"), 150.42));
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("04/25/2022"), 60.00));
		customerPurchaseInfo = new CustomerPurchaseInfo(customerId, "Sam", new ArrayList<>(lstPurchaseInfo));
		mapCustomerPurchaseInfo.put(customerPurchaseInfo.getCustomerId(), customerPurchaseInfo);
		
		lstPurchaseInfo.clear();
		
		customerId++;
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("02/02/2022"), 15.00));
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("02/04/2022"), 101.55));		
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("03/12/2022"), 96.00));
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("03/24/2022"), 99.11));
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("03/24/2022"), 200.55));
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("04/15/2022"), 150.42));
		lstPurchaseInfo.add(new PurchaseInfo(purchaseId++, customerId, CommonUtils.getDateFromString("04/25/2022"), 60.00));
		customerPurchaseInfo = new CustomerPurchaseInfo(customerId, "Peter", new ArrayList<>(lstPurchaseInfo));
		mapCustomerPurchaseInfo.put(customerPurchaseInfo.getCustomerId(), customerPurchaseInfo);
		
		return mapCustomerPurchaseInfo;
	}

}
