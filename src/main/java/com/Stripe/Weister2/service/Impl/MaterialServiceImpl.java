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
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialRepo Repo;
	
	@PersistenceContext(unitName = "Weister2")
	EntityManager entityManager;
	
	@Override
	public List<Material> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(Material c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}


	@Override
	public void delete(Material c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Material> mostrarMateriales(String search, Pageable page) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarMateriales(search, page);
	}

	@Override
	public Integer countMaterial(String string) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.countMaterial(string);
	}

	@Override
	public Material findOnde(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(code);
	}

}
