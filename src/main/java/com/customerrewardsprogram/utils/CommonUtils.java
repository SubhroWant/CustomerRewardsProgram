package com.customerrewardsprogram.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
	
	public static Date getDateFromString(String strDate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.parse(strDate);
	}
	
	public static Integer calculateRewards(Double purchaseAmount) {
		Integer totalRewards = 0;
		if (purchaseAmount > 100.00) {
			totalRewards = (purchaseAmount.intValue() - 100) * 2 + 50;
		} else if (purchaseAmount > 50) {
			totalRewards = purchaseAmount.intValue() - 50;
		}
		return totalRewards;
	}

}
