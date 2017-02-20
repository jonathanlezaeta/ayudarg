package com.ayudarg.app;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.elasticsearch.action.index.IndexResponse;
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
import org.springframework.web.servlet.ModelAndView;

import com.ayudar.elasticsearch.model.Institucion;
import com.ayudar.elasticsearch.model.RecursoModelEs;
import com.ayudar.elasticsearch.model.Usuario;
import com.ayudar.view.beans.OptionBean;
import com.ayudar.view.beans.RegistrarseBean;
import com.ayudar.view.beans.UsuarioBean;
import com.ayudarg.model.LocalidadesSQL;
import com.ayudarg.model.ProvinciasSQL;
import com.ayudarg.service.GeoService;
import com.ayudarg.service.UsuarioService;
import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private GeoService serviceGeo;

	@Autowired(required = true)
	@Qualifier(value = "GeoService")
	public void setGeoServicee(GeoService ps) {
		this.setServiceGeo(ps);
	}	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<ProvinciasSQL> provincias = serviceGeo.listAllProvincias();
		model.addAttribute("registrarseBean", new RegistrarseBean());
		model.addAttribute("provincias", provincias);
		return "Login";
	}
	
	@RequestMapping(value = "/getLocalidadesById", method = RequestMethod.POST)
    public @ResponseBody 
    String getTime(RegistrarseBean registrarseBean) {
			Gson gson = new Gson();
			List<LocalidadesSQL> localidades = serviceGeo.getLocalidadesByIdO(registrarseBean.getProvincia());
			ArrayList<OptionBean> optionResponse = new ArrayList<OptionBean>();
			for(LocalidadesSQL l : localidades){
				OptionBean data = new OptionBean();
				data.setValue(String.valueOf(l.getId()));
				data.setOption(l.getLocalidad());
				optionResponse.add(data);
			}
			String jsonInString = gson.toJson(optionResponse);
        return jsonInString;
    }

	public GeoService getServiceGeo() {
		return serviceGeo;
	}

	public void setServiceGeo(GeoService serviceGeo) {
		this.serviceGeo = serviceGeo;
	}
	
}
