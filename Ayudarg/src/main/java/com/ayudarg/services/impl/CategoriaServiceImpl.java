package com.ayudarg.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ayudarg.dao.CategoriaDAO;
import com.ayudarg.dao.UsuarioDAO;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.Usuario;
import com.ayudarg.service.CategoriaService;
import com.ayudarg.service.UsuarioService;

public class CategoriaServiceImpl implements CategoriaService{
	
	private CategoriaDAO categoriaDao;
	
	@Transactional
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
	public void insertCategoria(int idCategoria, String nombre, Date fechaCreacion, int categoriaIdCategoria) {
		categoriaDao.insertCategoria(idCategoria, nombre, fechaCreacion, categoriaIdCategoria);
		
	}

}
