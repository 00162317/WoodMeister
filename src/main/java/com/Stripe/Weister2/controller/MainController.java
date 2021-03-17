package com.Stripe.Weister2.controller;

import java.security.InvalidAlgorithmParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Stripe.Weister2.domain.ChargeRequest;
import com.Stripe.Weister2.domain.ChargeRequest.Currency;
import com.Stripe.Weister2.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;



@Controller
@Service
public class MainController {
	


}
