package com.ayudarg.service;

import java.util.List;
import com.ayudarg.model.Categoria;

public interface CategoriaService {
	public List<Categoria> listCategorias();
	void insertCategoria(String nombre, String subcategorias);
	void deleteCategoria(String categoria);
}
