package com.ayudarg.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayudar.elasticsearch.model.Institucion;
import com.ayudar.elasticsearch.model.RecursoModelEs;
import com.ayudar.elasticsearch.model.Usuario;
import com.ayudar.view.beans.CategoriaBean;
import com.ayudar.view.beans.DonarDemandarBean;
import com.ayudar.view.beans.InstitucionBajaBean;
import com.ayudar.view.beans.InstitucionBean;
import com.ayudar.view.beans.LoginBean;
import com.ayudar.view.beans.RecursoBean;
import com.ayudarg.elasticsearch.ElasticSearchConector;
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
import com.google.gson.Gson;
import com.spatial4j.core.distance.GeodesicSphereDistCalc.Haversine;

@Controller
public class RecursoController {
	private ElasticSearchConector es;
	private CategoriaService serviceCategoria;
	private InstitucionService serviceInstitucion;

	RecursoController(){
		es = new ElasticSearchConector();
	}	
	
	public CategoriaService getServiceCategoria() {
		return serviceCategoria;
	}

	public void setServiceCategoria(CategoriaService serviceCategoria) {
		this.serviceCategoria = serviceCategoria;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "CategoriaService")
	public void setCategoriaService(CategoriaService cs) {
		this.serviceCategoria = cs;
	}

	@Autowired(required = true)
	@Qualifier(value = "InstitucionService")
	public void setInstitucionService(InstitucionService cs) {
		this.serviceInstitucion = cs;
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
			RecursoModelEs nuevoRecurso = new RecursoModelEs();
			UsuarioSQL us = (UsuarioSQL) session.getAttribute("usuario");
			Set<InstitucionSQL> inst = us.getInstitucion();
			ArrayList<InstitucionSQL> instituciones = new ArrayList<InstitucionSQL>();
			Iterator it = inst.iterator();
			while(it.hasNext()){
				InstitucionSQL institcuion = (InstitucionSQL) it.next();
				instituciones.add(institcuion);
			}
	 		Gson gson = new Gson();
			Client client = es.getElasticSearchClient();
			SearchResponse requestBuilder = client.prepareSearch("ayudarg")
					.setTypes("recurso")
					.setSearchType(SearchType.QUERY_AND_FETCH)
				    .setQuery(QueryBuilders.matchQuery("institucion.idInstitucion", String.valueOf(instituciones.get(0).getIdInstitucion())))
				    .setFrom(0).setSize(60).setExplain(true)
				    .execute()
				    .actionGet();
			SearchHit[] results = requestBuilder.getHits().getHits(); 
			ArrayList<RecursoModelEs> resp = new ArrayList<RecursoModelEs>();
			for (SearchHit hit : results) {
				RecursoModelEs recurso = gson.fromJson(hit.getSourceAsString(), RecursoModelEs.class);
				resp.add(recurso);
			}		
			model.addAttribute("recursos", resp);
			model.addAttribute("instituciones", instituciones);
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
					String uniqueId = UUID.randomUUID().toString();	
					RecursoModelEs nuevoRecurso = new RecursoModelEs();
					UsuarioSQL us = (UsuarioSQL) session.getAttribute("usuario");
					Usuario usuario = new Usuario();
					usuario.setIdUsuario(us.getIdUsuario());
					usuario.setEmail(us.getEmail());
					usuario.setLocalidadesId(String.valueOf(us.getLocalidadesId().getLocalidadesId()));
					usuario.setTelefono(us.getTelefono());
					usuario.setCelular(us.getCelular());
					usuario.setActivo(us.getActivo());
//					nuevoRecurso.setUsuario(us);
					InstitucionSQL institucion = serviceInstitucion.getInstitucionById(recursoBean.getIdInstitucion());
					Institucion inst = new Institucion();
					inst.setId(String.valueOf(institucion.getIdInstitucion()));
					inst.setDireccion(institucion.getDireccion());
					inst.setDirector(institucion.getDirector());
					inst.setLocalidadId(String.valueOf(institucion.getLocalidadesId()));
					inst.setMail(institucion.getEmail());
					inst.setNombre(institucion.getNombre());
					inst.setSitioWeb(institucion.getSitioWeb());
					inst.setTelefono(institucion.getTelefono());
					inst.setTipo(institucion.getTipo());
					ArrayList<Long> categorias = new ArrayList<Long>();
					for(String s : recursoBean.getIdCategoria()){
						categorias.add(Long.parseLong(s));
					}
					nuevoRecurso.setId(uniqueId);
					nuevoRecurso.setNombre(recursoBean.getNombre());
					nuevoRecurso.setCategorias(categorias);
					nuevoRecurso.setCantidad(recursoBean.getCantidad());
					nuevoRecurso.setDescripcion(recursoBean.getDescripcion());
					Date fecha = new Date();
					nuevoRecurso.setFechaIngreso(fecha);
					nuevoRecurso.setUsuario(usuario);
					nuevoRecurso.setInstitucion(inst);
					Gson gson = new Gson();
			 		Client client = es.getElasticSearchClient();
			 		IndexResponse responseAdd = client.prepareIndex("ayudarg", "recurso", uniqueId)
							.setSource(gson.toJson(nuevoRecurso)).execute().actionGet();
					if(!responseAdd.isCreated()){
						System.out.println("The document was not added");
					}
					client.admin().indices().prepareRefresh("ayudarg").get();				
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
				Client client = es.getElasticSearchClient();
				DeleteRequestBuilder responseDelete = client.prepareDelete("ayudarg", "recurso", String.valueOf(recursoBean.getId()));
				responseDelete.execute();
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
				
				
				
				
				RecursoModelEs recurso =  es.getRecursoById(recursoBean.getId());
				recurso.setNombre(recursoBean.getNombre());
				recurso.setDescripcion(recursoBean.getDescripcion());
				recurso.setCantidad(recursoBean.getCantidad());
				String[] categorias = recursoBean.getIdCategoria();
				ArrayList<Long> cat = new ArrayList<Long>();
				for(String s : categorias){
					cat.add(Long.parseLong(s));
				}
				recurso.setCategorias(cat);
				es.updateRecurso(recurso);
				
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

	@RequestMapping(value = "/getRecursoById", method = RequestMethod.POST)
	public @ResponseBody String getUsuariosById(RecursoBean recursoBean) {
		Gson gson = new Gson();
		RecursoModelEs recurso = es.getRecursoById(recursoBean.getId());
		RecursoBean recursoSeleccionado = new RecursoBean();
		recursoSeleccionado.setId(recurso.getId());
		recursoSeleccionado.setDescripcion(recurso.getDescripcion());
		recursoSeleccionado.setNombre(recurso.getNombre());
	    recursoSeleccionado.setCantidad(recurso.getCantidad());
		ArrayList<Long> cats = recurso.getCategorias();
		String[] categorias = new String[recurso.getCategorias().size()];  
	    for(int i = 0 ;i < categorias.length; i++)
	    {  
	        if(i < cats.size()){
	        	categorias[i] = String.valueOf(cats.get(i));
	        }  
	    }  
	    recursoSeleccionado.setIdCategoria(categorias);
		return gson.toJson(recursoSeleccionado);
	}	
	
	public ElasticSearchConector getEs() {
		return es;
	}

	public void setEs(ElasticSearchConector es) {
		this.es = es;
	}

	public InstitucionService getServiceInstitucion() {
		return serviceInstitucion;
	}

	public void setServiceInstitucion(InstitucionService serviceInstitucion) {
		this.serviceInstitucion = serviceInstitucion;
	}
  }

