package com.ayudarg.dao;

import java.sql.Date;
import java.util.List;

import com.ayudarg.model.Categoria;
import com.ayudarg.model.Institucion;
import com.ayudarg.model.Recurso;

public interface RecursoDAO {
	public List<Recurso> listRecursos();
	void insertRecurso(String categoriaIdCategoria, String nombre, Date fechaCreacion, String institucionIdInstitucion, int cantidad);
	Categoria getCategoriaById(String id);
	Institucion getInstitucionById(String idIns);
}
