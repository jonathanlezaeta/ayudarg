package com.ayudarg.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ayudarg.dao.InstitucionDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Institucion;
import com.ayudarg.model.Usuario;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.UsuarioService;

public class InstitucionServiceImpl implements InstitucionService{
	
	private InstitucionDAO institucionDao;
	
	@Transactional
	@Override
	public List<Institucion>listInstituciones(){
		return institucionDao.listInstituciones();
	}

	public InstitucionDAO getInstitucionDao() {
		return institucionDao;
	}

	public void setInstitucionDao(InstitucionDAO institucionDao) {
		this.institucionDao = institucionDao;
	}

}
