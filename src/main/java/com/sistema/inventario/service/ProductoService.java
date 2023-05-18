package com.sistema.inventario.service;

import java.util.List;

import com.sistema.inventario.entidades.Producto;

public interface ProductoService {

	 public Producto crearProducto(Producto producto);
	    
	    public List<Producto> obtenerTodosLosProductos();
	    
	    public Producto findById(long id);
	    
	    public Producto eliminarProducto(long id);
	    
	    public Producto actualizarProducto(Producto producto, long id);
	
}
