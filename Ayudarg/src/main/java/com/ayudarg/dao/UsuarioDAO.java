package com.ayudarg.dao;

import java.util.List;

import com.ayudarg.model.Usuario;

public interface UsuarioDAO {
	public List<Usuario> listUsuarios();
	public boolean usuarioByUsernameAndPassword(String email, String password);
}
