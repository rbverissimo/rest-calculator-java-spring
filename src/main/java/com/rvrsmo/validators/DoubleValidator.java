package com.rvrsmo.validators;

public class DoubleValidator {
	
	public static Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(NumericValidator.isNumeric(number)) return Double.parseDouble(number);
		return null; 
	}


}
