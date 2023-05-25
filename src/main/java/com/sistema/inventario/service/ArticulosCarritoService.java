package com.sistema.inventario.service;

import java.util.List;

import com.sistema.inventario.entidades.ArticuloCarrito;

public interface ArticulosCarritoService {

	public ArticuloCarrito crearArticuloCarrito(ArticuloCarrito articulo);

	public List<ArticuloCarrito> obtenerTodosLosArticuloCarrito();

	public ArticuloCarrito findById(long id);

	public ArticuloCarrito eliminarArticuloCarrito(long id);

	public ArticuloCarrito actualizarArticuloCarrito(ArticuloCarrito articulo, long id);

	
}
