package com.ayudarg.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="Usuario")
public class UsuarioSQL {

	@Id
	@Column(name="idUsuario")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;
	private String usuario;
	private String contrasenia;
	private String nombre;
	private String email;
	private String telefono;
	private String celular;
	private Date fechaDeNacimiento;
	private boolean activo;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "UsuarioHasRol", catalog = "ayudarg", joinColumns = {
			@JoinColumn(name = "usuarioIdUsuario", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "rolIdRol",
					nullable = false, updatable = false) })
	private Set<Rol> rol = new HashSet<Rol>(0);
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "localidadesId", referencedColumnName = "localidadesId")
	private LocalidadesSQL localidadesId;	

	public LocalidadesSQL getLocalidadesId() {
		return localidadesId;
	}

	public void setLocalidadesId(LocalidadesSQL localidadesId) {
		this.localidadesId = localidadesId;
	}

	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public Set<Rol> getRol() {
		return rol;
	}
	public void setRol(Set<Rol> rol) {
		this.rol = rol;
	}
	
}
