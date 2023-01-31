package com.rvrsmo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rvrsmo.exception.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	@SuppressWarnings("unused")
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo) 
					throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please a set a numeric value");
		}
		return convertToDouble(numberOne) 
				+ convertToDouble(numberTwo);
	}
	

	

	@RequestMapping(value="/sub/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please a set a numeric value");
		}
		return convertToDouble(numberOne) 
				- convertToDouble(numberTwo);
	}
	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double mult(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception  {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please a set a numeric value");
		}
		return convertToDouble(numberOne) 
				* convertToDouble(numberTwo); 
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double div(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception  {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please a set a numeric value");
		}
		return convertToDouble(numberOne) 
				/ convertToDouble(numberTwo);  
	}
	
	
	@RequestMapping(value="/med/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double med(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception  {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please a set a numeric value");
		}
		return (convertToDouble(numberOne) 
				+ convertToDouble(numberTwo))/ 2 ;  
	}
	
	
	@RequestMapping(value="/sqr/{number}",
			method=RequestMethod.GET)
	public Double sqrRoot(
			@PathVariable(value="number") String number
			) throws Exception  {
		
		if(!isNumeric(number)) {
			throw new UnsupportedMathOperationException(
					"Please a set a numeric value");
		}
		return Math.sqrt(convertToDouble(number)) ;  
	}
	
	
	
	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	
	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return null; 
	}

}
