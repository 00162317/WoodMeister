package com.Stripe.Weister2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "sexo")
public class Sexo {

	@Id
	@Column(name = "id_sexo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_sexo;
	
	@Column(name = "nombre")
	private String nombre;
	
	public Sexo() {
		
	}

	public Integer getId_sexo() {
		return id_sexo;
	}

	public void setId_sexo(Integer id_sexo) {
		this.id_sexo = id_sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
