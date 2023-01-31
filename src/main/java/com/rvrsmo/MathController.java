package com.rvrsmo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rvrsmo.exception.UnsupportedMathOperationException;
import com.rvrsmo.validators.DoubleValidator;
import com.rvrsmo.validators.NumericValidator;

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
		
		if(!NumericValidator.isNumeric(numberOne) || 
				!NumericValidator.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please a set a numeric value");
		}
		return DoubleValidator.convertToDouble(numberOne) 
				+ DoubleValidator.convertToDouble(numberTwo);
	}
	

	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception {
		if(!NumericValidator.isNumeric(numberOne) ||
				!NumericValidator.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please a set a numeric value");
		}
		return DoubleValidator.convertToDouble(numberOne) 
				- DoubleValidator.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double mult(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception  {
		
		if(!NumericValidator.isNumeric(numberOne) || 
				!NumericValidator.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please a set a numeric value");
		}
		return DoubleValidator.convertToDouble(numberOne) 
				* DoubleValidator.convertToDouble(numberTwo); 
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double div(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception  {
		
		if(!NumericValidator.isNumeric(numberOne) || 
				!NumericValidator.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please a set a numeric value");
		}
		return DoubleValidator.convertToDouble(numberOne) 
				/ DoubleValidator.convertToDouble(numberTwo);  
	}
	
	
	@RequestMapping(value="/med/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double med(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo
			) throws Exception  {
		
		if(!NumericValidator.isNumeric(numberOne) ||
				!NumericValidator.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(
					"Please a set a numeric value");
		}
		return (DoubleValidator.convertToDouble(numberOne) 
				+ DoubleValidator.convertToDouble(numberTwo))/ 2 ;  
	}
	
	
	@RequestMapping(value="/sqr/{number}",
			method=RequestMethod.GET)
	public Double sqrRoot(
			@PathVariable(value="number") String number
			) throws Exception  {
		
		if(!NumericValidator.isNumeric(number)) {
			throw new UnsupportedMathOperationException(
					"Please a set a numeric value");
		}
		return Math.sqrt(DoubleValidator.convertToDouble(number)) ;  
	}
	
	

}
