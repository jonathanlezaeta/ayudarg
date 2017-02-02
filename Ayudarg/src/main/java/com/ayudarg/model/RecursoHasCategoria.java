package com.ayudarg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RecursoHasCategoria")

public class RecursoHasCategoria {

	@Id
	/*@Column(name="recursoIdRecurso")
	@Column(name="categoriaIdCategoria")
	@Column(name="categoriaCategoriaIdCategoria")*/
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int recursoIdRecurso;
	private int categoriaIdCategoria;
	private int categoriaCategoriaIdCategoria;
	
	public int getRecursoIdRecurso() {
		return recursoIdRecurso;
	}
	public void setRecursoIdRecurso(int recursoIdRecurso) {
		this.recursoIdRecurso = recursoIdRecurso;
	}
	public int getCategoriaIdCategoria() {
		return categoriaIdCategoria;
	}
	public void setCategoriaIdCategoria(int categoriaIdCategoria) {
		this.categoriaIdCategoria = categoriaIdCategoria;
	}
	public int getCategoriaCategoriaIdCategoria() {
		return categoriaCategoriaIdCategoria;
	}
	public void setCategoriaCategoriaIdCategoria(int categoriaCategoriaIdCategoria) {
		this.categoriaCategoriaIdCategoria = categoriaCategoriaIdCategoria;
	}
}
