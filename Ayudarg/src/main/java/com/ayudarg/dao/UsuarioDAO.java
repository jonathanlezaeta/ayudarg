package com.ayudarg.dao;

import java.util.Date;
import java.util.List;

import com.ayudarg.model.Categoria;
import com.ayudarg.model.UsuarioSQL;

public interface UsuarioDAO {
	public List<UsuarioSQL> listUsuarios();
	public boolean usuarioByUsernameAndPassword(String email, String password);
	public void insertUsuario(int rolIdRol, String usuario, String contrasenia, String nombre, String email, String telefono, String celular, Date fechaDeNacimiento, String ciudadOrigen);
	UsuarioSQL getUsuarioById(String id);
}
