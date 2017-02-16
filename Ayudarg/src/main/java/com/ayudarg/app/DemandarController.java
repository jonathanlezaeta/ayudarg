package com.ayudarg.app;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ayudar.view.beans.RecursoBean;
import com.ayudarg.model.Recurso;
import com.ayudarg.service.RecursoService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class DemandarController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(RegistraseController.class);
	private RecursoService serviceRecurso;
	

	public RecursoService getServiceRecurso() {
		return serviceRecurso;
	}

	public void setServiceRecurso(RecursoService serviceRecurso) {
		this.serviceRecurso = serviceRecurso;
	}

	
	@Autowired(required = true)
	@Qualifier(value = "RecursoService")
	public void setRecursoService(RecursoService ps) {
		this.serviceRecurso = ps;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/demandar", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "demandar";
	}

	@RequestMapping(value="/submitAltaDemanda", method = RequestMethod.POST)
	public String submitUpdate(String nombre, Model model, @ModelAttribute("recursoBean") RecursoBean recursoBean) {

		Recurso rec = new Recurso();
		rec.setNombre(nombre);

		if(rec.getNombre().equals(recursoBean.getNombre()) && recursoBean.getCantidad() > 0)
			//recursoBean.setActivo(false);
			recursoBean.setCantidad(recursoBean.getCantidad()-1);
		return "No hay stock del producto que desea";
		
	}
}