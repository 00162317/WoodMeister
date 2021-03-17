package com.Stripe.Weister2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.Stripe.Weister2.domain.*;

public interface TipoUsuarioService {
	
	public List<TipoUsuario> findAll() throws DataAccessException;
	
	public void insertAndUpdate(TipoUsuario c) throws DataAccessException;
	
	public void delete(TipoUsuario c) throws DataAccessException;
}
