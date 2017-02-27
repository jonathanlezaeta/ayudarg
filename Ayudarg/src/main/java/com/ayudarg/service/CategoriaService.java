package com.ayudarg.service;

import java.util.List;
import com.ayudarg.model.Categoria;

public interface CategoriaService {
	public List<Categoria> listCategorias();
	public void insertCategoria(String nombre, String subcategorias);
	public void deleteCategoria(String categoria);
	public Categoria getCategoriaById(String idCategoria);
	public void updateCategoria(String idCategoria, String nombre, String subcategorias);
}
