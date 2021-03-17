package com.Stripe.Weister2.service.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Stripe.Weister2.domain.*;
import com.Stripe.Weister2.repositorie.*;
import com.Stripe.Weister2.service.*;

@Service
public class TipoProductoServiceImpl implements TipoProductoService{

	@Autowired
	TipoProductoRepo Repo;
	
	@PersistenceContext(unitName = "Weister2")
	EntityManager entityManager;
	
	@Override
	public List<TipoProducto> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(TipoProducto c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}

	@Override
	public void delete(TipoProducto c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<TipoProducto> mostrarTipoProducto(String search, Pageable page) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTProducto(search, page);
	}

	@Override
	public Integer countTproducto(String search) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.countTproducto(search);
	}

	@Override
	public TipoProducto findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(code);
	}

}
