package com.Stripe.Weister2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.Stripe.Weister2.domain.*;

public interface SexoService {

	public List<Sexo> findAll() throws DataAccessException;
	
	public void insertAndUpdate(Sexo c) throws DataAccessException;

	
	public void delete(Sexo c) throws DataAccessException;
}
