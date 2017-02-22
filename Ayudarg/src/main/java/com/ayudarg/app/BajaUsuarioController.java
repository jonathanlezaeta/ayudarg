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
import com.ayudar.view.beans.UsuarioBajaBean;
import com.ayudar.view.beans.UsuarioBean;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.UsuarioSQL;
import com.ayudarg.service.UsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BajaUsuarioController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(RegistraseController.class);
	private UsuarioService serviceUsuarios;

	public UsuarioService getServiceUsuarios() {
		return serviceUsuarios;
	}

	public void setServiceUsuarios(UsuarioService serviceUsuarios) {
		this.serviceUsuarios = serviceUsuarios;
	}

	@Autowired(required = true)
	@Qualifier(value = "UsuarioService")
	public void setPersonService(UsuarioService ps) {
		this.serviceUsuarios = ps;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/bajaUsuario", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
			ArrayList<UsuarioSQL> usuarios = (ArrayList<UsuarioSQL>) serviceUsuarios.listUsuarios();
			model.addAttribute("usuario", usuarios);
			model.addAttribute("usuarioBajaBean", new UsuarioBajaBean());
		HttpSession session = request.getSession();
			if(session.getAttribute("usuario")!= null){
				return "bajaUsuario";
			}else{
			    model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
				return "menssage";
			}
	}

	@RequestMapping(value="/submitBajaUsuario", method = RequestMethod.POST)
	public String submitRegistrar(Model model, @ModelAttribute("usuarioBajaBean") UsuarioBajaBean usuarioBajaBean) {
//		serviceUsuarios.insertUsuario(1, usuarioBean.getUsuario(), usuarioBean.getContrasenia(),
//				usuarioBean.getNombre(), usuarioBean.getEmail(), usuarioBean.getTelefono(), usuarioBean.getCelular(),
//				usuarioBean.getFechaDeNacimiento(), usuarioBean.getCiudadOrigen());		
//	    model.addAttribute("menssage", "Su registro fue exitoso y ya puede acceder a la plataforma.");
		return "menssage";
	}

}