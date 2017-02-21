package com.ayudarg.app;

import java.text.DateFormat;
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

import com.ayudar.view.beans.CategoriaBean;
import com.ayudar.view.beans.InstitucionBajaBean;
import com.ayudar.view.beans.InstitucionBean;
import com.ayudar.view.beans.UsuarioBean;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.Institucion;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.UsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ABMInstitucionController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(RegistraseController.class);
	private InstitucionService serviceInstitucion;
	

	public InstitucionService getServiceInstitucion() {
		return serviceInstitucion;
	}

	public void setServiceInstitucion(InstitucionService serviceInstitucion) {
		this.serviceInstitucion = serviceInstitucion;
	}

	
	@Autowired(required = true)
	@Qualifier(value = "InstitucionService")
	public void setInstitucionService(InstitucionService ps) {
		this.serviceInstitucion = ps;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/altaInstitucion", method = RequestMethod.GET)
	public String home(Locale locale, Model model,  HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("usuario", session.getAttribute("usuario"));
		model.addAttribute("rol", session.getAttribute("rol"));
		ArrayList<Institucion> instituciones = (ArrayList<Institucion>) serviceInstitucion.listInstituciones();
		model.addAttribute("institucion", instituciones);
		model.addAttribute("institucionBean", new InstitucionBean());
		model.addAttribute("institucionBajaBean", new InstitucionBajaBean());
		return "altaInstitucion";
	}
	
	@RequestMapping(value = "/altaInstitucion2", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		return "altaInstitucion2";
	}

	@RequestMapping(value="/submitAltaInstitucion", method = RequestMethod.POST)
	public String submitRegistrar(Model model, @ModelAttribute("institucionBean") InstitucionBean institucionBean) {
		serviceInstitucion.insertInstitucion(institucionBean.getDirector(), institucionBean.getCiudad(),
				institucionBean.getTipo(), institucionBean.getNombre(), institucionBean.getDireccion(), institucionBean.getTelefono(),
				institucionBean.getCelular(), institucionBean.getSitioWeb(), institucionBean.getEmail());
		return "registrarseCorrectamente";
	}
	
	@RequestMapping(value="/submitDeleteInstitucion", method = RequestMethod.POST)
	public String submitRegistrar2(Model model, @ModelAttribute("institucionBajaBean") InstitucionBajaBean institucionBajaBean) {
		serviceInstitucion.deleteInstitucion(institucionBajaBean.getInstitucion());
		return "borradoCorrectamente";
	}
}