package com.ayudarg.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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

import com.ayudar.view.beans.CategoriaBean;
import com.ayudar.view.beans.InstitucionBean;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.Rol;
import com.ayudarg.service.CategoriaService;
import com.ayudarg.validators.ValidatorForm;
import com.ayudarg.validators.ValidatorFormCompuesto;
import com.ayudarg.validators.ValidatorFormIsEmpty;
import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ABMCategoriaController {

	private CategoriaService serviceCategoria;
	

	public CategoriaService getServiceCategoria() {
		return serviceCategoria;
	}

	public void setServiceCategoria(CategoriaService serviceCategoria) {
		this.serviceCategoria = serviceCategoria;
	}

	
	@Autowired(required = true)
	@Qualifier(value = "CategoriaService")
	public void setCategoriaService(CategoriaService ps) {
		this.serviceCategoria = ps;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/altaCategoria", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		ArrayList<Categoria> categorias = (ArrayList<Categoria>) serviceCategoria.listCategorias();
		model.addAttribute("categoria", categorias);
		model.addAttribute("categoriaBean", new CategoriaBean());
		HttpSession session = request.getSession();
		model.addAttribute("usuario", session.getAttribute("usuario"));
		model.addAttribute("rol", session.getAttribute("rol"));
		if(session.getAttribute("usuario")!= null){
			return "categoriaView";
		}else{
		    model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}
	}

	@RequestMapping(value="/submitAltaCategoria", method = RequestMethod.POST)
	public String submitRegistrar(Model model, @ModelAttribute("categoriaBean") CategoriaBean categoriaBean, HttpServletRequest request) {
		// Chequeo el inicio de session
		HttpSession session = request.getSession();
		if (session.getAttribute("usuario") != null) {
			model.addAttribute("rol", session.getAttribute("rol"));
			// Validacion del formulario
			HashMap<String, String> form = new HashMap<String, String>();
			form.put("nombre", categoriaBean.getNombre());
			form.put("categoria", categoriaBean.getCategoria());
			ValidatorForm validateVacio = new ValidatorFormIsEmpty();
			validateVacio.setValues(form);
			if (!(validateVacio.validate())) {
				serviceCategoria.insertCategoria(categoriaBean.getNombre(), categoriaBean.getCategoria());
				model.addAttribute("menssage", "Categoria registrada correctamente.");
				return "menssageDashboard";
			} else {
				List<Categoria> categorias = serviceCategoria.listCategorias();
				model.addAttribute("categoria", categorias);
				model.addAttribute("categoriaBean", new CategoriaBean());
				model.addAttribute("errorRegistrar", "En la pestaña registrar: " + validateVacio.getError());
				return "categoriaView";
			}
		} else {
			model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}
	}
		
	
	@RequestMapping(value="/submitDeleteCategoria", method = RequestMethod.POST)
	public String submitDeleteCategoria(Model model, @ModelAttribute("categoriaBean") CategoriaBean categoriaBean, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// Chequeo el inicio de session
		if (session.getAttribute("usuario") != null) {
			model.addAttribute("rol", session.getAttribute("rol"));
			// Validacion del formulario
			HashMap<String, String> form = new HashMap<String, String>();
			form.put("categoria", categoriaBean.getCategoria());
			ValidatorForm validateVacio = new ValidatorFormIsEmpty();
			ArrayList<ValidatorForm> validadores = new ArrayList<ValidatorForm>();
			validadores.add(validateVacio);
			ValidatorForm validador = new ValidatorFormCompuesto(validadores);
			validador.setValues(form);
			if (!(validador.validate())) {
				serviceCategoria.deleteCategoria(categoriaBean.getCategoria());
				model.addAttribute("menssage", "Baja de categoria exitosa.");
				return "menssageDashboard";
			} else {
				List<Categoria> categorias = serviceCategoria.listCategorias();
				model.addAttribute("categoria", categorias);
				model.addAttribute("categoriaBean", new CategoriaBean());
				model.addAttribute("errorRegistrar", "En la pestaña eliminar: " + validateVacio.getError());
				return "categoriaView";
			}
		} else {
			model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}
	}


	@RequestMapping(value="/submitUpdateCategoria", method = RequestMethod.POST)
	public String submitUpdateCategoria(Model model, @ModelAttribute("categoriaBean") CategoriaBean categoriaBean, HttpServletRequest request) {
		// Chequeo el inicio de session
		HttpSession session = request.getSession();
		if (session.getAttribute("usuario") != null) {
			model.addAttribute("rol", session.getAttribute("rol"));
			// Validacion del formulario
			HashMap<String, String> form = new HashMap<String, String>();
			form.put("nombre", categoriaBean.getNombre());
			form.put("categoria", categoriaBean.getCategoria());
			form.put("subcategoria", categoriaBean.getCategoriaPadre());
			ValidatorForm validateVacio = new ValidatorFormIsEmpty();
			validateVacio.setValues(form);
			if (!(validateVacio.validate())) {
				serviceCategoria.updateCategoria(categoriaBean.getCategoria() ,categoriaBean.getNombre(), categoriaBean.getCategoria());
				model.addAttribute("menssage", "Categoria modificada correctamente.");
				return "menssageDashboard";
			} else {
				List<Categoria> categorias = serviceCategoria.listCategorias();
				model.addAttribute("categoria", categorias);
				model.addAttribute("categoriaBean", new CategoriaBean());
				model.addAttribute("errorRegistrar", "En la pestaña modificar: " + validateVacio.getError());
				return "categoriaView";
			}
		} else {
			model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}
	}
	
	@RequestMapping(value = "/getCategoriaById", method = RequestMethod.POST)
	public @ResponseBody String getUsuariosById(CategoriaBean categoriaBean) {
		Gson gson = new Gson();
		Categoria categoria = serviceCategoria.getCategoriaById(categoriaBean.getCategoria());
		CategoriaBean cat = new CategoriaBean();
		cat.setNombre(categoria.getNombre());	
		cat.setCategoriaPadre(String.valueOf(categoria.getSubcategoria().getIdCategoria()));
		String jsonInString = gson.toJson(cat);
		return jsonInString;
	}	
}