package com.ayudar.view.beans;

import java.sql.Date;
import java.util.ArrayList;

import com.ayudarg.model.Categoria;

public class CategoriaBean {
	
	private String nombre;
//	private ArrayList<Categoria> categoria;
	private String categoria;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//	public ArrayList<Categoria> getCategoria() {
//		return categoria;
//	}
//	public void setCategoria(ArrayList<Categoria> categoria) {
//		this.categoria = categoria;
//	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
