package com.ayudarg.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "InstitucionHasCategoria", 
	    joinColumns = { @JoinColumn(name = "institucionIdInstitucion") }, 
	    inverseJoinColumns = { @JoinColumn(name = "categoriaIdCategoria") })
	private Set<InstitucionSQL> institucion = new HashSet<InstitucionSQL>(0);
		
	public Set<InstitucionSQL> getInstitucion() {
		return institucion;
	}
	
	public void setInstitucion(Set<InstitucionSQL> institucion) {
		this.institucion = institucion;
	}
	
	@ManyToOne(cascade={CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name="categoriaIdCategoria")
	private Categoria subcategoria;

	public Categoria getSubcategoria() {
		return subcategoria;
	}
	public void setSubcategoria(Categoria subcategoria) {
		this.subcategoria = subcategoria;
	}

//	@OneToMany(mappedBy="subcategoria")
//	private Set<Categoria> subcategorias = new HashSet<Categoria>();	
//	
//	public Set<Categoria> getSubcategorias() {
//		return subcategorias;
//	}
//	public void setSubcategorias(Set<Categoria> subcategorias) {
//		this.subcategorias = subcategorias;
//	}
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
	
    @Override
    public String toString() {
        return "CategoriaBean [id=" + idCategoria + ", name=" + nombre + "]";
    }
}

