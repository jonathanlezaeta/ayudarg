package com.ayudar.elasticsearch.model;

public class Institucion {
	private String idInstitucion;
	private String nombre;
	private String director;
	private String tipo;
	private String direccion;
	private String mail;
	private String sitioWeb;
	private String telefono;
	private String localidadId;
	
	public String getId() {
		return idInstitucion;
	}
	public void setId(String id) {
		this.idInstitucion = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSitioWeb() {
		return sitioWeb;
	}
	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getLocalidadId() {
		return localidadId;
	}
	public void setLocalidadId(String localidadId) {
		this.localidadId = localidadId;
	}
}
