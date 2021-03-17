package com.Stripe.Weister2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.Stripe.Weister2.domain.*;


public interface AboutUs_Service {
	
	public List<About_us> findAll() throws DataAccessException;
	
	public void insertAndUpdate(About_us c) throws DataAccessException;
	
	public void delete(About_us c) throws DataAccessException;
	
	

}
