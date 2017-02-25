package com.ayudarg.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ayudar.view.beans.RegistrarseBean;
import com.ayudarg.model.ProvinciasSQL;
import com.ayudarg.model.Rol;
import com.ayudarg.service.GeoService;
import com.ayudarg.service.UsuarioService;
import com.ayudarg.validators.ValidatorExisteUsuario;
import com.ayudarg.validators.ValidatorForm;
import com.ayudarg.validators.ValidatorFormCompuesto;
import com.ayudarg.validators.ValidatorFormIsEmpty;

@Controller
public class RegistrarseController {

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

	@RequestMapping(value = "/registrarse", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "registrarse";
	}

	@RequestMapping(value = "/submitRegistrar", method = RequestMethod.POST)
	public String submitRegistrar(Model model, @ModelAttribute("registrarseBean") RegistrarseBean registrarseBean) {
		HashMap<String, String> form = new HashMap<String, String>();
		form.put("usuario", registrarseBean.getUsuario());
		form.put("contraseña", registrarseBean.getContrasenia());
		form.put("nombre ", registrarseBean.getNombre());
		form.put("email", registrarseBean.getEmail());
		form.put("telefono", registrarseBean.getCelular());
		form.put("fecha deNacimiento", registrarseBean.getFechaDeNacimiento());
		form.put("localidad", registrarseBean.getLocalidad());
		ValidatorForm validateVacio = new ValidatorFormIsEmpty();
		ValidatorForm validateExisteUsuario = new ValidatorExisteUsuario(serviceUsuarios);
		ArrayList<ValidatorForm> validadores = new ArrayList<ValidatorForm>();
		validadores.add(validateVacio);
		validadores.add(validateExisteUsuario);
		ValidatorForm validador = new ValidatorFormCompuesto(validadores);
		validador.setValues(form);
		if (!(validador.validate())) {
			String f = null;
			Date dtDob = new Date(registrarseBean.getFechaDeNacimiento());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			f = sdf.format(dtDob);
			Date fecha = null;
			try {
				fecha = sdf.parse(f);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Siempre seteo el Rol de Usuauario cuando se registran
			Rol rol = new Rol();
			rol.setIdRol(1);
			rol.setNombre("U");
			serviceUsuarios.insertUsuario(registrarseBean.getUsuario(), registrarseBean.getContrasenia(),
					registrarseBean.getNombre(), registrarseBean.getEmail(), registrarseBean.getTelefono(),
					registrarseBean.getCelular(), fecha, registrarseBean.getLocalidad(), rol);
			ArrayList<ProvinciasSQL> provincias = (ArrayList<ProvinciasSQL>) serviceGeo.listAllProvincias();
			model.addAttribute("provincias", provincias);
			model.addAttribute("error", false);
			model.addAttribute("menssage", "Felicitaciones ya puede acceder a Ayudarg!");
			model.addAttribute("email", registrarseBean.getEmail());
			model.addAttribute("contrasenia", registrarseBean.getContrasenia());
			return "Login";
		} else {
			ArrayList<ProvinciasSQL> provincias = (ArrayList<ProvinciasSQL>) serviceGeo.listAllProvincias();
			model.addAttribute("provincias", provincias);
			model.addAttribute("error", true);
			model.addAttribute("usuario", registrarseBean.getUsuario());
			model.addAttribute("contrasenia", registrarseBean.getContrasenia());
			model.addAttribute("nombre", registrarseBean.getNombre());
			model.addAttribute("email", registrarseBean.getEmail());
			model.addAttribute("telefono", registrarseBean.getCelular());
			model.addAttribute("fechaDeNacimiento", registrarseBean.getFechaDeNacimiento());
			model.addAttribute("localidad", registrarseBean.getLocalidad());
			model.addAttribute("menssage", "Error: " + validador.getError());
			return "Login";
		}
	}
}