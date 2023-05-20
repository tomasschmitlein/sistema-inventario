package com.sistema.inventario.service;

import java.util.List;

import com.sistema.inventario.entidades.Marca;

public interface MarcaService {

	public Marca crearMarca(Marca marca);
    
    public List<Marca> obtenerTodosLasMarcas();
    
    public Marca findById(long id);
    
    public Marca eliminarMarca(long id);
    
    public Marca actualizarMarca(Marca marca, long id);

	
}
