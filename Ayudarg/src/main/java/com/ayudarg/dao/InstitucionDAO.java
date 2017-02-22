package com.ayudarg.dao;

import java.util.List;
import com.ayudarg.model.InstitucionSQL;

public interface InstitucionDAO {
	public List<InstitucionSQL> listInstituciones();
	public void insertInstitucion(String director, String ciudad, String tipo, String nombre, String direccion,
			String telefono, String celular, String sitioWeb, String email);
	public List<InstitucionSQL> buscarInstituciones();
}
