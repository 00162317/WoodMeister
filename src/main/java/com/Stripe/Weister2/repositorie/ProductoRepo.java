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
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public interface ProductoRepo extends JpaRepository<Producto, Integer> {
	
	@Query(nativeQuery = true,value="select * from public.producto")
	public List<Producto> mostrarTodo() throws DataAccessException;
	
	@Query(nativeQuery = true, 
			value = " select p.id_producto, p.nombre, p.descripcion, p.precio, i.nombre as foto "
					+ " from public.producto p, public.imagen i where p.id_producto = i.fkproducto  "
					+ " order by p.id_producto asc ")
	public List<Object[]> sliderProducto() throws DataAccessException;
	
	
	@Query(nativeQuery = true, value = "select * from public.producto")
	public Page<Producto> mostrarProductos(String search, Pageable page) throws DataAccessException;
	
	@Query(nativeQuery=true,value="select count(pro.id_producto) "
			+ "from public.producto pro, public.material ma, public.tipo_producto tp "
			+ "where tp.id_tipo_producto=pro.fkTipoProducto and ma.id_material = pro.fkMaterial")
	public Integer countProduct2(String code) throws DataAccessException;
	

	
}
