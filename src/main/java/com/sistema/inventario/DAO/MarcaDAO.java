package com.sistema.inventario.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.inventario.entidades.Marca;

public interface MarcaDAO extends JpaRepository<Marca, Long>{

}
