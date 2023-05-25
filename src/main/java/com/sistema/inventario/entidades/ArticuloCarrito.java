package com.sistema.inventario.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "articulo_id")
public class ArticuloCarrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private int cantidad;
	
	@ManyToOne // muchos productos pueden ser agregados a este carrito
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	@ManyToOne // un usuario puede agregar muchos articulosCarrito
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public ArticuloCarrito() {
		super();
	}

	public ArticuloCarrito(int cantidad, Producto producto, Usuario usuario) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.usuario = usuario;
	}

	public ArticuloCarrito(Integer id, int cantidad, Producto producto, Usuario usuario) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.producto = producto;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "ArticuloCarrito [id=" + id + ", cantidad=" + cantidad + ", producto=" + producto + ", usuario="
				+ usuario + "]";
	}
}
