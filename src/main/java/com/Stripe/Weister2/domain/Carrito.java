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
@Table(schema = "public", name = "carrito")
public class Carrito {
	
	@Id
	@Column(name = "id_carrito")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_carrito;
	
	@Column(name = "correlativo")
	private String correlativo;
	
	@Column(name = "valor_money")
	private Integer valor_money;
	
	@Column(name = "material")
	private String material;
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkProducto")
	private Producto producto;
	
	@Transient
	private Integer fkProducto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkUsuario")
	private Usuario usuario;
	
	@Transient
	private Integer fkUsuario;
	
	
	public Carrito() {
		
	}

	public Integer getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(Integer id_carrito) {
		this.id_carrito = id_carrito;
	}

	

	public String getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(String correlativo) {
		this.correlativo = correlativo;
	}

	public Integer getValor_money() {
		return valor_money;
	}

	public void setValor_money(Integer valor_money) {
		this.valor_money = valor_money;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(Integer fkUsuario) {
		this.fkUsuario = fkUsuario;
	}
	
	
}
