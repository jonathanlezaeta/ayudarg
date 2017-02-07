package com.ayudarg.service;

import java.util.List;

import com.ayudarg.model.Usuario;

public interface UsuarioService {
	public List<Usuario> listUsuarios();
	public boolean usuarioByUsernameAndPassword(String email, String password);
}
