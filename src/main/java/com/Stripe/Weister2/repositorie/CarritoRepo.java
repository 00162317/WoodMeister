package com.Stripe.Weister2.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Stripe.Weister2.domain.*;

public interface CarritoRepo extends JpaRepository<Carrito, Integer> {

	@Query(nativeQuery = true,value="select * from public.carrito")
	public List<Carrito> mostrarTodo() throws DataAccessException;
}
