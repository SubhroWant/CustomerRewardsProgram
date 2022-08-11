package com.customerrewardsprogram.service;

import java.util.Map;

public interface CustomerRewardsProgramService {
	public boolean validateCustomerId(Integer customerId) throws Exception;
	public Integer getTotalRewardsByCustomerId(Integer customerId) throws Exception;
	public Map<String, Integer> getRewardsOfCustomerByMonth(Integer customerId) throws Exception;
	public Map<String, Integer> getTotalRewardsByCustomer() throws Exception;
}
