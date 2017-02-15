package com.ayudarg.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.ayudarg.model.Categoria;

public interface CategoriaService {
	public List<Categoria> listCategorias();
	void insertCategoria(String nombre, ArrayList<Categoria> subcategorias);
}
