package com.ayudarg.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayudar.view.beans.AsignarBean;
import com.ayudar.view.beans.InstitucionBajaBean;
import com.ayudar.view.beans.InstitucionBean;
import com.ayudar.view.beans.UsuarioBajaBean;
import com.ayudar.view.beans.UsuarioBean;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.LocalidadesSQL;
import com.ayudarg.model.ProvinciasSQL;
import com.ayudarg.model.Rol;
import com.ayudarg.model.UsuarioSQL;
import com.ayudarg.service.CategoriaService;
import com.ayudarg.service.GeoService;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.UsuarioService;
import com.ayudarg.validators.ValidatorExisteUsuario;
import com.ayudarg.validators.ValidatorForm;
import com.ayudarg.validators.ValidatorFormCompuesto;
import com.ayudarg.validators.ValidatorFormIsEmpty;
import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ABMInstitucionController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(RegistraseController.class);
	private InstitucionService serviceInstitucion;
	private GeoService serviceGeo;
	private CategoriaService serviceCategoria;
	

	public InstitucionService getServiceInstitucion() {
		return serviceInstitucion;
	}

	public void setServiceInstitucion(InstitucionService serviceInstitucion) {
		this.serviceInstitucion = serviceInstitucion;
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
	@Qualifier(value = "GeoService")
	public void setGeoServicee(GeoService ol) {
		this.serviceGeo = ol;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "CategoriaService")
	public void setCategoriaServicee(CategoriaService cs) {
		this.serviceCategoria = cs;
	}

	public GeoService getServiceGeo() {
		return serviceGeo;
	}

	public void setServiceGeo(GeoService serviceGeo) {
		this.serviceGeo = serviceGeo;
	}

	@RequestMapping(value = "/altaInstitucion", method = RequestMethod.GET)
	public String home(Locale locale, Model model,  HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Categoria> categorias = (ArrayList<Categoria>) serviceCategoria.listCategorias();
		ArrayList<ProvinciasSQL> provincias = (ArrayList<ProvinciasSQL>) serviceGeo.listAllProvincias();
		ArrayList<InstitucionSQL> instituciones = (ArrayList<InstitucionSQL>) serviceInstitucion.listInstituciones();
		ArrayList<LocalidadesSQL> localidades = (ArrayList<LocalidadesSQL>) serviceGeo.listAllLocalidades();
		model.addAttribute("localidades", localidades);
		model.addAttribute("usuario", session.getAttribute("usuario"));
		model.addAttribute("rol", session.getAttribute("rol"));
		model.addAttribute("institucion", instituciones);
		model.addAttribute("provincias", provincias);
		model.addAttribute("categoria", categorias);
		model.addAttribute("institucionBean", new InstitucionBean());
		model.addAttribute("institucionBajaBean", new InstitucionBajaBean());
		if(session.getAttribute("usuario")!= null){
			return "altaInstitucion";
		}else{
		    model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}		
	}

	@RequestMapping(value="/submitAltaInstitucion", method = RequestMethod.POST)
	public String submitRegistrar(Model model, @ModelAttribute("institucionBean") InstitucionBean institucionBean, HttpServletRequest request) {{
			// Chequeo el inicio de session
			HttpSession session = request.getSession();
			if (session.getAttribute("usuario") != null) {
				model.addAttribute("rol", session.getAttribute("rol"));
				// Validacion del formulario
				HashMap<String, String> form = new HashMap<String, String>();
				form.put("director", institucionBean.getDirector());
				form.put("tipo", institucionBean.getTipo());
				form.put("nombre ", institucionBean.getNombre());
				form.put("direccion", institucionBean.getDireccion());
				form.put("telefono", institucionBean.getTelefono());
				form.put("celular", institucionBean.getCelular());
				form.put("sitioWeb", institucionBean.getSitioWeb());
				form.put("email", institucionBean.getEmail());
				form.put("localidad", institucionBean.getLocalidad());
				ValidatorForm validateVacio = new ValidatorFormIsEmpty();
				validateVacio.setValues(form);
				if (!(validateVacio.validate())) {
					serviceInstitucion.insertInstitucion(institucionBean.getDirector(), institucionBean.getCiudad(),
							institucionBean.getTipo(), institucionBean.getNombre(), institucionBean.getDireccion(), institucionBean.getTelefono(),
							institucionBean.getCelular(), institucionBean.getSitioWeb(), institucionBean.getEmail(), institucionBean.getLocalidad(), institucionBean.getIdCategoria());
					model.addAttribute("menssage", "Institucion registrada correctamente.");
					return "menssageDashboard";
				} else {
					ArrayList<ProvinciasSQL> provincias = (ArrayList<ProvinciasSQL>) serviceGeo.listAllProvincias();
					ArrayList<LocalidadesSQL> localidades = (ArrayList<LocalidadesSQL>) serviceGeo.listAllLocalidades();
					List<InstitucionSQL> instituciones = serviceInstitucion.listInstituciones();
					model.addAttribute("institucion", instituciones);
					model.addAttribute("provincias", provincias);
					model.addAttribute("localidades", localidades);
					model.addAttribute("institucionBajaBean", new InstitucionBajaBean());
					model.addAttribute("institucionBean", new InstitucionBean());
					model.addAttribute("errorRegistrar", "En la pestaña registrar: " + validateVacio.getError());
					return "altaInstitucion";
				}
			} else {
				model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
				return "menssage";
			}
		}
	}
	
	@RequestMapping(value="/submitDeleteInstitucion", method = RequestMethod.POST)
	public String submitRegistrar2(Model model, @ModelAttribute("institucionBean") InstitucionBean institucionBean, HttpServletRequest request) {
			HttpSession session = request.getSession();
			// Chequeo el inicio de session
			if (session.getAttribute("usuario") != null) {
				model.addAttribute("rol", session.getAttribute("rol"));
				// Validacion del formulario
				HashMap<String, String> form = new HashMap<String, String>();
				form.put("institucion", institucionBean.getInstitucion());
				ValidatorForm validateVacio = new ValidatorFormIsEmpty();
				ArrayList<ValidatorForm> validadores = new ArrayList<ValidatorForm>();
				validadores.add(validateVacio);
				ValidatorForm validador = new ValidatorFormCompuesto(validadores);
				validador.setValues(form);
				if (!(validador.validate())) {
					serviceInstitucion.deleteInstitucion(institucionBean.getInstitucion());
					model.addAttribute("menssage", "Baja de institucion exitosa.");
					return "menssageDashboard";
				} else {
					ArrayList<ProvinciasSQL> provincias = (ArrayList<ProvinciasSQL>) serviceGeo.listAllProvincias();
					ArrayList<LocalidadesSQL> localidades = (ArrayList<LocalidadesSQL>) serviceGeo.listAllLocalidades();
					List<InstitucionSQL> instituciones = serviceInstitucion.listInstituciones();
					model.addAttribute("institucion", instituciones);
					model.addAttribute("provincias", provincias);
					model.addAttribute("localidades", localidades);
					model.addAttribute("institucionBajaBean", new InstitucionBajaBean());
					model.addAttribute("institucionBean", new InstitucionBean());
					model.addAttribute("errorRegistrar", "En la pestaña eliminar: " + validateVacio.getError());
					return "altaInstitucion";
				}
			} else {
				model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
				return "menssage";
			}
		}
		
	
	@RequestMapping(value="/submitUpdateInstitucion", method = RequestMethod.POST)
	public String submitRegistrar3(Model model, @ModelAttribute("institucionBean") InstitucionBean institucionBean, HttpServletRequest request) {
			// Chequeo que la sesion este iniciada
			HttpSession session = request.getSession();
			if (session.getAttribute("usuario") != null) {
				model.addAttribute("rol", session.getAttribute("rol"));
				// Validacion del formulario
				HashMap<String, String> form = new HashMap<String, String>();
				form.put("director", institucionBean.getDirector());
				form.put("tipo", institucionBean.getTipo());
				form.put("nombre ", institucionBean.getNombre());
				form.put("direccion", institucionBean.getDireccion());
				form.put("telefono", institucionBean.getTelefono());
				form.put("celular", institucionBean.getCelular());
				form.put("sitioWeb", institucionBean.getSitioWeb());
				form.put("email", institucionBean.getEmail());
				form.put("localidad", institucionBean.getLocalidad());
				ValidatorForm validateVacio = new ValidatorFormIsEmpty();
				validateVacio.setValues(form);
				if (!(validateVacio.validate())) {
					serviceInstitucion.updateInstitucion(institucionBean.getInstitucion(), institucionBean.getDirector(), institucionBean.getCiudad(),
							institucionBean.getTipo(), institucionBean.getNombre(), institucionBean.getDireccion(), institucionBean.getTelefono(),
							institucionBean.getCelular(), institucionBean.getSitioWeb(), institucionBean.getEmail(), institucionBean.getLocalidad(), institucionBean.getIdCategoria());
					model.addAttribute("menssage", "Institucion actualizada correctamente.");
					return "menssageDashboard";
				} else {
					ArrayList<ProvinciasSQL> provincias = (ArrayList<ProvinciasSQL>) serviceGeo.listAllProvincias();
					ArrayList<LocalidadesSQL> localidades = (ArrayList<LocalidadesSQL>) serviceGeo.listAllLocalidades();
					List<InstitucionSQL> instituciones = serviceInstitucion.listInstituciones();
					model.addAttribute("localidades", localidades);
					model.addAttribute("institucion", instituciones);
					model.addAttribute("provincias", provincias);
					model.addAttribute("localidades", localidades);
					model.addAttribute("institucionBajaBean", new InstitucionBajaBean());
					model.addAttribute("institucionBean", new InstitucionBean());
					model.addAttribute("errorRegistrar", "En la pestaña modificar: " + validateVacio.getError());
					return "altaInstitucion";
				}
			} else {
				model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
				return "menssage";
			}
		
	}
	
	@RequestMapping(value = "/getInstitucionById", method = RequestMethod.POST)
	public @ResponseBody String getUsuariosById(InstitucionBean institucionBean) {
		Gson gson = new Gson();
		InstitucionSQL institucion = serviceInstitucion.getInstitucionById(institucionBean.getInstitucion());
		institucionBean.setInstitucion(String.valueOf(institucion.getIdInstitucion()));
		institucionBean.setNombre(institucion.getNombre());
		institucionBean.setDirector(institucion.getDirector());
		institucionBean.setDireccion(institucion.getDireccion());
		institucionBean.setCelular(institucion.getCelular());
		institucionBean.setTelefono(institucion.getTelefono());
		institucionBean.setSitioWeb(institucion.getSitioWeb());
		institucionBean.setEmail(institucion.getEmail());
		institucionBean.setTipo(institucion.getTipo());
		institucionBean.setLocalidad(String.valueOf(institucion.getLocalidadesId().getLocalidadesId()));
		String jsonInString = gson.toJson(institucionBean);
		return jsonInString;
	}
}