package com.Stripe.Weister2.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Stripe.Weister2.domain.*;

public interface PersonalProRepo extends JpaRepository<PersonalProfesional, Integer>{
	
	@Query(nativeQuery = true,value="select * from public.personal_profesional")
	public List<PersonalProfesional> mostrarTodo() throws DataAccessException;

}
