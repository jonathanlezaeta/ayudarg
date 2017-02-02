package com.ayudarg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categoria")

public class Categoria {

	@Id
	@Column(name="idCategoria")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
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
