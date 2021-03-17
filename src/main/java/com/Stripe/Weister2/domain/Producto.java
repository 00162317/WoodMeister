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
@Table(schema = "public", name = "producto")
public class Producto {

	@Id
	@Column(name = "id_producto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_producto;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "detalles")
	private String detalles;
	
	@Column(name = "precio")
	private Integer precio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkMaterial")
	private Material material;
	
	@Transient
	private Integer fkMaterial;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fkTipoProducto")
	private TipoProducto tipo_producto;
	
	@Transient
	private Integer fkTipoProducto;
	
	
	public Producto() {
		
	}


	public Integer getId_producto() {
		return id_producto;
	}


	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
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


	public String getDetalles() {
		return detalles;
	}


	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}


	public Integer getPrecio() {
		return precio;
	}


	public void setPrecio(Integer precio) {
		this.precio = precio;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}


	public Integer getFkMaterial() {
		return fkMaterial;
	}


	public void setFkMaterial(Integer fkMaterial) {
		this.fkMaterial = fkMaterial;
	}


	public TipoProducto getTipo_producto() {
		return tipo_producto;
	}


	public void setTipo_producto(TipoProducto tipo_producto) {
		this.tipo_producto = tipo_producto;
	}


	public Integer getFkTipoProducto() {
		return fkTipoProducto;
	}


	public void setFkTipoProducto(Integer fkTipoProducto) {
		this.fkTipoProducto = fkTipoProducto;
	}
	
	
}
