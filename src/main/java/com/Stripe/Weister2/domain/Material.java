package com.Stripe.Weister2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="material")
public class Material {
	
	@Id
	@Column(name = "id_material")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_material;
	
	@Column(name="nombre_material")
	private String nombre_material;
	
	public Material() {
		
	}

	public Integer getId_material() {
		return id_material;
	}

	public void setId_material(Integer id_material) {
		this.id_material = id_material;
	}

	public String getNombre_material() {
		return nombre_material;
	}

	public void setNombre_material(String nombre_material) {
		this.nombre_material = nombre_material;
	}
	
	
	
}
