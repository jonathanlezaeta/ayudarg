package com.ayudarg.validators;

import java.util.Map.Entry;

public class ValidatorFormLengthMenor extends ValidatorForm{

	private int val;
	
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public ValidatorFormLengthMenor(int val){
		this.val = val;
	}
	
	@Override
	public boolean validate() {
		for (Entry<String, String> clave : values.entrySet()) {
			   if(Integer.parseInt(clave.getValue()) < val){
				   error = "El campo "+ clave.getKey() + "no puede ser mayor a "+ val + ".";
				   return false;
			   }
			}
			return true;
	}

}
