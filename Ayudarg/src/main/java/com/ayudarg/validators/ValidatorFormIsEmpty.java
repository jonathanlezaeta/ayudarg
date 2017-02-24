package com.ayudarg.validators;

import java.util.Map.Entry;

public class ValidatorFormIsEmpty extends ValidatorForm {

	@Override
	public boolean validateString() {
		for (Entry<String, String> clave : values.entrySet()) {
			if (clave.getValue() != null) {
				if (clave.getValue().isEmpty()) {
					error = "Un campo requerido no fue ingresado.";
					return true;
				}
			}
		}
		return false;
	}

}
