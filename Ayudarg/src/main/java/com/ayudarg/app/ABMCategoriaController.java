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

import com.ayudar.view.beans.CategoriaBean;
import com.ayudar.view.beans.InstitucionBean;
import com.ayudar.view.beans.UsuarioBean;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.UsuarioSQL;
import com.ayudarg.service.CategoriaService;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.UsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ABMCategoriaController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(RegistraseController.class);
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
	public String submitRegistrar(Model model, @ModelAttribute("categoriaBean") CategoriaBean categoriaBean) {
		serviceCategoria.insertCategoria(categoriaBean.getNombre(), categoriaBean.getCategoria());
		return "registrarseCorrectamente";
	}

	
	@RequestMapping(value="/submitDeleteCategoria", method = RequestMethod.POST)
	public String submitDeleteCategoria(Model model, @ModelAttribute("categoriaBean") CategoriaBean categoriaBean) {
		serviceCategoria.deleteCategoria(categoriaBean.getCategoria());
		return "borradoCorrectamente";
	}
	
	@RequestMapping(value="/submitUpdateCategoria", method = RequestMethod.POST)
	public String submitUpdateCategoria(Model model, @ModelAttribute("categoriaBean") CategoriaBean categoriaBean) {
		serviceCategoria.deleteCategoria(categoriaBean.getCategoria());
		return "borradoCorrectamente";
	}
}