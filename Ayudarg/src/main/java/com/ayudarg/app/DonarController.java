package com.ayudarg.app;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ayudar.view.beans.CategoriaBean;
import com.ayudar.view.beans.InstitucionBean;
import com.ayudar.view.beans.RecursoBean;
import com.ayudar.view.beans.UsuarioBean;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.Institucion;
import com.ayudarg.service.CategoriaService;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.RecursoService;
import com.ayudarg.service.UsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DonarController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(RegistraseController.class);
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
	@RequestMapping(value = "/donar", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		ArrayList<Categoria> categorias = (ArrayList<Categoria>) serviceCategoria.listCategorias();
		model.addAttribute("categoria", categorias);
		model.addAttribute("recursoBean", new RecursoBean());
		
		ArrayList<Institucion> institucion = (ArrayList<Institucion>) serviceInstitucion.listInstituciones();
		model.addAttribute("institucion", institucion);
		
		return "donar";
	}

	@RequestMapping(value="/submitAltaDonacion", method = RequestMethod.POST)
	public String submitRegistrar(Model model, @ModelAttribute("recursoBean") RecursoBean recursoBean) {
		serviceRecurso.insertRecurso(recursoBean.getNombre(), recursoBean.getCantidad(), recursoBean.getCategoria(), recursoBean.getInstitucion());
		return "registrarseCorrectamente";
	}

}