package com.ayudarg.service;

import java.util.List;

import com.ayudarg.model.InstitucionSQL;

public interface InstitucionService {
	public List<InstitucionSQL> listInstituciones();
	public void insertInstitucion(String director, String ciudad, String tipo, String nombre, String direccion,
			String telefono, String celular, String sitioWeb, String email);
	void deleteInstitucion(String institucionBean);
}
