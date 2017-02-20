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
	@Column(name="localidadesId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int localidadesId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProvincia", nullable = false)
	private ProvinciasSQL provincia;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localidadesId")
    private Set<UsuarioSQL> usuario = new HashSet<UsuarioSQL>(0);	
	
	
	public int getLocalidadesId() {
		return localidadesId;
	}

	public void setLocalidadesId(int localidadesId) {
		this.localidadesId = localidadesId;
	}
	private String localidad;
	

	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localidadesId")
//	    private Set<InstitucionSQL> institucion = new HashSet<InstitucionSQL>(0);
	 


	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public Set<UsuarioSQL> getUsuario() {
		return this.usuario;
	}
	public void setUsuario(Set<UsuarioSQL> usuario) {
		this.usuario = usuario;
	}

}
