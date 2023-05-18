package com.sistema.inventario.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.inventario.entidades.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria, Integer>{

}
