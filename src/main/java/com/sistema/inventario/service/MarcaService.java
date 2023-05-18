package com.sistema.inventario.service;

import java.util.List;

import com.sistema.inventario.entidades.Marca;

public interface MarcaService {

	public Marca crearProducto(Marca marca);
    
    public List<Marca> obtenerTodosLosProductos();
    
    public Marca findById(long id);
    
    public Marca eliminarProducto(long id);
    
    public Marca actualizarProducto(Marca marca, long id);

	
}
