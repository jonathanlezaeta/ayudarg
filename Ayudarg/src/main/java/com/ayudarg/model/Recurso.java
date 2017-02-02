package com.ayudarg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Recurso")

public class Recurso {

	@Id
	@Column(name="idRecurso")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idRecurso;
	private String nombre;
	private Date fechaCreacion;
	private int usuarioIdUsuario;
	private int usuarioRolIdRol;
	private int institucionIdInstitucion;
	
	public int getIdRecuso() {
		return idRecurso;
	}
	public void setIdRecuso(int idRecurso) {
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
	public int getInstitucionIdInstitucion() {
		return institucionIdInstitucion;
	}
	public void setInstitucionIdInstitucion(int institucionIdInstitucion) {
		this.institucionIdInstitucion = institucionIdInstitucion;
	}
	
}
