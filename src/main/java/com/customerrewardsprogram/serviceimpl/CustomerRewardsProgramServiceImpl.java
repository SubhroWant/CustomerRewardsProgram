package com.customerrewardsprogram.serviceimpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.customerrewardsprogram.entity.CustomerPurchaseInfo;
import com.customerrewardsprogram.entity.PurchaseInfo;
import com.customerrewardsprogram.exception.CustomerRewardsProgramException;
import com.customerrewardsprogram.repository.PurchaseInfoRepo;
import com.customerrewardsprogram.service.CustomerRewardsProgramService;
import com.customerrewardsprogram.utils.CustomerRewardsProgramConstants;

@Service
public class CustomerRewardsProgramServiceImpl implements CustomerRewardsProgramService{
	
	@Autowired
	PurchaseInfoRepo purchaseInfoRepo;
	
	public boolean validateCustomerId(Integer customerId) throws Exception {
		Map<Integer, CustomerPurchaseInfo> mapCustomerPurchaseInfo = PurchaseInfoRepo.getPurchaseInfoDetails();
		if(mapCustomerPurchaseInfo.keySet().contains(customerId)) {
			return true;
		}else {
			throw new CustomerRewardsProgramException("Invalid Customer Id", CustomerRewardsProgramConstants.CUSTOMER_ID_ERROR_CODE, HttpStatus.BAD_REQUEST);
		}
	}
	
	public Integer getTotalRewardsByCustomerId(Integer customerId) throws Exception{		
		Map<Integer, CustomerPurchaseInfo> mapCustomerPurchaseInfo = PurchaseInfoRepo.getPurchaseInfoDetails();		
		Integer totalRewards = mapCustomerPurchaseInfo.get(customerId).getLstPurchaseInfo().stream().reduce(0, 
				(partialResult, purchase) -> partialResult + purchase.getReward(), Integer::sum);
		
		return totalRewards;
	}
	
	public Map<String, Integer> getRewardsOfCustomerByMonth(Integer customerId) throws Exception{
		Map<Integer, CustomerPurchaseInfo> mapCustomerPurchaseInfo = PurchaseInfoRepo.getPurchaseInfoDetails();
		List<PurchaseInfo> lstPurchaseInfo = mapCustomerPurchaseInfo.get(customerId).getLstPurchaseInfo();		
		Map<String, Integer> rewardsByMonths = lstPurchaseInfo.stream().collect(Collectors.groupingBy(PurchaseInfo::getPurchaseMonth, 
				Collectors.summingInt(PurchaseInfo::getReward)));
		
		return rewardsByMonths;
	}
	
	public Map<String, Integer> getTotalRewardsByCustomer() throws Exception{
		Map<Integer, CustomerPurchaseInfo> mapCustomerPurchaseInfo = PurchaseInfoRepo.getPurchaseInfoDetails();
		Map<String, Integer> rewardsByCustomer = mapCustomerPurchaseInfo.values().stream().collect(
				Collectors.toMap(CustomerPurchaseInfo::getCustomerName, customerPurchaseInfo -> customerPurchaseInfo.getLstPurchaseInfo().stream().reduce(0, 
						(partialResult, purchase) -> partialResult + purchase.getReward(), Integer::sum)));
		
		return rewardsByCustomer;
	}
	
}