package com.Stripe.Weister2.dto;

import java.util.Date;

public class sliderDTO {
	
	Integer id_producto;
	String nombre;
	String descripcion;
	Integer precio;
	String nombreImagen;
	String material;
	Integer idcarrito;
	Integer idorden;
	Date fecha;
	Integer totalFinal;
	String correlativo;
	String balance;
	String Status;
	
	
	
	public Integer getIdcarrito() {
		return idcarrito;
	}
	public void setIdcarrito(Integer idcarrito) {
		this.idcarrito = idcarrito;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
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
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public String getNombreImagen() {
		return nombreImagen;
	}
	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}
	
	
}

