package com.ayudarg.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayudar.view.beans.AsignarBean;
import com.ayudar.view.beans.CategoriaBean;
import com.ayudar.view.beans.InstitucionBean;
import com.ayudar.view.beans.OptionBean;
import com.ayudar.view.beans.UsuarioBajaBean;
import com.ayudar.view.beans.UsuarioBean;
import com.ayudarg.model.Categoria;
import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.LocalidadesSQL;
import com.ayudarg.model.ProvinciasSQL;
import com.ayudarg.model.Rol;
import com.ayudarg.model.UsuarioSQL;
import com.ayudarg.service.GeoService;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.RolService;
import com.ayudarg.service.UsuarioService;
import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ABMUsuarioController {

	private UsuarioService serviceUsuarios;
	private GeoService serviceGeo;
	private InstitucionService servicesInst;
	private RolService servicesRol;
	
	public UsuarioService getServiceUsuarios() {
		return serviceUsuarios;
	}

	public void setServiceUsuarios(UsuarioService serviceUsuarios) {
		this.serviceUsuarios = serviceUsuarios;
	}
	
	public RolService getServiceRol() {
		return servicesRol;
	}

	@Autowired(required = true)
	@Qualifier(value = "UsuarioService")
	public void setPersonService(UsuarioService ps) {
		this.serviceUsuarios = ps;
	}

	@Autowired(required = true)
	@Qualifier(value = "GeoService")
	public void setGeoServicee(GeoService ol) {
		this.serviceGeo = ol;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "InstitucionService")
	public void setInstitucionesServicee(InstitucionService inst) {
		this.servicesInst = inst;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "RolService")
	public void rolServicee(RolService rol) {
		this.servicesRol = rol;
	}

	public GeoService getServiceGeo() {
		return serviceGeo;
	}

	public void setServiceGeo(GeoService serviceGeo) {
		this.serviceGeo = serviceGeo;
	}
	
	@RequestMapping(value = "/bajaUsuario", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
			HttpSession session = request.getSession();
			ArrayList<ProvinciasSQL> provincias = (ArrayList<ProvinciasSQL>) serviceGeo.listAllProvincias(); 
			ArrayList<UsuarioSQL> usuarios = (ArrayList<UsuarioSQL>) serviceUsuarios.listUsuarios();
			List<InstitucionSQL> instituciones =  servicesInst.listInstituciones();
			List<Rol> roles = servicesRol.listRoles();
			model.addAttribute("usuario", usuarios);
			model.addAttribute("provincias", provincias);
			model.addAttribute("rol", session.getAttribute("rol"));
			model.addAttribute("usuarioBajaBean", new UsuarioBajaBean());
			model.addAttribute("asignarBean", new AsignarBean());
			model.addAttribute("usuarioBean", new UsuarioBean());
			model.addAttribute("instituciones", instituciones);
			model.addAttribute("roles", roles);
			if(session.getAttribute("usuario")!= null){
				return "bajaUsuario";
			}else{
			    model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
				return "menssage";
			}
	}

	@RequestMapping(value = "/getUsuariosById", method = RequestMethod.POST)
	public @ResponseBody String getUsuariosById(UsuarioBean usuarioBean) {
		Gson gson = new Gson();
		UsuarioSQL usuario = serviceUsuarios.getUsuarioById(usuarioBean.getIdUsuario());
		UsuarioBean usuariobean = new UsuarioBean();
		usuariobean.setContrasenia(usuario.getContrasenia().toString());
		usuariobean.setNombre(usuario.getNombre());
		usuariobean.setEmail(usuario.getEmail());
		usuariobean.setTelefono(usuario.getTelefono().toString());
		usuariobean.setCelular(usuario.getCelular().toString());
		String jsonInString = gson.toJson(usuarioBean);
		return jsonInString;
	}
	
	@RequestMapping(value="/submitAltaUsuario", method = RequestMethod.POST)
	public String submitRegistrar(Model model, @ModelAttribute("usuarioBajaBean") UsuarioBean usuarioBean) {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
		fecha = formatoDelTexto.parse(usuarioBean.getFechaDeNacimiento());
		} catch (ParseException ex) {
		ex.printStackTrace();
		}
		Rol rol = servicesRol.getRolById(usuarioBean.getRoles());
		serviceUsuarios.insertUsuario(usuarioBean.getUsuario(), usuarioBean.getContrasenia(),
				usuarioBean.getNombre(), usuarioBean.getEmail(), usuarioBean.getTelefono(), usuarioBean.getCelular(),
				fecha, usuarioBean.getLocalidad(), rol);			
	    model.addAttribute("menssage", "Su registro fue exitoso y ya puede acceder a la plataforma.");
		return "menssage";	
	}
	
	@RequestMapping(value="/submitBajaUsuario", method = RequestMethod.POST)
	public String submitBajaUsuario(Model model, @ModelAttribute("usuarioBajaBean") UsuarioBean usuarioBean) {
		serviceUsuarios.deleteUsuario(usuarioBean.getIdUsuario());
	    model.addAttribute("menssage", "Su registro fue exitoso y ya puede acceder a la plataforma.");
		return "menssage";	
	}
	
	@RequestMapping(value="/submitAsignarInstitucion", method = RequestMethod.POST)
	public String submitAsignarInstitucion(Model model, @ModelAttribute("asignarBean") AsignarBean asignarBean) {
		InstitucionSQL institucion = servicesInst.getInstitucionById(asignarBean.getInstitucion());
		UsuarioSQL usuario = serviceUsuarios.getUsuarioById(asignarBean.getUsuario());
		serviceUsuarios.asignarInstitucion(usuario, institucion);
	    model.addAttribute("menssage", "La asignacion se realiz� correctamente.");
		return "menssage";	
	}
	
	@RequestMapping(value="/submitUpdateUsuario", method = RequestMethod.POST)
	public String submitUpdateUsuario(Model model, @ModelAttribute("usuarioBajaBean") UsuarioBean usuarioBean) {
		return "modificadoCorrectamente";	
	}
}