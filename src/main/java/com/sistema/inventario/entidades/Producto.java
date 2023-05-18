package com.sistema.inventario.entidades;

import jakarta.persistence.*;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 128, nullable = false, unique = true)
	private String nombre;

	@Column(length = 45, nullable = false, unique = false)
	private Float precio;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	
	
	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Producto(String nombre, Float precio, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Producto(Long id, String nombre, Float precio, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Producto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}
