package com.ayudarg.app;


import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ayudar.view.beans.RecursoBean;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.RecursoSQL;
import com.ayudarg.service.CategoriaService;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.RecursoService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class DemandarController {

	private RecursoService serviceRecurso;
	private CategoriaService serviceCategoria;
	private InstitucionService serviceInstitucion;
	

	public CategoriaService getServiceCategoria() {
		return serviceCategoria;
	}

	public void setServiceCategoria(CategoriaService serviceCategoria) {
		this.serviceCategoria = serviceCategoria;
	}
	
	public RecursoService getServiceRecurso() {
		return serviceRecurso;
	}

	public void setServiceRecurso(RecursoService serviceRecurso) {
		this.serviceRecurso = serviceRecurso;
	}

	public InstitucionService getServiceInstitucion() {
		return serviceInstitucion;
	}

	public void setServiceInstitucion(InstitucionService serviceInstitucion) {
		this.serviceInstitucion = serviceInstitucion;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "RecursoService")
	public void setRecursoService(RecursoService ps) {
		this.serviceRecurso = ps;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "CategoriaService")
	public void setCategoriaService(CategoriaService cs) {
		this.serviceCategoria = cs;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "InstitucionService")
	public void setInstitucionService(InstitucionService is) {
		this.serviceInstitucion = is;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/demandar", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		ArrayList<Categoria> categorias = (ArrayList<Categoria>) serviceCategoria.listCategorias();
		model.addAttribute("categoria", categorias);
		model.addAttribute("recursoBean", new RecursoBean());
		
		ArrayList<InstitucionSQL> institucion = (ArrayList<InstitucionSQL>) serviceInstitucion.listInstituciones();
		model.addAttribute("institucion", institucion);
		
		return "demandar";
	}

	@RequestMapping(value="/submitAltaDemanda", method = RequestMethod.POST)
	public String submitRegistrar(Model model, @ModelAttribute("recursoBean") RecursoBean recursoBean) {
		serviceRecurso.deleteRecurso(recursoBean.getNombre(), recursoBean.getCategoria());
		System.out.printf("asd");
		return null;
	}

}