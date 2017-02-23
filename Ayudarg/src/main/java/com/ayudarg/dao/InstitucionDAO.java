package com.ayudarg.dao;

import java.util.List;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.LocalidadesSQL;

public interface InstitucionDAO {
	public List<InstitucionSQL> listInstituciones();

	public void insertInstitucion(String director, String ciudad, String tipo, String nombre, String direccion,
			String telefono, String celular, String sitioWeb, String email, String localidadesId);

	public void deleteInstitucion(String institucion);

	public InstitucionSQL getInstitucionById(String idIns);

	public List<InstitucionSQL> getInstitucionesByCategoriaByLocalidd(String idLocalidd, String[] categorias);

	public LocalidadesSQL getLocalidadesById(String id);

	public void updateInstitucion(String director, String ciudad, String tipo, String nombre, String direccion,
			String telefono, String celular, String sitioWeb, String email, String localidadesId);

}
