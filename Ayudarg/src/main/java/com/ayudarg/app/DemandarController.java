package com.ayudarg.app;


import java.util.ArrayList;
import java.util.HashMap;
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

import com.ayudar.view.beans.DemandarBean;
import com.ayudar.view.beans.DonarDemandarBean;
import com.ayudar.view.beans.InstitucionBean;
import com.ayudar.view.beans.RegistrarseBean;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.ProvinciasSQL;
import com.ayudarg.service.CategoriaService;
import com.ayudarg.service.GeoService;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.RecursoService;
import com.ayudarg.validators.ValidatorForm;
import com.ayudarg.validators.ValidatorFormIsEmpty;


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

	@RequestMapping(value="/submitDemandar", method = RequestMethod.POST)
	public String submitRegistrar(Model model, @ModelAttribute("recursoBean") DonarDemandarBean recursoBean,
			HttpServletRequest request)  {
		HttpSession session = request.getSession();
		//Valido la sesion 
		if (session.getAttribute("usuario") != null) {
			// Validacion del formulario
			HashMap<String, String> form = new HashMap<String, String>();
			/*
			 * Por ser un checkbox me fijo si el primer elemento del arreglo de String viene nulo
			 * no ingreso ningun valor. Deser asi le paso el vacio al validator par aque de mensaje
			 * de error.
			 */
			if(recursoBean.getIdCategoria().length > 0)
				form.put("idCategoria", recursoBean.getIdCategoria()[0]);
			else
				form.put("idCategoria", "");
			form.put("selectLocalidades", recursoBean.getLocalidad());
			ValidatorForm validateVacio = new ValidatorFormIsEmpty();
			validateVacio.setValues(form);
			if(!(validateVacio.validate())){
				System.out.printf("aca va el elasticsearch");				
				model.addAttribute("usuario", session.getAttribute("usuario"));
				model.addAttribute("rol", session.getAttribute("rol"));
				model.addAttribute("registrarseBean", new RegistrarseBean());
				return null;
			}else{
				ArrayList<ProvinciasSQL> provincias = (ArrayList<ProvinciasSQL>) serviceGeo.listAllProvincias();
				ArrayList<Categoria> categorias = (ArrayList<Categoria>) serviceCategoria.listCategorias();
				ArrayList<InstitucionSQL> instituciones = (ArrayList<InstitucionSQL>) serviceInstitucion.listInstituciones();
				model.addAttribute("usuario", session.getAttribute("usuario"));
				model.addAttribute("rol", session.getAttribute("rol"));
				model.addAttribute("donarBean", new DonarDemandarBean());
				model.addAttribute("categoria", categorias);
				model.addAttribute("provincias", provincias);
				model.addAttribute("institucion", instituciones);
				model.addAttribute("institucionBean", new InstitucionBean());			
				model.addAttribute("errorRegistrar", validateVacio.getError());
				return "donarView";				
			}
		} else {
			model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}
	}
	
}