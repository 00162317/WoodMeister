package com.Stripe.Weister2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.Stripe.Weister2.domain.*;

public interface PersonalProService {
	
	public List<PersonalProfesional> findAll() throws DataAccessException;
	
	public void insertAndUpdate(PersonalProfesional c) throws DataAccessException;
	
	
	public void delete(PersonalProfesional c) throws DataAccessException;

}
