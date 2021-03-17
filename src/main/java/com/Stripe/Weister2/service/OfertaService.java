package com.Stripe.Weister2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.Stripe.Weister2.domain.*;

public interface OfertaService {
	
	public List<Oferta> findAll() throws DataAccessException;
	
	public void insertAndUpdate(Oferta c) throws DataAccessException;
	
	public void delete(Oferta c) throws DataAccessException;
}
