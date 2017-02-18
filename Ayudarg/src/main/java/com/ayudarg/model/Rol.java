package com.ayudarg.model;

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

@Entity
@Table(name="Rol")

public class Rol {

	@Id
	@Column(name="idRol")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRol;
	private String nombre;
	
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "UsuarioHasRol", 
//	    joinColumns = { @JoinColumn(name = "idUsuario") }, 
//	    inverseJoinColumns = { @JoinColumn(name = "idRol") })
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "rol")
	private Set<UsuarioSQL> usuarios = new HashSet<UsuarioSQL>(0);
    
    public Rol(){
    	
    }
    
    public Rol(String nombre, Set<UsuarioSQL> usuarios){
    	this.nombre = nombre;
    	this.usuarios = usuarios;
    }    
	
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<UsuarioSQL> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Set<UsuarioSQL> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
