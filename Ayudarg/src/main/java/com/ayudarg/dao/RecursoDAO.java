package com.ayudarg.dao;

import java.sql.Date;
import java.util.List;
import com.ayudarg.model.Recurso;

public interface RecursoDAO {
	public List<Recurso> listRecursos();
	public void insertRecurso(String nombre, Date fechaCreacion, int cantidad);
}
