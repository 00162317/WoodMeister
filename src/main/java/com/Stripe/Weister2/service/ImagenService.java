package com.Stripe.Weister2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.Stripe.Weister2.domain.*;

public interface ImagenService {
	
	public List<Imagen> findAll() throws DataAccessException;
	
	public void insertAndUpdate(Imagen c) throws DataAccessException;
	
	public void delete(Imagen c) throws DataAccessException;
	
	List<Imagen> findImagenes(Integer img) throws DataAccessException; 

}
