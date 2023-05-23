package com.sistema.inventario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.DAO.UsuarioDAO;
import com.sistema.inventario.entidades.Rol;
import com.sistema.inventario.entidades.Usuario;
import com.sistema.inventario.service.UsuarioService;

@DataJpaTest // para que pueda ejecutar pruebas con una entidad
@AutoConfigureTestDatabase(replace = Replace.NONE) //sirve para interactuar con la bd real
@Rollback(false)
public class UsuarioDAOTest {

	@Autowired
	private UsuarioDAO userDAO;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCrearRoles() {
		
		Rol rolAdmin = new Rol("ADMINISTRADOR");
		Rol rolEditor = new Rol("EDITOR");
		Rol rolVisitante = new Rol("VISITANTE");
		
		//guardo en la bd estos roles
		entityManager.persist(rolAdmin);
		entityManager.persist(rolEditor);
		entityManager.persist(rolVisitante);
		
	}
	
	@Test
	public void testCrearNuevoUsuarioConUnRol() {
		
		Rol rolAdmin = entityManager.find(Rol.class, 1);
		
		Usuario user1 = new Usuario("pepe123", "pruebatest@prueba.com");
	
		user1.agregarRol(rolAdmin);
		
		userDAO.save(user1);
	}
	
	@Test
	public void testCrearNuevoUsuarioConDosRol() {
		
		Rol rolAdmin = entityManager.find(Rol.class, 1);
		Rol rolEditor = entityManager.find(Rol.class, 2);
		
		Usuario user2 = new Usuario("raul23", "test@prueba.com");
	
		user2.agregarRol(rolAdmin);
		user2.agregarRol(rolEditor);
		
		userDAO.save(user2);
	}
	
	@Test
	public void testEditarUsuarioAgregandoRol() {
		
		Rol rolVisitante = entityManager.find(Rol.class, 3);
		Usuario user3 = entityManager.find(Usuario.class, 1);
		
		user3.agregarRol(rolVisitante);

		
		userDAO.save(user3);
	}
	
	@Test
	public void testEliminarRolAUnUsuarioYaExistente() {
		
		Rol rolVisitante = entityManager.find(Rol.class, 3);
		Usuario user3 = entityManager.find(Usuario.class, 1);
		
		user3.eliminarRol(rolVisitante);

		
		userDAO.save(user3);
	}
	
	
	@Test
	public void testCrearNuevoUsuarioConUnNuevoRol() {
		
		Rol rolManager = new Rol("MANAGER");	
		Usuario user = new Usuario("pepe123rt", "test@test.com");
	
		user.agregarRol(rolManager);
		userDAO.save(user);
	}
	
	
	@Test
	public void testObtenerUsuario() {
		Usuario user4 = entityManager.find(Usuario.class, 2);
		entityManager.detach(user4);
		
		System.out.println(user4.getEmail());
		System.out.println(user4.getRoles());
	}
	
	@Test
	public void testEliminarUsuario() {
		Usuario user5 = entityManager.find(Usuario.class, 3);
		
		userDAO.deleteById(user5.getId());
		
	}
}
