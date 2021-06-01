package com.Stripe.Weister2.controller;

import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Stripe.Weister2.Utils.Utils;
import com.Stripe.Weister2.domain.Material;
import com.Stripe.Weister2.domain.OrdenCompra;
import com.Stripe.Weister2.domain.Producto;
import com.Stripe.Weister2.domain.TipoProducto;
import com.Stripe.Weister2.dto.TablaDTO;
import com.Stripe.Weister2.dto.sliderDTO;
import com.Stripe.Weister2.service.*;



@Controller
public class AdminController {
	
	@Autowired
	private ProductoService ProductoService;

	@Autowired
	private MaterialService MaterialService;

	@Autowired
	private TipoProductoService TipoProductoService;
	
	@Autowired
	private OrdenCompraService OrdenCompraService;
	
	
	@Autowired
	private MainController maincontroller;

	
	
	@RequestMapping("/adminRegistro")
	public ModelAndView registro(@ModelAttribute OrdenCompra ordenCompra) {
		ModelAndView mav = new ModelAndView();
		
		List<OrdenCompra> listaOrdenCompra = null;
		
		try {
			listaOrdenCompra = OrdenCompraService.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Total dinero: "+OrdenCompraService.totalDinero());
		Integer totalDin = OrdenCompraService.totalDinero();
		mav.addObject("totalDin", totalDin);	
		mav.addObject("listaOrdenCompra",listaOrdenCompra);
		mav.setViewName("AdminRegistro");
		return mav;
	}
//--------------------------------------------------------------- Views Producto
	
	
	@RequestMapping("/adminAgregar")
	public ModelAndView agregar(@ModelAttribute Producto producto) {
		ModelAndView mav = new ModelAndView();

		List<Material> listaMaterial = null;
		List<TipoProducto> listaTproducto = null;

		try {

			listaMaterial = MaterialService.findAll();
			listaTproducto = TipoProductoService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("listaMaterial", listaMaterial);
		mav.addObject("listaTproducto", listaTproducto);
		mav.setViewName("AdminAddProducto");
		return mav;
	}

	@RequestMapping("/adminEliminar")
	public ModelAndView eliminar() {
		ModelAndView mav = new ModelAndView();
		

		
		List<Producto> productos = null;
		
		try {
			
			productos=ProductoService.findAll();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		mav.addObject("productos", productos);
		
		mav.setViewName("AdminEliminar");
		return mav;
	}

	@RequestMapping("/adminModificar")
	public ModelAndView modificar() {
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("AdminModificar");
		return mav;
	}
	
	//--------------------------------------------------------------- Views Material
	
	@RequestMapping("/adminMostrarMaterial")
	public ModelAndView mostrarMaterial() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("AdminMaterial");
		return mav;
	}
	
	@RequestMapping("/adminAgregarMaterial")
	public ModelAndView agregarMaterial(@ModelAttribute Material material) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("AdminAddMaterial");
		return mav;
	}
	
	//--------------------------------------------------------------- Views Tipo Producto
	
	@RequestMapping("/adminMostrarTproducto")
	public ModelAndView mostrarTproducto() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("AdminTProducto");
		return mav;
	}
	
	@RequestMapping("/adminAgregarTipoProducto")
	public ModelAndView agregarTipoProducto(@ModelAttribute TipoProducto tipoProducto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("AdminAddTproducto");
		return mav;
	}
	
	//--------------------------------------------------------------- CRUD PRODUCTO
	
	@RequestMapping("/adminIngresarProducto")
	public ModelAndView ingresarProducto(@ModelAttribute Producto producto) {

		ModelAndView mav = new ModelAndView();

		List<Material> listaMaterial = null;
		List<TipoProducto> listaTproducto = null;

		try {

			listaMaterial = MaterialService.findAll();
			listaTproducto = TipoProductoService.findAll();
			ProductoService.insertAndUpdate(producto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("listaMaterial", listaMaterial);
		mav.addObject("listaTproducto", listaTproducto);
		mav.addObject("producto", producto);
		mav.setViewName("AdminAddProducto");
		return mav;
	}
	
	@RequestMapping("/adminEditarProducto")
	public ModelAndView editar(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		List<Material> listaMaterial = null;
		List<TipoProducto> listaTproducto = null;
		try {

			listaMaterial = MaterialService.findAll();
			listaTproducto = TipoProductoService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Producto c = ProductoService.findOne(id);
		mav.addObject("producto", c);
		mav.addObject("listaMaterial", listaMaterial);
		mav.addObject("listaTproducto", listaTproducto);
		mav.setViewName("AdminAddProducto");
		return mav;

	}
	
	@RequestMapping("/adminEliminarProducto")
	public ModelAndView eliminar(@ModelAttribute Producto producto, @RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		
		try {
			
			ProductoService.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		mav.addObject("producto", producto);
		//mav.addObject("listaMaterial", listaMaterial);
		//mav.addObject("listaTproducto", listaTproducto);
		mav.setViewName("AdminEliminar");
		return mav;
	}

	//--------------------------------------------------------------- CRUD MATERIAL
	
	@RequestMapping("/adminIngresarMaterial")
	public ModelAndView ingresarMaterial(@ModelAttribute Material material) {

		ModelAndView mav = new ModelAndView();

		MaterialService.insertAndUpdate(material);

		mav.addObject("material", material);
		mav.setViewName("AdminAddMaterial");
		return mav;
	}
	
	@RequestMapping("/adminEditarMaterial")
	public ModelAndView editarMaterial(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
			
		Material c = MaterialService.findOnde(id);
		mav.addObject("material", c);
		
		mav.setViewName("AdminAddMaterial");
		return mav;

	}
	
	//--------------------------------------------------------------- CRUD TIPO PRODUCTO
	
	@RequestMapping("/adminIngresarTipoProducto")
	public ModelAndView ingresarTipoProducto(@ModelAttribute TipoProducto tipoProducto) {

		ModelAndView mav = new ModelAndView();

		try {

			TipoProductoService.insertAndUpdate(tipoProducto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("tipoProducto", tipoProducto);
		mav.setViewName("AdminAddTproducto");
		return mav;
	}
	
	@RequestMapping("/adminEditarTipoProducto")
	public ModelAndView editarTipoProducto(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
			
		TipoProducto c = TipoProductoService.findOne(id);
		TipoProductoService.insertAndUpdate(c);
		mav.addObject("tipoProducto", c);

		mav.setViewName("AdminAddTproducto");
		return mav;

	}
	
	//--------------------------------------------------------------- Pageable Producto
	
	@RequestMapping("/CargarProductos")
	public @ResponseBody TablaDTO cargar(@RequestParam Integer draw, @RequestParam Integer start,
			@RequestParam Integer length, @RequestParam(value="search[value]",required =false) String search) {
		
		
		Page<Producto> producto  = ProductoService.mostrarProductosNew(search.toLowerCase(),
				PageRequest.of(start/length, length, Sort.by(Direction.ASC,"id_producto")));
			
		List<String[]> data = new ArrayList<>();
		
		for(Producto u : producto) {
			data.add(new String[] {
				u.getId_producto().toString(), u.getNombre().toString(), u.getDetalles(),
				u.getPrecio().toString(),u.getMaterial().getNombre_material(), u.getTipo_producto().getNombre_tipo()
			});
		}
		
		TablaDTO dto = new TablaDTO();
		
		System.out.print("HOOOOOOOOOOYYYYYYY  "+data);
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(ProductoService.countProducto2(search.toLowerCase()).intValue());
		dto.setRecordsTotal(ProductoService.countProducto2(search.toLowerCase()).intValue());
	
		return dto;
	}

	//--------------------------------------------------------------- Pageable Material
	
	@RequestMapping("/adminCargarMaterial")
	public @ResponseBody TablaDTO cargarMaterial(@RequestParam Integer draw, @RequestParam Integer start,
			@RequestParam Integer length, @RequestParam(value="search[value]",required =false) String search) {
		
		
		Page<Material> material  = MaterialService.mostrarMateriales(search.toLowerCase(),
				PageRequest.of(start/length, length, Sort.by(Direction.ASC,"id_material")));
			
		List<String[]> data = new ArrayList<>();
		
		for(Material u : material) {
			data.add(new String[] {
				u.getId_material().toString(), u.getNombre_material()
			});
		}
		
		TablaDTO dto = new TablaDTO();
		
		System.out.print("HOOOOOOOOOOYYYYYYY  "+data);
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(ProductoService.countProducto2(search.toLowerCase()).intValue());
		dto.setRecordsTotal(ProductoService.countProducto2(search.toLowerCase()).intValue());
	
		return dto;
	}
	//--------------------------------------------------------------- Pageable Tipo Producto
	
	@RequestMapping("/adminCargarTipoProducto")
	public @ResponseBody TablaDTO cargarTipoProducto(@RequestParam Integer draw, @RequestParam Integer start,
			@RequestParam Integer length, @RequestParam(value="search[value]",required =false) String search) {
		
		
		Page<TipoProducto> tipo_producto  = TipoProductoService.mostrarTipoProducto(search.toLowerCase(),
				PageRequest.of(start/length, length, Sort.by(Direction.ASC,"id_tipo_producto")));
			
		List<String[]> data = new ArrayList<>();
		
		for(TipoProducto u : tipo_producto) {
			data.add(new String[] {
				u.getId_tipo_producto().toString(), u.getNombre_tipo()
			});
		}
		
		TablaDTO dto = new TablaDTO();
		
		System.out.print("HOOOOOOOOOOYYYYYYY  "+data);
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(ProductoService.countProducto2(search.toLowerCase()).intValue());
		dto.setRecordsTotal(ProductoService.countProducto2(search.toLowerCase()).intValue());
	
		return dto;
	}
}
