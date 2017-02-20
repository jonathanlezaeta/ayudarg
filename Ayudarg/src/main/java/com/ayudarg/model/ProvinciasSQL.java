package com.ayudarg.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Provincias")
public class ProvinciasSQL {
	@Id
	@Column(name="idProvincia")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProvincia;
	private String provincia;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "provincia")
	private Set<LocalidadesSQL> provincias = new HashSet<LocalidadesSQL>();
	
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Set<LocalidadesSQL> getProvincias() {
		return provincias;
	}
	public void setProvincias(Set<LocalidadesSQL> provincias) {
		this.provincias = provincias;
	}
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
}
