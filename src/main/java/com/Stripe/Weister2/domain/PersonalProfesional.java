package com.Stripe.Weister2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "personal_profesional")
public class PersonalProfesional {

	@Id
	@Column(name = "id_personal_pro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_personal_pro;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "nombre_imagen")
	private String nombre_imagen;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public PersonalProfesional() {
		
	}

	public Integer getId_personal_pro() {
		return id_personal_pro;
	}

	public void setId_personal_pro(Integer id_personal_pro) {
		this.id_personal_pro = id_personal_pro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNombre_imagen() {
		return nombre_imagen;
	}

	public void setNombre_imagen(String nombre_imagen) {
		this.nombre_imagen = nombre_imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
