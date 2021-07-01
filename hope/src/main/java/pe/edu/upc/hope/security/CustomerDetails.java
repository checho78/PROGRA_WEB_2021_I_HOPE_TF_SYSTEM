package pe.edu.upc.hope.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pe.edu.upc.hope.model.entity.Customer;

public class CustomerDetails implements UserDetails {
	
	private Customer customer;

	public CustomerDetails(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return null;
	}

	@Override
	public String getPassword() {

		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		return customer.getEmail();
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
	
	public String getFullName() {
		return customer.getFirstName() + " " + customer.getLastName(); 
	}
}
