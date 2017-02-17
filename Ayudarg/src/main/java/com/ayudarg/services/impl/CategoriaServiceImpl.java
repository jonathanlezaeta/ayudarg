package com.ayudarg.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ayudarg.dao.CategoriaDAO;
import com.ayudarg.model.Categoria;
import com.ayudarg.service.CategoriaService;

@Transactional
public class CategoriaServiceImpl implements CategoriaService{
	
	private CategoriaDAO categoriaDao;
	
	@Override
	public List<Categoria> listCategorias() {
		return categoriaDao.listCategorias();
	}

	public CategoriaDAO getCategoriaDao() {
		return categoriaDao;
	}

	public void setCategoriaDao(CategoriaDAO categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	@Override
	public void insertCategoria(String nombre, String subcategorias ) {
		categoriaDao.insertCategoria(nombre, subcategorias);
		
	}
	
	@Override
	public void deleteCategoria(String categoria) {
		categoriaDao.deleteCategoria(categoria);
		
	}


}
