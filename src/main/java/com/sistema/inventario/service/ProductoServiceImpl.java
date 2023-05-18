package com.sistema.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import com.sistema.inventario.DAO.ProductoDAO;
import com.sistema.inventario.entidades.Producto;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDAO pDAO;

	@Override
	public Producto crearProducto(Producto producto) {

		producto = pDAO.save(producto);

		return producto;
	}

	@Override
	public List<Producto> obtenerTodosLosProductos() {
		List<Producto> productos = pDAO.findAll();

		return productos;
	}

	@Override
	public Producto findById(long id) {

		Producto producto = pDAO.findById(id).orElseThrow(null);

		return producto;
	}

	@Override
	public Producto eliminarProducto(long id) {
		Producto producto = pDAO.findById(id).orElseThrow(null);

		pDAO.delete(producto);

		return producto;
	}

	@Override
	public Producto actualizarProducto(Producto producto, long id) {
		
		Producto nvoProducto = pDAO.findById(id).orElseThrow(null);
		
		nvoProducto.setNombre(producto.getNombre());
		nvoProducto.setPrecio(producto.getPrecio());
		nvoProducto.setCategoria(producto.getCategoria());
		
		pDAO.save(nvoProducto);
		
		return nvoProducto;
	}

}
