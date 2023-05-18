package com.sistema.inventario.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.inventario.entidades.Producto;

public interface ProductoDAO extends JpaRepository<Producto, Long>{

}
