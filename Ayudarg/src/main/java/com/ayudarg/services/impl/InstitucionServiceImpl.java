package com.ayudarg.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ayudarg.dao.InstitucionDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.UsuarioSQL;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.UsuarioService;

@Transactional
public class InstitucionServiceImpl implements InstitucionService{
	
	private InstitucionDAO institucionDao;
	

	@Override
	public List<InstitucionSQL>listInstituciones(){
		return institucionDao.listInstituciones();
	}

	public InstitucionDAO getInstitucionDao() {
		return institucionDao;
	}

	public void setInstitucionDao(InstitucionDAO institucionDao) {
		this.institucionDao = institucionDao;
	}


	@Override
	public void insertInstitucion(String director, String ciudad, String tipo, String nombre, String direccion,
			String telefono, String celular, String sitioWeb, String email, String localidadesId) {
		institucionDao.insertInstitucion(director, ciudad, tipo, nombre, direccion, telefono, celular, sitioWeb, email, localidadesId);
		
	}
	
	@Override
	public void deleteInstitucion(String institucion) {
		institucionDao.deleteInstitucion(institucion);
		
	}
	
	public void updateInstitucion(String institucion, String director, String ciudad, String tipo, String nombre, String direccion,
			String telefono, String celular, String sitioWeb, String email, String localidadesId){
		institucionDao.updateInstitucion(institucion, director, ciudad, tipo, nombre, direccion, telefono, celular, sitioWeb, email, localidadesId);
	}

	public List<InstitucionSQL> getInstitucionesByCategoriaByLocalidd(String idLocalidd, String[] categorias){
		return institucionDao.getInstitucionesByCategoriaByLocalidd(idLocalidd, categorias);
	}
	
}
