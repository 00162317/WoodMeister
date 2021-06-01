package com.Stripe.Weister2.controller.Stripe;

import java.security.InvalidAlgorithmParameterException;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Stripe.Weister2.Utils.Utils;
import com.Stripe.Weister2.domain.ChargeRequest;
import com.Stripe.Weister2.domain.OrdenCompra;
import com.Stripe.Weister2.domain.Usuario;
import com.Stripe.Weister2.domain.ChargeRequest.Currency;
import com.Stripe.Weister2.service.OrdenCompraService;
import com.Stripe.Weister2.service.StripeService;
import com.Stripe.Weister2.service.UsuarioService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
public class StripeController {

	@Autowired
	private StripeService paymentsService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	OrdenCompraService OrdenCompraService;

	@RequestMapping("/charge")
	public ModelAndView charge2(HttpServletRequest request, ChargeRequest chargeRequest, Model model,Authentication auth) 
			throws StripeException, InvalidAlgorithmParameterException{
		
		ModelAndView mav = new ModelAndView();
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);
        String name =auth.getName();
        Usuario usuario = usuarioService.findByNombre(name);
       
        System.out.print(usuario.getId_usuario());
        Date fecha = new Date();
        OrdenCompra oc = new OrdenCompra();
        
        
        mav.addObject("id", charge.getId().toString());
        mav.addObject("status", charge.getStatus());
        mav.addObject("balance_transaction", charge.getBalanceTransaction().toString());

        
        System.out.println("ID: "+charge.getId().toString());
        System.out.println("Balance: "+charge.getBalanceTransaction().toString());
        
       
		
		
		oc.setFecha(fecha);
		oc.setTotal_money(2);
		System.out.print("FKKKKKKKKKK");
		System.out.print(oc.getFk_usuario());
		System.out.println("HEY: "+usuario.getId_usuario());
		System.out.println("HEY2: "+oc.getFk_usuario());
		oc.setStatus(charge.getStatus());
		oc.setCorrelativo(charge.getId());
		oc.setBalance(charge.getBalanceTransaction());
		oc.setUserlog(name);
		oc.setFk_usuario(null);
		oc.setFk_usuario(34);
		
		OrdenCompraService.insertAndUpdate(oc);
		
		System.out.println("ESTE ES: "+name); 
		mav.setViewName("result");
		Utils.removeCartInSession(request);
		return mav;
	}

	@ExceptionHandler(StripeException.class)
	public String handleError(Model model, StripeException ex) {
		model.addAttribute("error", ex.getMessage());
		return "result";
	}
}
