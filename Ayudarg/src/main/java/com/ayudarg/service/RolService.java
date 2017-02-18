package com.ayudarg.service;

import java.util.List;
import com.ayudarg.model.Rol;

public interface RolService {
	public List<Rol> listRoles();
	public Rol getRolById(String id);
}
