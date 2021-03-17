package com.Stripe.Weister2.service.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.Stripe.Weister2.domain.*;
import com.Stripe.Weister2.repositorie.*;
import com.Stripe.Weister2.service.*;

@Service
public class CarritoServiceImpl implements CarritoService{

	
	@Autowired
	CarritoRepo Repo;
	
	@PersistenceContext(unitName = "Weister2")
	EntityManager entityManager;
	
	@Override
	public List<Carrito> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(Carrito c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}

	@Override
	public void delete(Carrito c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
