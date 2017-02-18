package com.ayudarg.service;

import java.sql.Date;
import java.util.List;

import com.ayudarg.model.RecursoSQL;

public interface RecursoService {
	public List<RecursoSQL> listRecursos();
	public void insertRecurso(String nombre, String cantidad, String categoria, String institucion);
	public void deleteRecurso(String nombre, String categoria);
}
