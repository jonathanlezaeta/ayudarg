package com.ayudarg.app;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.ayudar.view.beans.InstitucionBajaBean;
import com.ayudar.view.beans.InstitucionBean;
import com.ayudar.view.beans.RecursoBean;
import com.ayudar.view.beans.UsuarioBean;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.ProvinciasSQL;
import com.ayudarg.model.RecursoSQL;
import com.ayudarg.service.CategoriaService;
import com.ayudarg.service.GeoService;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.RecursoService;
import com.ayudarg.service.UsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ABMRecursoController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(RegistraseController.class);
	private InstitucionService serviceInstitucion;
	private CategoriaService serviceCategoria;
	private RecursoService serviceRecurso;
	

	public InstitucionService getServiceInstitucion() {
		return serviceInstitucion;
	}

	public void setServiceInstitucion(InstitucionService serviceInstitucion) {
		this.serviceInstitucion = serviceInstitucion;
	}
	
	public RecursoService getServiceRecurso() {
		return serviceRecurso;
	}

	public void setServiceInstitucion(RecursoService serviceRecurso) {
		this.serviceRecurso = serviceRecurso;
	}
	
	public CategoriaService getServiceCategoria() {
		return serviceCategoria;
	}

	public void setServiceCategoria(CategoriaService serviceCategoria) {
		this.serviceCategoria = serviceCategoria;
	}

	
	@Autowired(required = true)
	@Qualifier(value = "InstitucionService")
	public void setInstitucionService(InstitucionService ps) {
		this.serviceInstitucion = ps;
	}
	
	
	@Autowired(required = true)
	@Qualifier(value = "CategoriaService")
	public void setCategoriaService(CategoriaService cs) {
		this.serviceCategoria = cs;
	}
	
	

	@RequestMapping(value = "/recurso", method = RequestMethod.GET)
	public String home(Locale locale, Model model,  HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Categoria> categorias = (ArrayList<Categoria>) serviceCategoria.listCategorias();
		ArrayList<InstitucionSQL> instituciones = (ArrayList<InstitucionSQL>) serviceInstitucion.listInstituciones();
		ArrayList<RecursoSQL> recursos = (ArrayList<RecursoSQL>) serviceRecurso.listRecursos();
		model.addAttribute("institucion", instituciones);
		model.addAttribute("categoria", categorias);
		model.addAttribute("recurso", recursos);
		model.addAttribute("usuario", session.getAttribute("usuario"));
		model.addAttribute("rol", session.getAttribute("rol"));
		if(session.getAttribute("usuario")!= null){
			return "recurso";
		}else{
		    model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}		
	}

//	@RequestMapping(value="/submitAltaInstitucion", method = RequestMethod.POST)
//	public String submitRegistrar(Model model, @ModelAttribute("institucionBean") InstitucionBean institucionBean) {
//		serviceInstitucion.insertInstitucion(institucionBean.getDirector(), institucionBean.getCiudad(),
//				institucionBean.getTipo(), institucionBean.getNombre(), institucionBean.getDireccion(), institucionBean.getTelefono(),
//				institucionBean.getCelular(), institucionBean.getSitioWeb(), institucionBean.getEmail(), institucionBean.getLocalidad());
//		return "registrarseCorrectamente";
//	}
//	
//	@RequestMapping(value="/submitDeleteInstitucion", method = RequestMethod.POST)
//	public String submitRegistrar2(Model model, @ModelAttribute("institucionBajaBean") InstitucionBajaBean institucionBajaBean) {
//		serviceInstitucion.deleteInstitucion(institucionBajaBean.getInstitucion());
//		return "borradoCorrectamente";
//	}
//	
//	@RequestMapping(value="/submitUpdateInstitucion", method = RequestMethod.POST)
//	public String submitRegistrar3(Model model, @ModelAttribute("institucionBean") InstitucionBean institucionBean) {
//		serviceInstitucion.insertInstitucion(institucionBean.getDirector(), institucionBean.getCiudad(),
//				institucionBean.getTipo(), institucionBean.getNombre(), institucionBean.getDireccion(), institucionBean.getTelefono(),
//				institucionBean.getCelular(), institucionBean.getSitioWeb(), institucionBean.getEmail(), institucionBean.getLocalidad());
//		return "registrarseCorrectamente";
//	}


}