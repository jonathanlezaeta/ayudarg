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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Localidades")
public class LocalidadesSQL {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String localidad;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProvincia", nullable = false)
	private ProvinciasSQL provincia;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localidadesId")
	    private Set<InstitucionSQL> institucion = new HashSet<InstitucionSQL>(0);
	 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localidadesId")
	    private Set<UsuarioSQL> usuario = new HashSet<UsuarioSQL>(0);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public Set<InstitucionSQL> getInstitucion() {
		return this.institucion;
	}
	public void setRecurso(Set<InstitucionSQL> institucion) {
		this.institucion = institucion;
	}
	
	public Set<UsuarioSQL> getUsuario() {
		return this.usuario;
	}
	public void setUsuario(Set<UsuarioSQL> usuario) {
		this.usuario = usuario;
	}

}
