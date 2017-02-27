package com.ayudarg.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ayudar.view.beans.CategoriaBean;
import com.ayudar.view.beans.DonarDemandarBean;
import com.ayudar.view.beans.InstitucionBajaBean;
import com.ayudar.view.beans.InstitucionBean;
import com.ayudar.view.beans.LoginBean;
import com.ayudar.view.beans.RecursoBean;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.LocalidadesSQL;
import com.ayudarg.model.ProvinciasSQL;
import com.ayudarg.model.Rol;
import com.ayudarg.model.UsuarioSQL;
import com.ayudarg.service.CategoriaService;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.RecursoService;
import com.ayudarg.service.RolService;
import com.ayudarg.service.UsuarioService;
import com.ayudarg.validators.ValidatorForm;
import com.ayudarg.validators.ValidatorFormCompuesto;
import com.ayudarg.validators.ValidatorFormIsEmpty;

@Controller
public class RecursoController {
	
	private RecursoService serviceRecurso;
	private CategoriaService serviceCategoria;

	public RecursoService getServiceRecurso() {
		return serviceRecurso;
	}

	public void setServiceRecurso(RecursoService serviceRecurso) {
		this.serviceRecurso = serviceRecurso;
	}
	
	public CategoriaService getServiceCategoria() {
		return serviceCategoria;
	}

	public void setServiceCategoria(CategoriaService serviceCategoria) {
		this.serviceCategoria = serviceCategoria;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "RecursoService")
	public void setRecursoService(RecursoService rs) {
		this.serviceRecurso = rs;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "CategoriaService")
	public void setCategoriaService(CategoriaService cs) {
		this.serviceCategoria = cs;
	}
	
	@RequestMapping(value = "/recurso", method = RequestMethod.GET)
	public String dashboard(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Categoria> categorias = (ArrayList<Categoria>) serviceCategoria.listCategorias();
		model.addAttribute("usuario", session.getAttribute("usuario"));
		model.addAttribute("rol", session.getAttribute("rol"));
		model.addAttribute("recursoBean", new RecursoBean());
		model.addAttribute("categoria", categorias);
		if(session.getAttribute("usuario")!= null){
			return "recurso";
		}else{
		    model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}
	}	
	
	@RequestMapping(value="/submitAltaRercurso", method = RequestMethod.POST)
	public String submitRegistrar(Model model, @ModelAttribute("recursoBean") RecursoBean recursoBean, HttpServletRequest request) {
			// Chequeo el inicio de session
			HttpSession session = request.getSession();
			if (session.getAttribute("usuario") != null) {
				model.addAttribute("rol", session.getAttribute("rol"));
				// Validacion del formulario
				HashMap<String, String> form = new HashMap<String, String>();
				form.put("nombre", recursoBean.getNombre());
				form.put("cantidad", recursoBean.getCantidad());
				if(recursoBean.getIdCategoria().length > 0)
					form.put("categoria", recursoBean.getIdCategoria()[0]);
				else
					form.put("categoria", "");
				ValidatorForm validateVacio = new ValidatorFormIsEmpty();
				validateVacio.setValues(form);
				if (!(validateVacio.validate())) {
					//serviceRecurso.insertRecurso(recursoBean.getNombre(), recursoBean.getCantidad(), recursoBean.getIdCategoria());
					model.addAttribute("menssage", "Recurso registrado correctamente.");
					return "menssageDashboard";
				} else {
					ArrayList<Categoria> categorias = (ArrayList<Categoria>) serviceCategoria.listCategorias();
					model.addAttribute("nombre", recursoBean.getNombre());
					model.addAttribute("cantidad", recursoBean.getCantidad());
					model.addAttribute("categoria", categorias);
					model.addAttribute("errorRegistrar", "En la pestaña registrar: " + validateVacio.getError());
					return "recurso";
				}
			} else {
				model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
				return "menssage";
			}
		}
	
	@RequestMapping(value="/submitDeleteRercurso", method = RequestMethod.POST)
	public String submitRegistrar2(Model model, @ModelAttribute("recursoBean") RecursoBean recursoBean, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// Chequeo el inicio de session
		if (session.getAttribute("usuario") != null) {
			model.addAttribute("rol", session.getAttribute("rol"));
			// Validacion del formulario
			HashMap<String, String> form = new HashMap<String, String>();
			form.put("recurso", recursoBean.getNombre());
			ValidatorForm validateVacio = new ValidatorFormIsEmpty();
			ArrayList<ValidatorForm> validadores = new ArrayList<ValidatorForm>();
			validadores.add(validateVacio);
			ValidatorForm validador = new ValidatorFormCompuesto(validadores);
			validador.setValues(form);
			if (!(validador.validate())) {
				//serviceInstitucion.deleteInstitucion(institucionBean.getInstitucion());
				model.addAttribute("menssage", "Baja de recurso exitosa.");
				return "menssageDashboard";
			} else {
				ArrayList<Categoria> categorias = (ArrayList<Categoria>) serviceCategoria.listCategorias();
				model.addAttribute("nombre", recursoBean.getNombre());
				model.addAttribute("cantidad", recursoBean.getCantidad());
				model.addAttribute("categoria", categorias);
				model.addAttribute("errorRegistrar", "En la pestaña eliminar: " + validateVacio.getError());
				return "recurso";
			}
		} else {
			model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}
	}
	
	@RequestMapping(value="/submitUpdateRercurso", method = RequestMethod.POST)
	public String submitRegistrar3(Model model, @ModelAttribute("recursoBean") RecursoBean recursoBean, HttpServletRequest request) {
		// Chequeo el inicio de session
		HttpSession session = request.getSession();
		if (session.getAttribute("usuario") != null) {
			model.addAttribute("rol", session.getAttribute("rol"));
			// Validacion del formulario
			HashMap<String, String> form = new HashMap<String, String>();
		
			if(recursoBean.getIdCategoria().length > 0)
				form.put("categoria", recursoBean.getIdCategoria()[0]);
			else
				form.put("categoria", "");
			form.put("nombre", recursoBean.getNombre());
			form.put("cantidad", recursoBean.getCantidad());
			ValidatorForm validateVacio = new ValidatorFormIsEmpty();
			validateVacio.setValues(form);
			if (!(validateVacio.validate())) {
				//serviceRecurso.insertRecurso(recursoBean.getNombre(), recursoBean.getCantidad(), recursoBean.getIdCategoria());
				model.addAttribute("menssage", "Recurso modificado correctamente.");
				return "menssageDashboard";
			} else {
				ArrayList<Categoria> categorias = (ArrayList<Categoria>) serviceCategoria.listCategorias();
				model.addAttribute("nombre", recursoBean.getNombre());
				model.addAttribute("cantidad", recursoBean.getCantidad());
				model.addAttribute("categoria", categorias);
				model.addAttribute("errorRegistrar", "En la pestaña modificar: " + validateVacio.getError());
				return "recurso";
			}
		} else {
			model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}
	}
  }

