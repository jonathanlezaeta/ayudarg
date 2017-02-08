package com.ayudarg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UsuarioHasRol")

public class UsuarioHasRol {

	@Id
	/*@Column(name="recursoIdRecurso")
	@Column(name="categoriaIdCategoria")
	@Column(name="categoriaCategoriaIdCategoria")*/
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int usuarioIdUsuario;
	private int rolIdRol;
	
	public int getUsuarioIdUsuario() {
		return usuarioIdUsuario;
	}
	public void setUsuarioIdUsuario(int usuarioIdUsuario) {
		this.usuarioIdUsuario = usuarioIdUsuario;
	}
	public int getRolIdRol() {
		return rolIdRol;
	}
	public void setRolIdRol(int rolIdRol) {
		this.rolIdRol = rolIdRol;
	}

}
