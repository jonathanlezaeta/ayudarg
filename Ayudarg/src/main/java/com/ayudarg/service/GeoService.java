package com.ayudarg.service;

import com.ayudarg.model.ProvinciasSQL;
import java.util.List;
import com.ayudarg.model.LocalidadesSQL;

public interface GeoService {
	public List<LocalidadesSQL> listAllLocalidades();
	public List<ProvinciasSQL> listAllProvincias();
	public List<LocalidadesSQL> getLocalidadesByIdO(String id);
}
