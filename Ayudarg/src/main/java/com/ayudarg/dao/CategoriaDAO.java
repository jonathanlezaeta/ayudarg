package com.ayudarg.dao;

import java.util.List;
import com.ayudarg.model.Categoria;

public interface CategoriaDAO {
	public List<Categoria> listCategorias();
	public void insertCategoria(String nombre, String subcategorias);
	public Categoria getCategoriaById(String id);
	public void deleteCategoria(String categoria);
	public void updateCategoria(String idcategoria, String nombre, String subcategorias);
}
