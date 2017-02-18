package com.ayudarg.dao;

import java.util.List;
import com.ayudarg.model.Rol;

public interface RolDAO {
	public List<Rol> listRoles();
	public Rol getRolById(String id);
}
