package com.Stripe.Weister2.Security;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Stripe.Weister2.domain.Usuario;


public class PrincipalUserDetails implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario user;

	public PrincipalUserDetails(Usuario user) {
		this.user = user;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<>();
		GrantedAuthority authority = new SimpleGrantedAuthority(this.user.getRol());
		authorities.add(authority);

		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user.getNombre();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());

		return result;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrincipalUserDetails)) return false;
        PrincipalUserDetails that = (PrincipalUserDetails) o;
        return Objects.equals(this.user.getNombre(), that.getUsername());
    }

}