package com.ayudarg.service;

import java.sql.Date;
import java.util.List;

import com.ayudarg.model.Recurso;

public interface RecursoService {
	public List<Recurso> listRecursos();
	void insertRecurso(String nombre, Date fechaCreacion, int cantidad);
}
