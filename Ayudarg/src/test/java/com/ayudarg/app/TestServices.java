package com.ayudarg.app;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ayudarg.service.UsuarioService;
import com.ayudarg.services.impl.UsuarioServiceImpl;

public class TestServices {

	private UsuarioService serviceUsuarios;
	
	@Autowired(required=true)
	@Qualifier(value="UsuarioService")
	public void setPersonService(UsuarioService ps){
		this.serviceUsuarios = ps;
	}
	
	
	@Test
	public void test() {
		serviceUsuarios.listUsuarios();
		System.out.println("paso");
	}

}
