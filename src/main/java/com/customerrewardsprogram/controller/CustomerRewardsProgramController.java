package com.customerrewardsprogram.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerrewardsprogram.exception.CustomerRewardsProgramException;
import com.customerrewardsprogram.models.responsemodels.ResponseModel;
import com.customerrewardsprogram.service.CustomerRewardsProgramService;
import com.customerrewardsprogram.utils.CustomerRewardsProgramConstants;

@RestController
@RequestMapping(path = "/customerRewardsProgram")
public class CustomerRewardsProgramController {

	@Autowired
	CustomerRewardsProgramService customerRewardsProgramService;

	/*
	 * Purpose : Get total reward of single Customer
	 * */
	@GetMapping(path = "/getTotalRewardsByCustomerId/customerId/{customerId}")
	public ResponseEntity<ResponseModel> getTotalRewardsByCustomerId(
			@PathVariable(name = "customerId", required = true) Integer customerId) {
		ResponseModel response = null;
		HttpStatus responseHttpStatus = null;
		try {
			if (customerRewardsProgramService.validateCustomerId(customerId)) {
				Integer totalRewards = customerRewardsProgramService.getTotalRewardsByCustomerId(customerId);
				response = new ResponseModel();
				response.setRequestStatus(CustomerRewardsProgramConstants.SUCCESS);
				response.setResponseMessage(CustomerRewardsProgramConstants.SUCCESS);
				response.setStatusCode(CustomerRewardsProgramConstants.GLOBAL_SUCCESS_CODE);
				responseHttpStatus = HttpStatus.OK;
				response.setResponse(totalRewards);
			}

		} catch (CustomerRewardsProgramException ex) {
			response = new ResponseModel();
			response.setRequestStatus(CustomerRewardsProgramConstants.FAILURE);
			response.setResponseMessage(ex.getMessage());
			response.setStatusCode(ex.getErrorCode());
			responseHttpStatus = ex.getHttpStatus();
		} catch (Exception ex) {
			response = new ResponseModel();
			response.setRequestStatus(CustomerRewardsProgramConstants.FAILURE);
			response.setResponseMessage(ex.getMessage());
			response.setStatusCode(CustomerRewardsProgramConstants.GLOBAL_EXCEPTION_CODE);
			responseHttpStatus = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<>(response, responseHttpStatus);
	}
	
	
	/**
	 * Purpose : Get rewards of a Customer by month
	 **/
	@GetMapping(path = "/getRewardsOfCustomerByMonth/customerId/{customerId}")
	public ResponseEntity<ResponseModel> getRewardsOfCustomerByMonth(
			@PathVariable(name = "customerId", required = true) Integer customerId) {
		ResponseModel response = null;
		HttpStatus responseHttpStatus = null;
		try {
			if (customerRewardsProgramService.validateCustomerId(customerId)) {
				Map<String, Integer> rewardsByMonths = customerRewardsProgramService
						.getRewardsOfCustomerByMonth(customerId);
				response = new ResponseModel();
				response.setRequestStatus(CustomerRewardsProgramConstants.SUCCESS);
				response.setResponseMessage(CustomerRewardsProgramConstants.SUCCESS);
				response.setStatusCode(CustomerRewardsProgramConstants.GLOBAL_SUCCESS_CODE);
				responseHttpStatus = HttpStatus.OK;
				response.setResponse(rewardsByMonths);
			}

		} catch (CustomerRewardsProgramException ex) {
			response = new ResponseModel();
			response.setRequestStatus(CustomerRewardsProgramConstants.FAILURE);
			response.setResponseMessage(ex.getMessage());
			response.setStatusCode(ex.getErrorCode());
			responseHttpStatus = ex.getHttpStatus();
		} catch (Exception ex) {
			response = new ResponseModel();
			response.setRequestStatus(CustomerRewardsProgramConstants.FAILURE);
			response.setResponseMessage(ex.getMessage());
			response.setStatusCode(CustomerRewardsProgramConstants.GLOBAL_EXCEPTION_CODE);
			responseHttpStatus = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<>(response, responseHttpStatus);
	}
	
	
	
	/**
	 * Purpose : Get Total rewards of Customer by Customer
	 * */
	@GetMapping(path = "/getTotalRewardsByCustomer")
	public ResponseEntity<ResponseModel> getTotalRewardsByCustomer() {
		ResponseModel response = null;
		HttpStatus responseHttpStatus = null;
		try {
			Map<String, Integer> rewardsByMonths = customerRewardsProgramService.getTotalRewardsByCustomer();
			response = new ResponseModel();
			response.setRequestStatus(CustomerRewardsProgramConstants.SUCCESS);
			response.setResponseMessage(CustomerRewardsProgramConstants.SUCCESS);
			response.setStatusCode(CustomerRewardsProgramConstants.GLOBAL_SUCCESS_CODE);
			responseHttpStatus = HttpStatus.OK;
			response.setResponse(rewardsByMonths);
		} catch (Exception ex) {
			response = new ResponseModel();
			response.setRequestStatus(CustomerRewardsProgramConstants.FAILURE);
			response.setResponseMessage(ex.getMessage());
			response.setStatusCode(CustomerRewardsProgramConstants.GLOBAL_EXCEPTION_CODE);
			responseHttpStatus = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<>(response, responseHttpStatus);
	}
	
	/**
	 * Purpose : Check base URL accessible
	 * */
	@GetMapping(path = "/")
	public String testURL() {
		return CustomerRewardsProgramConstants.SUCCESS;
	}

}
