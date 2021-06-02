package com.Stripe.Weister2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.Stripe.Weister2.domain.*;

public interface CarritoService {
	
	public List<Carrito> findAll() throws DataAccessException;
	
	public void insertAndUpdate(Carrito c) throws DataAccessException;
	
	
	public void delete(Carrito c) throws DataAccessException;
	
	public List<Carrito> unCorr(String code)throws DataAccessException;
}
