package com.ayudarg.service;

import java.util.Date;
import java.util.List;

import com.ayudarg.model.InstitucionSQL;
import com.ayudarg.model.UsuarioSQL;

public interface UsuarioService {
	public List<UsuarioSQL> listUsuarios();
	public UsuarioSQL usuarioByUsernameAndPassword(String email, String password);
	public UsuarioSQL getUsuarioById(String id);
	public void insertUsuario(String usuario, String contrasenia, String nombre, String email, String telefono, String celular, Date fechaDeCreacion, String localidadesId);
	public void updateUsuario(String idUsuario, String usuario, String contrasenia, String nombre, String email,
			String telefono, String celular, Date fechaDeNacimiento, String localidadesId);
	public void deleteUsuario(String idUsuario);
	public void asignarInstitucion(UsuarioSQL usuario, InstitucionSQL institucion);
}
