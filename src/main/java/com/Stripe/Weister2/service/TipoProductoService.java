package com.Stripe.Weister2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Stripe.Weister2.domain.*;

public interface TipoProductoService {

	public List<TipoProducto> findAll() throws DataAccessException;
	
	public void insertAndUpdate(TipoProducto c) throws DataAccessException;
	
	
	public void delete(TipoProducto c) throws DataAccessException;
	
	public Page<TipoProducto> mostrarTipoProducto(String search, Pageable page) throws DataAccessException;
	
	public Integer countTproducto(String search) throws DataAccessException;
	
	public TipoProducto findOne(Integer code) throws DataAccessException;
}
