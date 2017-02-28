package com.ayudar.view.beans;

public class RecursoBean {
	private String id;
	private String nombre;
	private String cantidad;
	private String[] idCategoria;
	private String descripcion;
	private String idInstitucion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String[] getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(String[] idCategoria) {
		this.idCategoria = idCategoria;
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
	public String getIdInstitucion() {
		return idInstitucion;
	}
	public void setIdInstitucion(String idInstitucion) {
		this.idInstitucion = idInstitucion;
	}
	
	

}
