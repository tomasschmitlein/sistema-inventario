package com.sistema.inventario.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.inventario.entidades.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>{

}
