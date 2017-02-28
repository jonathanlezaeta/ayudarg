package com.ayudar.elasticsearch.model;

import java.util.ArrayList;
import java.util.Date;

public class RecursoModelEs {
	private String id;
	private String nombre;
	private Date fechaIngreso;
	private Usuario usuario;
	private Institucion institucion;
	private ArrayList<Long> categorias;
	private String descripcion;
	private String cantidad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Institucion getInstitucion() {
		return institucion;
	}
	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}
	public ArrayList<Long> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<Long> categorias) {
		this.categorias = categorias;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
}
