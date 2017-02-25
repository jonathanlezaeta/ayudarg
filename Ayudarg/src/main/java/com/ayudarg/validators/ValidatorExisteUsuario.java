package com.ayudarg.validators;

import java.util.Map.Entry;

import com.ayudarg.model.UsuarioSQL;
import com.ayudarg.service.UsuarioService;

public class ValidatorExisteUsuario extends ValidatorForm{
	private UsuarioService serviceUsuarios; 
	
	public ValidatorExisteUsuario(UsuarioService serviceUsuarios){
		this.serviceUsuarios = serviceUsuarios;
	}
	
	@Override
	public boolean validate() {
		if(values.get("email") != null){
			UsuarioSQL us = serviceUsuarios.getUsuarioByEmail(values.get("email"));
			if(us != null){
				error = "Ya existe un usuario registrado con el mail: "+ us.getEmail();
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	public UsuarioService getServiceUsuarios() {
		return serviceUsuarios;
	}

	public void setServiceUsuarios(UsuarioService serviceUsuarios) {
		this.serviceUsuarios = serviceUsuarios;
	}
}
