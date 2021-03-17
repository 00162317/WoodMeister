package com.Stripe.Weister2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "about_us")
public class About_us {

	@Id
	@Column(name = "id_about_us")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_about_us;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public About_us() {
		
	}

	public Integer getId_about_us() {
		return id_about_us;
	}

	public void setId_about_us(Integer id_about_us) {
		this.id_about_us = id_about_us;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
