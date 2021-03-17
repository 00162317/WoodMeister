package com.Stripe.Weister2.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Stripe.Weister2.domain.Usuario;
import com.Stripe.Weister2.service.UsuarioService;




@Service
public class PrincipalUserDetailsService implements UserDetailsService {
	@Autowired
	UsuarioService UsuarioService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Usuario> cuenta = UsuarioService.findByNombre(username);
		 cuenta.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
		 return cuenta.map(PrincipalUserDetails::new).get();
	}
	
	

}