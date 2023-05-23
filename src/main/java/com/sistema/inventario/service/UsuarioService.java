package com.sistema.inventario.service;

import java.util.List;

import com.sistema.inventario.entidades.Rol;
import com.sistema.inventario.entidades.Usuario;

public interface UsuarioService {

	public Usuario crearUsuario(Usuario usuario);

	public List<Usuario> obtenerTodosLosUsuario();

	public Usuario findById(long id);

	public Usuario eliminarUsuario(long id);

	public Usuario actualizarUsuario(Usuario usuario, long id);

	public Usuario asignarRol(Usuario usuario, Rol rol);
}
