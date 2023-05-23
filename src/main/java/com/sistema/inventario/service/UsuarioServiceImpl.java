package com.sistema.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.inventario.DAO.UsuarioDAO;
import com.sistema.inventario.entidades.Marca;
import com.sistema.inventario.entidades.Rol;
import com.sistema.inventario.entidades.Usuario;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO userDAO;

	@Override
	public Usuario crearUsuario(Usuario usuario) {

		usuario = userDAO.save(usuario);

		return usuario;

	}

	@Override
	public List<Usuario> obtenerTodosLosUsuario() {
		List<Usuario> usuarios = userDAO.findAll();

		return usuarios;
	}

	@Override
	public Usuario findById(long id) {
		Usuario usuario = userDAO.findById(id).orElseThrow(null);

		return usuario;
	}

	@Override
	public Usuario eliminarUsuario(long id) {
		Usuario usuario = userDAO.findById(id).orElseThrow(null);

		userDAO.delete(usuario);

		return usuario;
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario, long id) {
		Usuario usuario2 = userDAO.findById(id).orElseThrow(null);

		usuario2.setEmail(usuario.getEmail()); 
		usuario2.setPassword(usuario.getPassword());
		usuario2.setRoles(usuario.getRoles());
		
		userDAO.save(usuario2);

		return usuario2;
	}

	@Override
	public Usuario asignarRol(Usuario usuario, Rol rol) {
		// TODO Auto-generated method stub
		return null;
	}

}
