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
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema = "public", name = "usuario")
public class Usuario {
	
	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	
	@Column(name = "nombre")
	@NotEmpty(message="No puede ir vacio")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "email")
	@NotEmpty(message="No puede ir vacio")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "rol")
	private String rol;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkSexo")
	private Sexo sexo;
	
	@Transient
	private Integer fkSexo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkTipo_usuario")
	private TipoUsuario tipo_usuario;
	
	@Transient
	private Integer fkTipo_usuario;
	
	public Usuario() {
		
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Integer getFkSexo() {
		return fkSexo;
	}

	public void setFkSexo(Integer fkSexo) {
		this.fkSexo = fkSexo;
	}

	public TipoUsuario getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(TipoUsuario tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public Integer getFkTipo_usuario() {
		return fkTipo_usuario;
	}

	public void setFkTipo_usuario(Integer fkTipo_usuario) {
		this.fkTipo_usuario = fkTipo_usuario;
	}
	
	
}
