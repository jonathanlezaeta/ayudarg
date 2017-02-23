package com.ayudarg.dao;

import java.util.List;
import com.ayudarg.model.Categoria;

public interface CategoriaDAO {
	public List<Categoria> listCategorias();
	void insertCategoria(String nombre, String subcategorias);
	Categoria getCategoriaById(String id);
	void deleteCategoria(String categoria);
	void updateCategoria(String nombre, String subcategorias);
}
