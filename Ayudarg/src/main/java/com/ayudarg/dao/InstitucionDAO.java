package com.ayudarg.dao;

import java.util.List;

import com.ayudarg.model.Categoria;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.LocalidadesSQL;

public interface InstitucionDAO {
	public List<InstitucionSQL> listInstituciones();

	public void insertInstitucion(String director, String ciudad, String tipo, String nombre, String direccion,
			String telefono, String celular, String sitioWeb, String email, String localidadesId, String[] idCategoria);

	public void deleteInstitucion(String institucion);

	public InstitucionSQL getInstitucionById(String idIns);

	public List<InstitucionSQL> getInstitucionesByCategoriaByLocalidd(String idLocalidd, String[] categorias);

	public LocalidadesSQL getLocalidadesById(String id);

	void updateInstitucion(String institucion, String director, String ciudad, String tipo, String nombre,
			String direccion, String telefono, String celular, String sitioWeb, String email, String localidadesId, String[] idCategoria);

	Categoria getCategoriaById(String id);

}
