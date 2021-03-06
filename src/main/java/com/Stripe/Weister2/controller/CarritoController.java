package com.Stripe.Weister2.controller;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SessionAttributeMethodArgumentResolver;

import com.Stripe.Weister2.Utils.Utils;
import com.Stripe.Weister2.domain.Carrito;
import com.Stripe.Weister2.domain.ChargeRequest;
import com.Stripe.Weister2.domain.Producto;
import com.Stripe.Weister2.domain.Usuario;
import com.Stripe.Weister2.domain.ChargeRequest.Currency;
import com.Stripe.Weister2.domain.OrdenCompra;
import com.Stripe.Weister2.dto.sliderDTO;
import com.Stripe.Weister2.service.*;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;



@Controller
@Service
public class CarritoController {
	
	@Autowired
	ProductoService ProductoService;
	
	@Autowired
	OrdenCompraService OrdenCompraService;
	
	@Autowired
    private StripeService paymentsService;
	
	@Autowired
	private UsuarioService UsuarioService;
	
	@Autowired
	private CarritoService CarritoService;
	
	
	@Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;
	
	
	//---------------------------------------------------------------------------------------------
	
		@RequestMapping("/carrito")
		public ModelAndView carrito() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("carritoRegistro");
			return mav;
		}

	
		/*a;adir al carrito sin necesidad de tener sesion*/
		@RequestMapping("/Shop")
		public String addcarrito2(@RequestParam Integer id, @RequestParam Integer material, HttpServletRequest request) {
			String eleccion;
			if(material == 1) {
				eleccion = "Madera";
				System.out.print(eleccion);
			}
			else {
				eleccion = "Metal";
				System.out.print("///////////////////////////////////");
				System.out.print("Metal");
			}
			
			List<sliderDTO> p2 = Utils.getCartInSession2(request);
			List<sliderDTO> slider = null;
			List<sliderDTO> slider2 = new ArrayList<>();
			sliderDTO slide = new sliderDTO();
			
			try {
				slider = ProductoService.dtoPrueba2(id);
				//para setearle el dato que me falta
				slider.get(0).setMaterial(eleccion);
				slider.get(0).setIdcarrito(material);
				p2.add(slider.get(0));
				
			
			} catch (Exception e) {
				// TODO: handle exception
			}
			request.getSession().setAttribute("myCart", p2);
		
			
			return "redirect:/ShowCarrito";
			
		}
		@RequestMapping("/eliminarDelCarrito")
		public String eliminarDeCarrito(@RequestParam Integer id, @RequestParam Integer material,HttpServletRequest request) {
			List<sliderDTO> p2 = Utils.getCartInSession2(request);
			List<sliderDTO> p3 = new ArrayList<>();	

			System.out.print(material);
			
			p3 = Utils.EliminarDelCarrito3(p2, id,material);
			
			request.getSession().setAttribute("myCart", p3);
		
			
			return "redirect:/ShowCarrito";
		}
		@RequestMapping("/eliminarCarrito")
		public String eliminarCarrito(HttpServletRequest request) {
			Utils.removeCartInSession(request);
			return "redirect:/ShowCarrito";
		}
		
		@RequestMapping("/ShowCarrito")
		public ModelAndView showCarrito2(HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			
			List<sliderDTO> p2 = Utils.getCartInSession2(request);
		
			request.getSession().setAttribute("myCart", p2);
			Integer pro = Utils.calcularTotal(p2);
						
			//Stripe
			mav.addObject("amount", pro);
			mav.addObject("stripePublicKey", stripePublicKey);
			mav.addObject("currency", ChargeRequest.Currency.USD);
		
			//mav.setViewName("checkout");
			
			mav.addObject("pro", pro);
			mav.addObject("producto",p2);
			mav.setViewName("carritoRegistro");
			
			return mav;
		}
		

	
		@RequestMapping("/carritoIdentificar")
		public ModelAndView carritoIdentificar() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("carritoIdentificar");
			return mav;
		}
		
		@RequestMapping("/carritoPago")
		public ModelAndView carritoPago() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("carritoPago");
			return mav;
		}
		
		@RequestMapping("/usu")
		public ModelAndView usu(Authentication auth) {
			ModelAndView mav = new ModelAndView();
			String name =auth.getName();
			
			if(name != null) {
				mav.addObject("name",name);
				
			}else {
				String cor = "queso";
				mav.addObject("name",cor);
			}
			
			mav.setViewName("welcome");
			return mav;
		}
		@RequestMapping("/tracking")
		public ModelAndView tracking(Authentication auth) {
			ModelAndView mav = new ModelAndView();
			List<OrdenCompra> ordenes = null;
			String name =auth.getName();
			 Usuario usuario = UsuarioService.findByNombre(name);
	
			if(name != null) {
				mav.addObject("name",name);
				
			}else {
				String cor = "queso";
				mav.addObject("name",cor);
			}
			
			try {
				ordenes = OrdenCompraService.findPersonOrders(usuario.getId_usuario());
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			mav.addObject("ordenes",ordenes);
			mav.setViewName("tracking");
			return mav;
		}
		@RequestMapping("/orderDetails")
		public ModelAndView orderDetails(@RequestParam Integer id, Authentication auth) {
			ModelAndView mav = new ModelAndView();
			List<OrdenCompra> ordenes = null;
			String name =auth.getName();
			 Usuario usuario = UsuarioService.findByNombre(name);
			 OrdenCompra or = OrdenCompraService.obtenerCorrelativo(id);
			 String correlativo = or.getCorrelativo();
			 List<Carrito> car = null;
			if(name != null) {
				mav.addObject("name",name);
				
			}else {
				String cor = "queso";
				mav.addObject("name",cor);
			}
			
			try {
				ordenes = OrdenCompraService.findPersonOrders(usuario.getId_usuario());
				car = CarritoService.unCorr(correlativo);
			}catch (Exception e) {
				// TODO: handle exception
			}
			mav.addObject("ordenes",car);
			mav.setViewName("tracking2");
			return mav;
		}


}
