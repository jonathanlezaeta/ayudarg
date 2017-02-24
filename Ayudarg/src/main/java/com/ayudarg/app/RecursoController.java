package com.ayudarg.app;

import java.util.HashSet;
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
import com.ayudar.view.beans.RecursoBean;
import com.ayudarg.model.Rol;
import com.ayudarg.model.UsuarioSQL;
import com.ayudarg.service.InstitucionService;
import com.ayudarg.service.RecursoService;
import com.ayudarg.service.RolService;
import com.ayudarg.service.UsuarioService;

@Controller
public class RecursoController {
	
	private RecursoService serviceRecurso;

	public RecursoService getServiceRecurso() {
		return serviceRecurso;
	}

	public void setServiceRecurso(RecursoService serviceRecurso) {
		this.serviceRecurso = serviceRecurso;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "RecursoService")
	public void setRecursoService(RecursoService rs) {
		this.serviceRecurso = rs;
	}
	
	@RequestMapping(value = "/recurso", method = RequestMethod.GET)
	public String dashboard(Locale locale, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("usuario", session.getAttribute("usuario"));
		model.addAttribute("rol", session.getAttribute("rol"));
		model.addAttribute("recursoBean", new RecursoBean());
		if(session.getAttribute("usuario")!= null){
			return "recurso";
		}else{
		    model.addAttribute("menssage", "Por favor inicie sesion para poder acceder al sistema.");
			return "menssage";
		}
	}	
}
