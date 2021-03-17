package com.Stripe.Weister2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="tipo_producto")
public class TipoProducto {
	
	@Id
	@Column(name = "id_tipo_producto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo_producto;
	
	@Column(name = "nombre_tipo")
	private String nombre_tipo;
	
	
	public TipoProducto() {
		
	}
	
	public Integer getId_tipo_producto() {
		return id_tipo_producto;
	}
	public void setId_tipo_producto(Integer id_tipo_producto) {
		this.id_tipo_producto = id_tipo_producto;
	}
	public String getNombre_tipo() {
		return nombre_tipo;
	}
	public void setNombre_tipo(String nombre_tipo) {
		this.nombre_tipo = nombre_tipo;
	}
	
	
}
