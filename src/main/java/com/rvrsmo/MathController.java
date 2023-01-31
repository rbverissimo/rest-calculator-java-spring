package com.rvrsmo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value="numberOne") String numberOne,
			@PathVariable(value="numberTwo") String numberTwo) 
					throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}
		return convertToDouble(numberOne) 
				+ convertToDouble(numberTwo);
	}
	

	


	public Double sub() {
		return 1D;
	}
	
	public Double mult() {
		return 1D; 
	}
	
	public Double div() {
		return 1D; 
	}
	
	
	private boolean isNumeric(String numberOne) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private double convertToDouble(String numberOne) {
		// TODO Auto-generated method stub
		return 0D;
	}

}