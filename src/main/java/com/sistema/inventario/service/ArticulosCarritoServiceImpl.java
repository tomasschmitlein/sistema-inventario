package com.sistema.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.inventario.DAO.ArticulosCarritoDAO;
import com.sistema.inventario.entidades.ArticuloCarrito;

@Service
public class ArticulosCarritoServiceImpl implements ArticulosCarritoService{

	@Autowired
	private ArticulosCarritoDAO artDAO;
	
	@Override
	public ArticuloCarrito crearArticuloCarrito(ArticuloCarrito articulo) {
		
		return artDAO.save(articulo);
	}

	@Override
	public List<ArticuloCarrito> obtenerTodosLosArticuloCarrito() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticuloCarrito findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticuloCarrito eliminarArticuloCarrito(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticuloCarrito actualizarArticuloCarrito(ArticuloCarrito articulo, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
