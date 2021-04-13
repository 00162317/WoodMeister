package com.Stripe.Weister2.Utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.Stripe.Weister2.domain.Producto;

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

	public static Integer calcularTotal( List<Producto> p2) {

		Integer precio = 0;

		for (int i = 0; i < p2.size(); i++) {
			precio += p2.get(i).getPrecio();
			
		}

		return precio;
	}
	
	public static List<Producto> EliminarDelCarrito(List<Producto> p3, int id) {

		for (int i = 0; i < p3.size(); i++) {
			if(id== p3.get(i).getId_producto()) {
			 p3.remove(i);
			}
		}
		return p3;
		}
 
}
