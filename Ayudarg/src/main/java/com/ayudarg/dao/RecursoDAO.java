package com.ayudarg.dao;

import java.sql.Date;
import java.util.List;
import com.ayudarg.model.Recurso;

public interface RecursoDAO {
	public List<Recurso> listRecursos();
	void insertRecurso(int categoriaIdCategoria, String nombre, Date fechaCreacion, int institucionIdInstitucion, int cantidad, boolean activo);
}
