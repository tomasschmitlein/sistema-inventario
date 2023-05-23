package com.sistema.inventario.service;

import java.util.List;

import com.sistema.inventario.entidades.Rol;

public interface RolService {

	public Rol crearRol(Rol rol);
	
    public List<Rol> obtenerTodosLosRoles();
    
    public Rol findById(long id);
    
    public Rol eliminarRol(long id);
    
    public Rol actualizarRol(Rol rol, long id);

	
}
