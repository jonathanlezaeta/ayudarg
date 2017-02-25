package com.ayudarg.validators;

import java.util.HashMap;

public abstract class ValidatorForm {
	
	protected HashMap<String, String> values;
	protected String error;
	
	public abstract boolean validate();

	public HashMap<String, String> getValues() {
		return values;
	}

	public void setValues(HashMap<String, String> values) {
		this.values = values;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
