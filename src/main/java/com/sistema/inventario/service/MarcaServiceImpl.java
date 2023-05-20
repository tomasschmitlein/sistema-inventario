package com.sistema.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.inventario.DAO.CategoriaDAO;
import com.sistema.inventario.DAO.MarcaDAO;
import com.sistema.inventario.entidades.Marca;

@Service
@Transactional
public class MarcaServiceImpl implements MarcaService{

	
	@Autowired
	private MarcaDAO marcaDAO;
	
	@Autowired
	private CategoriaDAO catDAO;
	
	@Override
	public Marca crearMarca(Marca marca) {
		
		marca = marcaDAO.save(marca);
		
		return marca;
	}

	@Override
	public List<Marca> obtenerTodosLasMarcas() {
		
		List<Marca> marcas = marcaDAO.findAll();
		
		
		return marcas;
	}

	@Override
	public Marca findById(long id) {
		
		Marca marca = marcaDAO.findById(id).orElseThrow(null);
		
		
		return marca;
	}

	@Override
	public Marca eliminarMarca(long id) {
		
		Marca marca = marcaDAO.findById(id).orElseThrow(null);
		
		marcaDAO.delete(marca);
		
		return marca;
	}

	@Override
	public Marca actualizarMarca(Marca marca, long id) {
		
		Marca marca2 = marcaDAO.findById(id).orElseThrow(null);
		
		marca2.setNombre(marca.getNombre());
		marca2.setCategorias(marca.getCategorias());
		
		marcaDAO.save(marca2);
		
		return marca2;
	}

}
