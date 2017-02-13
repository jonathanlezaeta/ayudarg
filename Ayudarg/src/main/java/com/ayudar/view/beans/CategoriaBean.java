package com.ayudar.view.beans;

import java.sql.Date;

public class CategoriaBean {
	
	private int idCategoria;
	private String nombre;
	private Date fechaCreacion;
	private int categoriaIdCategoria;
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getCategoriaIdCategoria() {
		return categoriaIdCategoria;
	}
	public void setCategoriaIdCategoria(int categoriaIdCategoria) {
		this.categoriaIdCategoria = categoriaIdCategoria;
	}
	

}
