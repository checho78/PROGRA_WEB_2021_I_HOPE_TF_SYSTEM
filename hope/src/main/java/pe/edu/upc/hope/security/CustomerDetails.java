package pe.edu.upc.hope.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pe.edu.upc.hope.model.entity.Card;
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
	
	
	public Integer getId() {
		return customer.getId();
	}
	
	
	public String getCellphone() {
		return customer.getCellphone();
	}

	public String getDni() {
		return customer.getDni();
	}

	public List<Card> getCards() {
		return customer.getCards();
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
