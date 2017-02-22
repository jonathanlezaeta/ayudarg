package com.ayudarg.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ayudar.elasticsearch.model.Usuario;

@Entity
@Table(name="Institucion")

public class InstitucionSQL {

	@Id
	@Column(name="idInstitucion")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idInstitucion;
	private String director;
	private String ciudad;
	private String tipo;
	private String nombre;
	private String direccion;
	private String telefono;
	private String celular;
	private String sitioWeb;
	private String email;
	private boolean activo;
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "localidadesId", nullable = false)
    private LocalidadesSQL localidadesId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "InstitucionHasCategoria", 
	    joinColumns = { @JoinColumn(name = "institucionIdInstitucion") }, 
	    inverseJoinColumns = { @JoinColumn(name = "categoriaIdCategoria") })
	private Set<Categoria> categoria = new HashSet<Categoria>(0);
		
	public Set<Categoria> getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Set<Categoria> categoria) {
		this.categoria = categoria;
	}
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario", nullable = false)
	private UsuarioSQL idUsuario;
    
	public UsuarioSQL getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UsuarioSQL idUsuario) {
		this.idUsuario = idUsuario;
	}

	@OneToMany(cascade = CascadeType.ALL)
    private Set<RecursoSQL> recurso = new HashSet<RecursoSQL>(0);
    
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
    public int getIdInstitucion() {
		return idInstitucion;
	}
	public void setIdInstitucion(int idInstitucion) {
		this.idInstitucion = idInstitucion;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public String getSitioWeb() {
		return sitioWeb;
	}
	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<RecursoSQL> getRecursos() {
		return this.recurso;
	}
	public void setRecurso(Set<RecursoSQL> recurso) {
		this.recurso = recurso;
	}
	
	@Override
	public String toString() {
		return "InstitucionBean [id=" + idInstitucion + ", name=" + nombre + "]";
	}
}
