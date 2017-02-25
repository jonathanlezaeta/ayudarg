package com.ayudarg.app;


import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayudar.view.beans.DemandarBean;
import com.ayudar.view.beans.OptionBean;
import com.ayudar.view.beans.RecursoBean;
import com.ayudar.view.beans.RegistrarseBean;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.LocalidadesSQL;
import com.ayudarg.model.ProvinciasSQL;
import com.ayudarg.model.RecursoSQL;
import com.ayudarg.service.CategoriaService;
import com.ayudarg.service.GeoService;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.RecursoService;
import com.google.gson.Gson;


/**
 * Handles requests for the application home page.
 */
@Controller
public class DemandarController {

	private RecursoService serviceRecurso;
	private CategoriaService serviceCategoria;
	private InstitucionService serviceInstitucion;
	private GeoService serviceGeo;
	

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
	
	@Autowired(required = true)
	@Qualifier(value = "GeoService")
	public void setGeoServicee(GeoService ps) {
		this.setServiceGeo(ps);
	}	
	
	public GeoService getServiceGeo() {
		return serviceGeo;
	}

	public void setServiceGeo(GeoService serviceGeo) {
		this.serviceGeo = serviceGeo;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/demandar", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<ProvinciasSQL> provincias = (ArrayList<ProvinciasSQL>) serviceGeo.listAllProvincias();
		ArrayList<Categoria> categorias = (ArrayList<Categoria>) serviceCategoria.listCategorias();
		model.addAttribute("usuario", session.getAttribute("usuario"));
		model.addAttribute("rol", session.getAttribute("rol"));
		model.addAttribute("categoria", categorias);
		model.addAttribute("demandarBean", new DemandarBean());
		model.addAttribute("provincias", provincias);
		if(session.getAttribute("usuario")!= null){
			return "demandar";
		}else{
		    model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}
	}

	@RequestMapping(value="/submitAltaDemanda", method = RequestMethod.POST)
	public String submitRegistrar(Model model, @ModelAttribute("recursoBean") RecursoBean recursoBean) {
//		serviceRecurso.deleteRecurso(recursoBean.getNombre(), recursoBean.getCategoria());
		System.out.printf("asd");
		return null;
	}
	
}