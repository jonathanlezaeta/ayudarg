package com.ayudar.elasticsearch.model;

import java.util.ArrayList;
import java.util.Date;

public class RecursoModelEs {
	private String nombre;
	private Date fechaIngreso;
	private Usuario usuario;
	private Institucion institucion;
	private boolean activo;
	private ArrayList<Long> categorias;
	
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
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public ArrayList<Long> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<Long> categorias) {
		this.categorias = categorias;
	}
}
