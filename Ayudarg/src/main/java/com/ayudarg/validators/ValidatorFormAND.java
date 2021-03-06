package com.ayudarg.validators;


public class ValidatorFormAND extends ValidatorForm{

	private ValidatorForm v1;
	private ValidatorForm v2;
	
	public ValidatorFormAND(ValidatorForm v1, ValidatorForm v2){
		this.v1 = v1;
		this.v2 = v2;
	}
	
	@Override
	public boolean validate() {
		return v1.validate() && v2.validate();
	}
	
}
