package com.ayudarg.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ayudarg.dao.LocalidadesDAO;
import com.ayudarg.dao.ProvinciasDAO;
import com.ayudarg.model.LocalidadesSQL;
import com.ayudarg.model.ProvinciasSQL;
import com.ayudarg.service.GeoService;
@Transactional
public class GeoServiceImpl implements GeoService{
	private LocalidadesDAO localidadesDao;
	private ProvinciasDAO provinciasDao;
	
	@Override
	public List<LocalidadesSQL> listAllLocalidades() {
		return localidadesDao.getAllLocalidades();
	}

	@Override
	public List<ProvinciasSQL> listAllProvincias() {
		return provinciasDao.getAllProvincias();
	}

	public LocalidadesDAO getLocalidadesDao() {
		return localidadesDao;
	}

	public void setLocalidadesDao(LocalidadesDAO localidadesDao) {
		this.localidadesDao = localidadesDao;
	}

	public ProvinciasDAO getProvinciasDao() {
		return provinciasDao;
	}

	public void setProvinciasDao(ProvinciasDAO provinciasDao) {
		this.provinciasDao = provinciasDao;
	}

	@Override
	public List<LocalidadesSQL> getLocalidadesByIdO(String id) {
		return localidadesDao.getLocalidadesByIdO(id);
	}

}
