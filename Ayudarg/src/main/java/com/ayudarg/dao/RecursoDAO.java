package com.ayudarg.dao;

import java.sql.Date;
import java.util.List;
import com.ayudarg.model.Recurso;

public interface RecursoDAO {
	public List<Recurso> listRecursos();
	void insertRecurso(int idRecurso, String nombre, Date fechaCreacion, int usuarioIdUsuario, int usuarioRolIdRol,
			int institucionIdInstitucion, int cantidad);
}
