package com.sistema.inventario.entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

//JoinTable = unir tablas 
@Entity
public class Usuario {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 25, nullable = false, unique = false)
	private String password;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@ManyToMany//(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	//le paso el nombre de la tabla "usuario_rol" que va a estar unida a esta entidad por la columna "usuario_id", y con inversejoin hacemos referencia que la tabla "usuario_rol" va a estar unida a la tabla "rol" por la columna rol_id
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<>();
	
	public Usuario() {
		super();
	}
	
	

	public Usuario(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}



	public Usuario(String password, String email, Set<Rol> roles) {
		super();
		this.password = password;
		this.email = email;
		this.roles = roles;
	}

	public Usuario(Long id, String password, String email, Set<Rol> roles) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}

	public void agregarRol(Rol rol) {
		this.roles.add(rol);
	}
	
	public void eliminarRol(Rol rol) {
		this.roles.remove(rol);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", password=" + password + ", email=" + email + ", roles=" + roles + "]";
	}
	
	
}
