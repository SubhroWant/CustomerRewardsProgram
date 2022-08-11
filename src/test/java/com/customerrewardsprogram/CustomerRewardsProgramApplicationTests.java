package com.customerrewardsprogram;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import com.customerrewardsprogram.models.responsemodels.ResponseModel;
import com.customerrewardsprogram.service.CustomerRewardsProgramService;
import com.customerrewardsprogram.utils.CustomerRewardsProgramConstants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class CustomerRewardsProgramApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private CustomerRewardsProgramService customerRewardsProgramService;

	@Test
	void testURL() throws Exception{		
		String url = "http://localhost:8081/customerRewardsProgram/";
		assertThat(restTemplate.getForObject(url, String.class)).contains(CustomerRewardsProgramConstants.SUCCESS);
	}
	
	@Test
	void testWrongURL() throws Exception{
		String url = "http://localhost:8081/customerRewardsProgram/invalidUrl";
		assertEquals(403, restTemplate.getForEntity(url, String.class).getStatusCodeValue());
	}
	
	
	@Test
	void testWrongCutomerId() throws Exception{
		assertThatThrownBy(() -> customerRewardsProgramService.validateCustomerId(100)).hasMessage("Invalid Customer Id");
	}
	
	
	@Test
	void testGetTotalRewardsByCustomerId() throws Exception{
		String url = "http://localhost:8081/customerRewardsProgram/getTotalRewardsByCustomerId/customerId/1003";
		ResponseEntity<ResponseModel> response = restTemplate.getForEntity(url, ResponseModel.class);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(557, ((ResponseModel)response.getBody()).getResponse());
	}
	
	
	@Test
	void testGetRewardsOfCustomerByMonth() throws Exception{
		String url = "http://localhost:8081/customerRewardsProgram/getRewardsOfCustomerByMonth/customerId/1003";
		ResponseEntity<ResponseModel> response = restTemplate.getForEntity(url, ResponseModel.class);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(345, ((HashMap<String, Integer>)((ResponseModel)response.getBody()).getResponse()).get("March"));
	}
	
}
