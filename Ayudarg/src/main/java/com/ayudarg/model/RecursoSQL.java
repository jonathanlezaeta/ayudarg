package com.ayudarg.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Recurso")

public class RecursoSQL {

	@Id
	@Column(name="idRecurso")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idRecurso;
	private String nombre;
	private Date fechaCreacion;
	private int usuarioIdUsuario;
//	private int usuarioRolIdRol;
//	private int institucionIdInstitucion;
	private int cantidad;
	private boolean activo;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "RecursoHasCategoria", 
             joinColumns = { @JoinColumn(name = "recursoIdRecurso") }, 
             inverseJoinColumns = { @JoinColumn(name = "categoriaIdCategoria") })
	private Set<Categoria> categoria = new HashSet<Categoria>(0);
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="institucionIdInstitucion")
	private InstitucionSQL institucion;

	public InstitucionSQL getInstitucion() {
		return institucion;
	}
	public void setSubInstitucion(InstitucionSQL institucion) {
		this.institucion = institucion;
	}
	
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
//	public int getInstitucionIdInstitucion() {
//		return institucionIdInstitucion;
//	}
//	public void setInstitucionIdInstitucion(int institucionIdInstitucion) {
//		this.institucionIdInstitucion = institucionIdInstitucion;
//	}
	public Set<Categoria> getCategorias() {
		return categoria;
	}
	public void setCategoria(Set<Categoria> categoria) {
		this.categoria = categoria;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public int getUsuarioIdUsuario() {
		return usuarioIdUsuario;
	}
	public void setUsuarioIdUsuario(int usuarioIdUsuario) {
		this.usuarioIdUsuario = usuarioIdUsuario;
	}

	
}
