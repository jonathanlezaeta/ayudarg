package com.ayudarg.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

import com.ayudar.view.beans.LoginBean;
import com.ayudar.view.beans.RegistrarseBean;
import com.ayudarg.model.ProvinciasSQL;
import com.ayudarg.model.Rol;
import com.ayudarg.model.UsuarioSQL;
import com.ayudarg.service.GeoService;
import com.ayudarg.service.RolService;
import com.ayudarg.service.UsuarioService;
import com.ayudarg.validators.ValidatorForm;
import com.ayudarg.validators.ValidatorFormIsEmpty;

@Controller
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = -3450969163801147075L;
	private UsuarioService serviceUsuarios;
	private RolService serviceRol;
	private GeoService serviceGeo;

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

	public UsuarioService getServiceUsuarios() {
		return serviceUsuarios;
	}

	@Autowired(required = true)
	@Qualifier(value = "UsuarioService")
	public void setServiceUsuarios(UsuarioService serviceUsuarios) {
		this.serviceUsuarios = serviceUsuarios;
	}

	public RolService getServiceRol() {
		return serviceRol;
	}

	@Autowired(required = true)
	@Qualifier(value = "RolService")
	public void setServiceRol(RolService serviceRol) {
		this.serviceRol = serviceRol;
	}

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("usuario", session.getAttribute("usuario"));
		model.addAttribute("rol", session.getAttribute("rol"));
		if (session.getAttribute("usuario") != null) {
			return "dashboard";
		} else {
			model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginbean") LoginBean loginBean, HttpServletRequest request) {
		ArrayList<ProvinciasSQL> provincias = (ArrayList<ProvinciasSQL>) serviceGeo.listAllProvincias();
		HashMap<String, String> form = new HashMap<String, String>();
		form.put("usuario", loginBean.getUsuario());
		form.put("contrasenia", loginBean.getContrasenia());
		ValidatorForm validate = new ValidatorFormIsEmpty();
		validate.setValues(form);
		UsuarioSQL usuario = serviceUsuarios.usuarioByUsernameAndPassword(loginBean.getUsuario(),
				loginBean.getContrasenia());
		if (!(validate.validate()) && usuario != null) {
			HttpSession session = request.getSession(true);
			Iterator rolIterator = usuario.getRol().iterator();
			while (rolIterator.hasNext()) {
				Rol rolAsignado = (Rol) rolIterator.next();
				session.setAttribute("rol", rolAsignado.getNombre());
				model.addAttribute("rol", rolAsignado.getNombre());
			}
			session.setAttribute("usuario", usuario);
			return "dashboard";
		} else {
			model.addAttribute("registrarseBean", new RegistrarseBean());
			model.addAttribute("provincias", provincias);
			model.addAttribute("error", false);
			model.addAttribute("menssageLogin", "Error: Usuario o contraseña incorrectos.");
			return "Login";
		}

	}

}
