package com.sistema.inventario.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.inventario.entidades.ArticuloCarrito;

public interface ArticulosCarritoDAO extends JpaRepository<ArticuloCarrito, Long>{

}
