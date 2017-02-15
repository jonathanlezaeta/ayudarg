package com.ayudarg.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.ayudarg.model.Categoria;

public interface CategoriaDAO {
	public List<Categoria> listCategorias();
	void insertCategoria(String nombre, ArrayList<Categoria> subcategorias);
}
