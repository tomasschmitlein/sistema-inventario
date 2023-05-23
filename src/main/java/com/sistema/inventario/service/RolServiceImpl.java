package com.sistema.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.inventario.DAO.RolDAO;
import com.sistema.inventario.entidades.Rol;

@Service
@Transactional
public class RolServiceImpl implements RolService{

	
	@Autowired
	private RolDAO rolDAO;

	@Override
	public Rol crearRol(Rol rol) {

		rol = rolDAO.save(rol);

		return rol;
	}

	@Override
	public List<Rol> obtenerTodosLosRoles() {
		List<Rol> rols = rolDAO.findAll();

		return rols;
	}

	@Override
	public Rol findById(long id) {

		Rol rol = rolDAO.findById(id).orElseThrow(null);

		return rol;
	}

	@Override
	public Rol eliminarRol(long id) {
		Rol rol = rolDAO.findById(id).orElseThrow(null);

		rolDAO.delete(rol);

		return rol;
	}

	@Override
	public Rol actualizarRol(Rol rol, long id) {
		
		Rol nvoRol = rolDAO.findById(id).orElseThrow(null);
		
		nvoRol.setNombre(rol.getNombre());
		
		rolDAO.save(nvoRol);
		
		return nvoRol;
	}
	
}
