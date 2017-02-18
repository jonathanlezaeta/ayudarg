package com.ayudarg.dao;

import java.sql.Date;
import java.util.List;

import com.ayudarg.model.Categoria;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.RecursoSQL;

public interface RecursoDAO {
	public List<RecursoSQL> listRecursos();
	Categoria getCategoriaById(String id);
	InstitucionSQL getInstitucionById(String idIns);
	public void insertRecurso(String nombre, String cantidad, String categoria, String institucion);
	void deleteRecurso(String nombre, String categoria);
}
