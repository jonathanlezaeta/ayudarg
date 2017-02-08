package com.ayudarg.service;

import java.util.Date;
import java.util.List;

import com.ayudarg.model.Usuario;

public interface UsuarioService {
	public List<Usuario> listUsuarios();
	public boolean usuarioByUsernameAndPassword(String email, String password);
	public void insertUsuario(int rolIdRol, String usuario, String contrasenia, String nombre, String email, String telefono, String celular, Date fechaDeNacimiento, String ciudadOrigen);
}
