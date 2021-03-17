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
}
