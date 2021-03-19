package com.Stripe.Weister2.controller.Stripe;

import java.security.InvalidAlgorithmParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Stripe.Weister2.domain.ChargeRequest;
import com.Stripe.Weister2.domain.ChargeRequest.Currency;
import com.Stripe.Weister2.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;


@Controller
public class StripeController {

	@Autowired
    private StripeService paymentsService;


	@RequestMapping("/charge")
	public ModelAndView charge2(ChargeRequest chargeRequest, Model model) 
			throws StripeException, InvalidAlgorithmParameterException{
		
		ModelAndView mav = new ModelAndView();
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);
        mav.addObject("id", charge.getId());
        mav.addObject("status", charge.getStatus());
        mav.addObject("chargeId", charge.getId());
        mav.addObject("balance_transaction", charge.getBalanceTransaction());
			
		mav.setViewName("result");
		return mav;
	}

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}
