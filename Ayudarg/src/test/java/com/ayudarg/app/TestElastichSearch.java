package com.ayudarg.app;

import java.util.ArrayList;
import java.util.Date;

import org.elasticsearch.action.index.IndexResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ayudar.elasticsearch.model.Institucion;
import com.ayudar.elasticsearch.model.RecursoModelEs;
import com.ayudar.elasticsearch.model.Usuario;
import com.ayudarg.elasticsearch.ElasticSearchConector;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.UsuarioSQL;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.UsuarioService;
import com.google.gson.Gson;

public class TestElastichSearch {
	private ElasticSearchConector es;
	
	
	private UsuarioService serviceUsuarios;
	
	@Autowired(required=true)
	@Qualifier(value="UsuarioService")
	public void setPersonService(UsuarioService ps){
		this.serviceUsuarios = ps;
	}
	
	private InstitucionService serviceInstitucion;
	
	@Autowired(required=true)
	@Qualifier(value="InstitucionService")
	public void setPersonService2(InstitucionService inst){
		this.serviceInstitucion = inst;
	}
	
	
	
	
	@Test
	public void test() {
		es = new ElasticSearchConector();
		

		Usuario us = new Usuario();
		us.setIdUsuario(1);
		us.setActivo(true);
		us.setCelular("0228415660790");
		us.setCiudadOrigen("Olavarria");
		us.setEmail("jonthan.lezaeta@gmail.com");
		Institucion inst= new Institucion();
		inst.setId("1");
		inst.setNombre("APOA");
		RecursoModelEs recurso = new RecursoModelEs();
		recurso.setNombre("Fideos");
		recurso.setFechaIngreso(new Date());
		recurso.setInstitucion(inst);
		recurso.setUsuario(us);
		Gson gson = new Gson();
		String jsonInString = gson.toJson(recurso);
		IndexResponse response = es.getElasticSearchClient().prepareIndex("ayudarg", "recurso")
		        .setSource(jsonInString)
		        .get();
		System.out.println(jsonInString);
	}
	
	
	public ElasticSearchConector getEs() {
		return es;
	}

	public void setEs(ElasticSearchConector es) {
		this.es = es;
	}
}
