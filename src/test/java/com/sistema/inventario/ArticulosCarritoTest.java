package com.sistema.inventario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.DAO.ArticulosCarritoDAO;
import com.sistema.inventario.entidades.ArticuloCarrito;
import com.sistema.inventario.entidades.Producto;
import com.sistema.inventario.entidades.Usuario;

@DataJpaTest // para que pueda ejecutar pruebas con una entidad
@AutoConfigureTestDatabase(replace = Replace.NONE) //sirve para interactuar con la bd real
@Rollback(false)
public class ArticulosCarritoTest {

	@Autowired
	private ArticulosCarritoDAO artDAO;
	
	@Autowired
	private TestEntityManager entityManager;
	
	
	@Test
	public void testAñadirArticulo() {
		
		Producto producto = entityManager.find(Producto.class, 2);
		Usuario user1 = entityManager.find(Usuario.class, 2);
		
		ArticuloCarrito articulo = new ArticuloCarrito(7, producto, user1);
		artDAO.save(articulo);
		
	}
	
	@Test
	public void testAñadirMultiplesArticulo() {
		
		Usuario user2 = entityManager.find(Usuario.class, 1);
		Producto producto1 = entityManager.find(Producto.class, 1);
		Producto producto2 = entityManager.find(Producto.class, 2);
		Producto producto3 = entityManager.find(Producto.class, 3);
		
		ArticuloCarrito articulo = new ArticuloCarrito(7, producto1, user2);
		artDAO.save(articulo);
		
	}
}
