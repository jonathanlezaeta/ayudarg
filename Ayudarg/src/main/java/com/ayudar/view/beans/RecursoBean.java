package com.ayudar.view.beans;

import java.sql.Date;

public class RecursoBean {
	
	
	private int categoriaIdCategoria;
	private boolean activo;
	
	private int idRecurso;
	private String nombre;
	private Date fechaCreacion;
	private int usuarioIdUsuario;
	private int usuarioRolIdRol;
	private int intistucionIdInstitucion;
	private int cantidad;
	
	public int getIdRecurso() {
		return idRecurso;
	}
	public void setIdRecurso(int idRecurso) {
		this.idRecurso = idRecurso;
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
	public int getUsuarioIdUsuario() {
		return usuarioIdUsuario;
	}
	public void setUsuarioIdUsuario(int usuarioIdUsuario) {
		this.usuarioIdUsuario = usuarioIdUsuario;
	}
	public int getUsuarioRolIdRol() {
		return usuarioRolIdRol;
	}
	public void setUsuarioRolIdRol(int usuarioRolIdRol) {
		this.usuarioRolIdRol = usuarioRolIdRol;
	}
	public int getIntistucionIdInstitucion() {
		return intistucionIdInstitucion;
	}
	public void setIntistucionIdInstitucion(int intistucionIdInstitucion) {
		this.intistucionIdInstitucion = intistucionIdInstitucion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCategoriaIdCategoria() {
		return categoriaIdCategoria;
	}
	public void setCategoriaIdCategoria(int categoriaIdCategoria) {
		this.categoriaIdCategoria = categoriaIdCategoria;
	}
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
