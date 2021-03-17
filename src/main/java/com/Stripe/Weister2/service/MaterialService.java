package com.Stripe.Weister2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Stripe.Weister2.domain.*;

public interface MaterialService {

	public List<Material> findAll() throws DataAccessException;
	
	public void insertAndUpdate(Material c) throws DataAccessException;
	
	public void delete(Material c) throws DataAccessException;
	
	public Page <Material> mostrarMateriales(String search, Pageable page) throws DataAccessException;
	
	public Integer countMaterial(String string) throws DataAccessException;
	
	public Material findOnde(Integer code) throws DataAccessException;
}
