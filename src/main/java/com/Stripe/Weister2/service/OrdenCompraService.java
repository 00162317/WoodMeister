package com.Stripe.Weister2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.Stripe.Weister2.domain.*;

public interface OrdenCompraService {
	
	public List<OrdenCompra> findAll() throws DataAccessException;
	
	public void insertAndUpdate(OrdenCompra c) throws DataAccessException;
	
	public Integer totalDinero() throws DataAccessException;
	
	public void delete(OrdenCompra c) throws DataAccessException;
	
	public List<OrdenCompra> findPersonOrders(Integer code)throws DataAccessException;
	
	public OrdenCompra obtenerCorrelativo(Integer code)throws DataAccessException;
}
