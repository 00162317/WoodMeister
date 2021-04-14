package com.Stripe.Weister2.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Stripe.Weister2.domain.*;
import com.Stripe.Weister2.dto.sliderDTO;
import com.Stripe.Weister2.repositorie.*;
import com.Stripe.Weister2.service.*;

@Service
public class ProductoServiceImpl implements ProductoService {

	int aux = 0;
	@Autowired
	ProductoRepo Repo;

	@PersistenceContext(unitName = "Weister2")
	EntityManager entityManager;

	@Override
	public List<Producto> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(Producto c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}

	@Override
	public void delete(	Integer c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.deleteById(c);
	}

	@Override
	public List<sliderDTO> dtoPrueba() throws DataAccessException {
		// TODO Auto-generated method stub p.id_producto, p.nombre, p.descripcion,
		// p.precio, i.nombre
		List<sliderDTO> slider = Repo.sliderProducto().stream().map(obj -> {
			sliderDTO e = new sliderDTO();

			e.setId_producto(Integer.valueOf(obj[0].toString()));
			e.setNombre(obj[1].toString());
			e.setDescripcion(obj[2].toString());
			e.setPrecio(Integer.valueOf(obj[3].toString()));
			e.setNombreImagen(obj[4].toString());
			aux = Integer.valueOf(obj[0].toString());
			return e;
		}).collect(Collectors.toList());
		aux = 0;
		System.out.print(slider.toString());
		return slider;
	}

	@Override
	public Page<Producto> mostrarProductosNew(String search, Pageable page) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarProductos(search, page);
	}

	@Override
	public Integer countProducto2(String string) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.countProduct2(string);
	}

	@Override
	public Producto findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(code);
	}

	@Override
	public List<sliderDTO> dtoPrueba2(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		List<sliderDTO> slider = Repo.sliderProducto2(code).stream().map(obj -> {
			sliderDTO e = new sliderDTO();

			e.setId_producto(Integer.valueOf(obj[0].toString()));
			e.setNombre(obj[1].toString());
			e.setDescripcion(obj[2].toString());
			e.setPrecio(Integer.valueOf(obj[3].toString()));
			e.setNombreImagen(obj[4].toString());
			aux = Integer.valueOf(obj[0].toString());
			return e;
		}).collect(Collectors.toList());
		aux = 0;
		System.out.print(slider.toString());
		return slider;
	}

}
