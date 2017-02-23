package com.ayudarg.dao;

import java.util.Date
;
import java.util.List;

import com.ayudarg.model.LocalidadesSQL;
import com.ayudarg.model.UsuarioSQL;

public interface UsuarioDAO {
	public List<UsuarioSQL> listUsuarios();
	public UsuarioSQL usuarioByUsernameAndPassword(String email, String password);
	public UsuarioSQL getUsuarioById(String id);
	public LocalidadesSQL getLocalidadesById(String id);
	public void insertUsuario(String usuario, String contrasenia, String nombre, String email, String telefono, String celular, Date fechaDeNacimiento, String localidadesId);
	public UsuarioSQL getUsuarioByEmail(String id);
	public void updateUsuario(String idUsuario, String usuario, String contrasenia, String nombre, String email,
			String telefono, String celular, Date fechaDeNacimiento, String localidadesId);
	public void deleteUsuario(String idUsuario);
}
