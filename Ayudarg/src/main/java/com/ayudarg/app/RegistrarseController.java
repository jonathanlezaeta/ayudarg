package com.ayudarg.app;

import java.text.DateFormat;
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

import com.ayudar.view.beans.UsuarioBean;
import com.ayudarg.service.UsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RegistrarseController {

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
	@RequestMapping(value = "/registrarse", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "registrarse";
	}

	@RequestMapping(value="/submitRegistrar", method = RequestMethod.POST)
	public String submitRegistrar(Model model, @ModelAttribute("usuarioBean") UsuarioBean usuarioBean) {
		serviceUsuarios.insertUsuario(1, usuarioBean.getUsuario(), usuarioBean.getContrasenia(),
				usuarioBean.getNombre(), usuarioBean.getEmail(), usuarioBean.getTelefono(), usuarioBean.getCelular(),
				usuarioBean.getFechaDeNacimiento(), usuarioBean.getCiudadOrigen());		
		return "registrarseCorrectamente";
	}

}