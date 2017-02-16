package com.ayudarg.dao;

import java.sql.Date;
import java.util.List;

import com.ayudarg.model.Categoria;
import com.ayudarg.model.Institucion;
import com.ayudarg.model.Recurso;

public interface RecursoDAO {
	public List<Recurso> listRecursos();
	Categoria getCategoriaById(String id);
	Institucion getInstitucionById(String idIns);
	public void insertRecurso(String nombre, String cantidad, String categoria, String institucion);
	void deleteRecurso(String nombre, String categoria);
}
