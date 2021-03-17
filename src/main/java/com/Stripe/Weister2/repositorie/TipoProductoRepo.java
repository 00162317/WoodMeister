package com.Stripe.Weister2.repositorie;


import java.util.List;

import org.hibernate.exception.DataException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Stripe.Weister2.domain.*;

public interface TipoProductoRepo extends JpaRepository<TipoProducto, Integer> {

	@Query(nativeQuery = true,value="select * from public.tipo_producto")
	public List<TipoProducto> mostrarTodo() throws DataAccessException;
	
	@Query(nativeQuery = true, value="select * from public.tipo_producto")
	public Page<TipoProducto> mostrarTProducto(String search, Pageable page) throws DataAccessException; 
	
	@Query(nativeQuery = true, value="select count(tp.id_tipo_producto) from public.tipo_producto tp")
	public Integer countTproducto(String code) throws DataAccessException;
	
	@Query(nativeQuery = true, value="select * from public.tipo_producto where tipo_producto.id_tipo_producto=?1")
	public List<TipoProducto> findD(Integer id_tproducto) throws DataAccessException;
}
