package com.Stripe.Weister2.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(schema = "public", name = "orden_compra")
public class OrdenCompra {

	
	@Id
	@Column(name = "id_orden_compra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_orden_compra;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "total_money")
	private Integer total_money;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkCliente")
	private Usuario usuario;
	
	@Transient
	private Integer fkCliente;
	
	@OneToOne(cascade=CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	@JoinColumn(name="fkCarrito")
	private Carrito carrito;
	
	@Transient
	private Integer fkCarrito;
	
	public OrdenCompra() {
		
	}

	public Integer getId_orden_compra() {
		return id_orden_compra;
	}

	public void setId_orden_compra(Integer id_orden_compra) {
		this.id_orden_compra = id_orden_compra;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getTotal_money() {
		return total_money;
	}

	public void setTotal_money(Integer total_money) {
		this.total_money = total_money;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(Integer fkCliente) {
		this.fkCliente = fkCliente;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Integer getFkCarrito() {
		return fkCarrito;
	}

	public void setFkCarrito(Integer fkCarrito) {
		this.fkCarrito = fkCarrito;
	}
	
	
	
}
