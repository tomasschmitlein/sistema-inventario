package com.sistema.inventario.entidades;

import java.util.*;

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

	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<ProductoDetalles> detalles = new ArrayList<>();

	public void guardarDetalles(String nombre, String valor) {

		this.detalles.add(new ProductoDetalles(nombre, valor, this));

	}
	
	

	public Producto(Long id, String nombre, Float precio, Categoria categoria, List<ProductoDetalles> detalles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.detalles = detalles;
	}



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

	public List<ProductoDetalles> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<ProductoDetalles> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

	public void setDetalle(Integer id, String nombre, String valor) {
		this.detalles.add(new ProductoDetalles(Long.valueOf(id.longValue()), nombre, valor, this));
		
	}

}
