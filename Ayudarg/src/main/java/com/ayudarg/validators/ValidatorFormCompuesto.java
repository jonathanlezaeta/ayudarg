package com.ayudarg.validators;

import java.util.ArrayList;

public class ValidatorFormCompuesto extends ValidatorForm{

	public ValidatorFormCompuesto(ArrayList<ValidatorForm> validators){
		this.validators = validators;
	}
	
	private ArrayList<ValidatorForm> validators;
	
	@Override
	public boolean validate() {
		for(ValidatorForm v : validators){
			v.setValues(this.getValues());
			if(v.validate()){
				error = v.getError();
				return true;
			}
		}
		return false;
	}

	public ArrayList<ValidatorForm> getValidators() {
		return validators;
	}

	public void setValidators(ArrayList<ValidatorForm> validators) {
		this.validators = validators;
	}

}
