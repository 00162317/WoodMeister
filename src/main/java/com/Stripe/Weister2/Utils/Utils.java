package com.Stripe.Weister2.Utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.Stripe.Weister2.domain.Producto;
import com.Stripe.Weister2.dto.sliderDTO;

public class Utils {
	// Products in the cart, stored in Session.
	public static List<Producto> getCartInSession(HttpServletRequest request) {

		List<Producto> p2 = (List<Producto>) request.getSession().getAttribute("myCart");

		if (p2 == null) {
			List<Producto> pr = new ArrayList<>();

			request.getSession().setAttribute("myCart", pr);
			return pr;
		} else {

			return p2;
		}
	}

	public static void removeCartInSession(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}

	public static Integer calcularTotal(List<sliderDTO> p2) {

		Integer precio = 0;

		for (int i = 0; i < p2.size(); i++) {
			precio += p2.get(i).getPrecio();

		}

		return precio;
	}

	

	public static List<sliderDTO> EliminarDelCarrito2(List<sliderDTO> p3, int id) {
		int aux = 0;
		for (int i = 0; i < p3.size(); i++) {
			if (id == p3.get(i).getId_producto()&& aux<1) {
					p3.remove(i);
					aux= aux++;
			}
		}
		return p3;
	}

	public static List<sliderDTO> EliminarDelCarrito3(List<sliderDTO> p3, int id, Integer material) {
		System.out.print("ENTRAMOS");
		int aux = 0;
		for (int i = 0; i < p3.size(); i++) {
			if ((id == p3.get(i).getId_producto())&&(p3.get(i).getIdcarrito() == material) ) {
					p3.remove(i);
					return p3;
			}
		}
		return p3;
	}

	public static List<sliderDTO> getCartInSession2(HttpServletRequest request) {

		List<sliderDTO> p2 = (List<sliderDTO>) request.getSession().getAttribute("myCart");

		if (p2 == null) {
			List<sliderDTO> pr = new ArrayList<>();

			request.getSession().setAttribute("myCart", pr);
			return pr;
		} else {

			return p2;
		}
	}
}
