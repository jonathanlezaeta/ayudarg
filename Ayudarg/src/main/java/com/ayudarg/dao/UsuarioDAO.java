package com.ayudarg.dao;

import java.util.Date
;
import java.util.List;

import com.ayudarg.model.LocalidadesSQL;
import com.ayudarg.model.UsuarioSQL;

public interface UsuarioDAO {
	public List<UsuarioSQL> listUsuarios();
	public UsuarioSQL usuarioByUsernameAndPassword(String email, String password);
	public void insertUsuario( String usuario, String contrasenia, String nombre, String email, String telefono, String celular, Date fechaDeCreacion, String localidadesId);
	public UsuarioSQL getUsuarioById(String id);
	public LocalidadesSQL getLocalidadesById(String id);
}
