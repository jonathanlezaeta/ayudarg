package com.ayudarg.validators;

import java.util.ArrayList;

public class ValidatorFormCompuesto extends ValidatorForm{

	private ArrayList<ValidatorForm> validators;
	
	@Override
	public boolean validateString() {
		for(ValidatorForm v : validators){
			if(!v.validateString()){
				return false;
			}
		}
		return true;
	}

	public ArrayList<ValidatorForm> getValidators() {
		return validators;
	}

	public void setValidators(ArrayList<ValidatorForm> validators) {
		this.validators = validators;
	}

}
