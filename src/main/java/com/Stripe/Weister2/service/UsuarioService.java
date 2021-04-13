package com.Stripe.Weister2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;

import com.Stripe.Weister2.domain.*;

public interface UsuarioService {
	
	public List<Usuario> findAll() throws DataAccessException;
	
	public void insertAndUpdate(Usuario c) throws DataAccessException;
	
	
	public void delete(Usuario c) throws DataAccessException;
	public Optional<Usuario> findByNombre(String username) throws DataAccessException;
	public Optional<Usuario> findByEmail(String email) throws DataAccessException;
}
