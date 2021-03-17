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

public interface MaterialRepo extends JpaRepository<Material, Integer>{

	@Query(nativeQuery = true,value="select * from public.material")
	public List<Material> mostrarTodo() throws DataAccessException;
	
	@Query(nativeQuery=true, value="select * from public.material")
	public Page<Material> mostrarMateriales(String search,Pageable page) throws DataAccessException;
	
	@Query(nativeQuery=true,value="select count(ma.id_material) from public.material ma")
	public Integer countMaterial(String code) throws DataAccessException;
	
	@Query(nativeQuery = true,value="select * from public.material where material.id_material = ?1")
	public List<Material> findD(Integer idMaterial) throws DataAccessException;
}
