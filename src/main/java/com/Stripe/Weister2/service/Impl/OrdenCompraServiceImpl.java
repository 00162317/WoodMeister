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
public class OrdenCompraServiceImpl implements OrdenCompraService{

	@Autowired
	OrdenCompraRepo Repo;
	
	@PersistenceContext(unitName = "Weister2")
	EntityManager entityManager;
	
	@Override
	public List<OrdenCompra> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(OrdenCompra c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}


	@Override
	public void delete(OrdenCompra c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer totalDinero() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.totalMoney();
	}

	@Override
	public List<OrdenCompra> findPersonOrders(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.findList(code);
	}

}
