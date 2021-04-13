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
import com.Stripe.Weister2.domain.ChargeRequest;
import com.Stripe.Weister2.domain.Producto;
import com.Stripe.Weister2.domain.ChargeRequest.Currency;
import com.Stripe.Weister2.service.*;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;



@Controller
@Service
public class CarritoController {
	
	@Autowired
	ProductoService ProductoService;
	
	@Autowired
    private StripeService paymentsService;
	
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
		public String addcarrito(@RequestParam Integer id, HttpServletRequest request) {
			List<Producto> p2 = Utils.getCartInSession(request);
			Producto producto = new Producto();
			producto = ProductoService.findOne(id);
			p2.add(producto);
			request.getSession().setAttribute("myCart", p2);
		
			
			return "redirect:/ShowCarrito";
		}
		
		@RequestMapping("/ShowCarrito")
		public ModelAndView showCarrito(HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			List<Producto> p2 = Utils.getCartInSession(request);
		
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

	//---------------------------------------------------------------------------------------------


}
