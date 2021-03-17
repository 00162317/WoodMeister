package com.Stripe.Weister2.domain;

import java.sql.Date;

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
@Table(schema = "public", name = "oferta")
public class Oferta {

	@Id
	@Column(name = "id_oferta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_oferta;
	
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;
	
	@Column(name = "fecha_fin")
	private Date fecha_fin;
	
	@Column(name = "descuento")
	private Integer descuento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkProducto")
	private Producto producto;
	
	@Transient
	private Integer fkProducto;
	
	public Oferta() {
		
	}

	public Integer getId_oferta() {
		return id_oferta;
	}

	public void setId_oferta(Integer id_oferta) {
		this.id_oferta = id_oferta;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
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
	
	
}
