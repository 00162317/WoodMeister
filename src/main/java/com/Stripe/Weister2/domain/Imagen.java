package com.Stripe.Weister2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(schema = "public", name = "imagen")
public class Imagen {
	
	@Id
	@Column(name = "id_imagen")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_imagen;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkProducto")
	private Producto producto;
	
	@Transient
	private Integer fkProducto;
	
	public Imagen() {
		
	}

	public Integer getId_imagen() {
		return id_imagen;
	}

	public void setId_imagen(Integer id_imagen) {
		this.id_imagen = id_imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getFkProducto() {
		return fkProducto;
	}

	public void setFkProducto(Integer fkProducto) {
		this.fkProducto = fkProducto;
	}
	
	
}
