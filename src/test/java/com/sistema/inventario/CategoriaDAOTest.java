package com.sistema.inventario;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.DAO.CategoriaDAO;
import com.sistema.inventario.entidades.Categoria;

@DataJpaTest // para que pueda ejecutar pruebas con una entidad
@AutoConfigureTestDatabase(replace = Replace.NONE) //sirve para interactuar con la bd real
@Rollback(false)
public class CategoriaDAOTest {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	
	@Test
	public void testCrearCategoria() {
		
		Categoria catGuardada = categoriaDAO.save(new Categoria("Electronicos"));
		
		assertThat(catGuardada.getId()).isGreaterThan(0);
	}
	
}
