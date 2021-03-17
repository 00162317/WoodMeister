package com.Stripe.Weister2.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "tipo_usuario")
public class TipoUsuario {

	@Id
	@Column(name = "id_tipo_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo_usuario;
	
	@Column(name = "nombre")
	private String nombre;
	
	public TipoUsuario() {
		
	}

	public Integer getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	public void setId_tipo_usuario(Integer id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
