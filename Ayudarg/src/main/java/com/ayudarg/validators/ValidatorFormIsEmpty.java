package com.ayudarg.validators;

import java.util.Map.Entry;

public class ValidatorFormIsEmpty extends ValidatorForm{

	@Override
	public boolean validateString() {
		for (Entry<String, String> clave : values.entrySet()) {
		   if(clave.getValue().isEmpty()){
			   error = "El campo "+ clave.getKey() + "no puede ser vacio.";
			   return false;
		   }
		}
		return true;
	}
	
}
