package com.ayudarg.service;

import java.sql.Date;
import java.util.List;

import com.ayudarg.model.Recurso;

public interface RecursoService {
	public List<Recurso> listRecursos();
	public void insertRecurso(int categoriaIdCategoria, String nombre, Date fechaCreacion, int intistucionIdInstitucion, int cantidad, boolean activo);
}
