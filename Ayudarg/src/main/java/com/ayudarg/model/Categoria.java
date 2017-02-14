package com.ayudarg.model;

import java.util.Date;
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

@Entity
@Table(name="Categoria")

public class Categoria {

	@Id
	@Column(name="idCategoria")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idCategoria;
	private String nombre;
	private Date fechaCreacion;
//	private int categoriaIdCategoria;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "RecursoHasCategoria", 
	    joinColumns = { @JoinColumn(name = "recursoIdRecurso") }, 
	    inverseJoinColumns = { @JoinColumn(name = "categoriaIdCategoria") })
	private Set<Recurso> recurso = new HashSet<Recurso>(0);
		
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="categoriaIdCategoria")
	private Categoria subcategoria;

	@OneToMany(mappedBy="subcategoria")
	private Set<Categoria> subcategorias = new HashSet<Categoria>();	
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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
//	public int getCategoriaIdCategoria() {
//		return categoriaIdCategoria;
//	}
//	public void setCategoriaIdCategoria(int categoriaIdCategoria) {
//		this.categoriaIdCategoria = categoriaIdCategoria;
//	}
	public Set<Recurso> getRecursos() {
		return recurso;
	}
	public void setRecurso(Set<Recurso> recurso) {
		this.recurso = recurso;
	}
	
	@Override
	public String toString(){
		return idCategoria + "-" + nombre;
	}
}
