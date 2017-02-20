package com.ayudarg.dao;

import java.util.List;
import com.ayudarg.model.LocalidadesSQL;

public interface LocalidadesDAO {
	public List<LocalidadesSQL> getAllLocalidades();
	public List<LocalidadesSQL> getLocalidadesByIdO(String id);
}
