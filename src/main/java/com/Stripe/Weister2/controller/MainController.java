package com.Stripe.Weister2.controller;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Stripe.Weister2.domain.About_us;
import com.Stripe.Weister2.domain.Imagen;
import com.Stripe.Weister2.domain.Material;
import com.Stripe.Weister2.domain.PersonalProfesional;
import com.Stripe.Weister2.domain.Producto;
import com.Stripe.Weister2.domain.Sexo;
import com.Stripe.Weister2.domain.TipoUsuario;
import com.Stripe.Weister2.domain.Usuario;
import com.Stripe.Weister2.dto.sliderDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import com.Stripe.Weister2.service.*;

@Controller
@Service
public class MainController {

	@Autowired
	private SexoService SexoService;

	@Autowired
	private TipoUsuarioService TipoUsuarioService;

	@Autowired
	private MaterialService MaterialService;

	@Autowired
	private PersonalProService PersonalProService;

	@Autowired
	private ProductoService ProductoService;

	@Autowired
	private TipoProductoService TipoProductoService;

	@Autowired
	private UsuarioService UsuarioService;

	@Autowired
	private ImagenService ImagenService;

	@Autowired
	private AboutUs_Service aboutService;

	@Autowired
	private PersonalProService proService;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();

		List<sliderDTO> slider = null;
		List<sliderDTO> slider2 = new ArrayList<>();
		List<sliderDTO> producto = new ArrayList<>();

		try {
			slider = ProductoService.dtoPrueba();
			int aux = 0;
			int flag = 0;
			for (sliderDTO sliderDTO : slider) {
				if (flag != 3) {
					if (aux == 0 || aux != sliderDTO.getId_producto()) {

						slider2.add(sliderDTO);
						System.out.print(sliderDTO.getId_producto());
						aux = sliderDTO.getId_producto();
						flag++;
					}
				}
			}

			for (sliderDTO sliderDTO : slider) {
				if (aux == 0 || aux != sliderDTO.getId_producto()) {
					producto.add(sliderDTO);
					System.out.print(sliderDTO.getId_producto());
					aux = sliderDTO.getId_producto();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("slider", slider2);
		mav.addObject("producto", producto);
		mav.setViewName("index1");
		return mav;
	}

	@RequestMapping("/about")
	public ModelAndView about(@ModelAttribute About_us us, @ModelAttribute PersonalProfesional pro) {
		ModelAndView mav = new ModelAndView();

		List<About_us> listaAbout = null;
		List<PersonalProfesional> listPro = null;

		try {

			listaAbout = aboutService.findAll();
			listPro = proService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("listaAbout", listaAbout);
		mav.addObject("listPro", listPro);
		mav.addObject("pro", pro);
		mav.addObject("us", us);
		mav.setViewName("about");
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping("/tracki")
	public ModelAndView tracking1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tracking");
		return mav;
	}

	@RequestMapping("/product")
	public ModelAndView product(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();

		List<Imagen> img = null;
		List<sliderDTO> slider = null;
		List<sliderDTO> producto2 = new ArrayList<>();

		Producto producto = ProductoService.findOne(id);

		try {
			img = ImagenService.findImagenes(id);

			slider = ProductoService.dtoPrueba();
			int aux = 0;
			int flag = 0;

			for (sliderDTO sliderDTO : slider) {
				if (aux == 0 || aux != sliderDTO.getId_producto()) {
					producto2.add(sliderDTO);
					System.out.print(sliderDTO.getId_producto());
					aux = sliderDTO.getId_producto();
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.print("HOLA WEEEEYYY " + producto.getNombre());

		mav.addObject("img", img);
		mav.addObject("producto", producto);
		mav.addObject("producto2", producto2);
		mav.setViewName("product");

		return mav;
	}



	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		int x = 1, y = 0, registrado = 0;
		List<Sexo> listaSexo = null;
		List<TipoUsuario> listaTusuario = null;

		try {

			listaSexo = SexoService.findAll();
			listaTusuario = TipoUsuarioService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		Usuario usuario = new Usuario();
		usuario.setRol("ROLE_USER");
		mav.addObject("usuario", usuario);
		mav.addObject("username", y);
		mav.addObject("email", y);
		mav.addObject("pass", y);
		mav.addObject("listaSexo", listaSexo);
		mav.addObject("registrado", registrado);
		mav.addObject("listaTusuario", listaTusuario);
		mav.setViewName("register2");
		return mav;
	}



	@RequestMapping("/registerproff")
	public ModelAndView formProducto(@Valid @ModelAttribute Usuario usuario, BindingResult result, @RequestParam("pass") String pass,
			@RequestParam("password") String password, @RequestParam("nombre") String nombre,
			@RequestParam("email") String email) {
		ModelAndView mav = new ModelAndView();
		int usuario1 = 0, emai = 0, aux = 0, pas = 0, registrado = 0;
		List<Sexo> listaSexo = null;
		List<TipoUsuario> listaTusuario = null;
		List<Usuario> usuarioList = null;
		if (result.hasErrors()) {
			mav.addObject("registrado", registrado);
			mav.setViewName("register2");
			
		} 
		try {
			usuarioList = UsuarioService.findAll();

			listaSexo = SexoService.findAll();
			listaTusuario = TipoUsuarioService.findAll();
			for (Usuario Usuario : usuarioList) {
				System.out.print(Usuario.getNombre());
				if (Usuario.getNombre().equals(nombre)) {
					usuario1 = 1;
					aux++;
				}
				if (Usuario.getEmail().equals(email)) {
					emai = 1;
					aux++;
				}
			}

			if (!password.equals(pass)) {
				aux++;
				pas = 1;

			}
			mav.addObject("listaTusuario", listaTusuario);
			mav.addObject("usuario", usuario);
			mav.addObject("listaSexo", listaSexo);
			mav.setViewName("register2");

			if (aux != 0) {
				mav.addObject("username", usuario1);
				mav.addObject("email", emai);
				mav.addObject("pass", pas);
				mav.addObject("registrado", registrado);
				return mav;
			}

			UsuarioService.insertAndUpdate(usuario);

		} catch (Exception e) {
			e.printStackTrace();
		}
		registrado = 1;
		mav.addObject("registrado", registrado);
		return mav;
	}

	@RequestMapping("/prueba")
	public ModelAndView prueba() {
		ModelAndView mav = new ModelAndView();

		List<Sexo> sexos = null;
		List<Material> materials = null;
		List<PersonalProfesional> personalProfesionals = null;

		try {

			sexos = SexoService.findAll();
			materials = MaterialService.findAll();
			personalProfesionals = PersonalProService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("sexos", sexos);
		mav.addObject("materials", materials);
		mav.addObject("personalProfesionals", personalProfesionals);
		mav.setViewName("prueba");
		return mav;
	}

}
