package com.ayudar.view.beans;

import java.sql.Date;
import java.util.ArrayList;

import com.ayudarg.model.Categoria;

public class RecursoBean {
	
	private String nombre;
	private Date fechaCreacion;
	private int cantidad;
//	private String categoriaIdCategoria;
	private String intistucionIdInstitucion;
	
//	private int idRecurso;
//	private boolean activo;
//	private int usuarioIdUsuario;
//	private int usuarioRolIdRol;


	
//	public int getIdRecurso() {
//		return idRecurso;
//	}
//	public void setIdRecurso(int idRecurso) {
//		this.idRecurso = idRecurso;
//	}
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
//	public int getUsuarioIdUsuario() {
//		return usuarioIdUsuario;
//	}
//	public void setUsuarioIdUsuario(int usuarioIdUsuario) {
//		this.usuarioIdUsuario = usuarioIdUsuario;
//	}
//	public int getUsuarioRolIdRol() {
//		return usuarioRolIdRol;
//	}
//	public void setUsuarioRolIdRol(int usuarioRolIdRol) {
//		this.usuarioRolIdRol = usuarioRolIdRol;
//	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
//	public String getCategoriaIdCategoria() {
//		return categoriaIdCategoria;
//	}
//	public void setCategoriaIdCategoria(String categoriaIdCategoria) {
//		this.categoriaIdCategoria = categoriaIdCategoria;
//	}
	public String getIntistucionIdInstitucion() {
		return intistucionIdInstitucion;
	}
	public void setIntistucionIdInstitucion(String intistucionIdInstitucion) {
		this.intistucionIdInstitucion = intistucionIdInstitucion;
	}
//	public boolean getActivo() {
//		return activo;
//	}
//	public void setActivo(boolean activo) {
//		this.activo = activo;
//	}

}
