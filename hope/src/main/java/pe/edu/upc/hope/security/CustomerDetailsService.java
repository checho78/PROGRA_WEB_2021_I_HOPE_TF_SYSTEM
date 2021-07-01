package pe.edu.upc.hope.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pe.edu.upc.hope.model.entity.Customer;
import pe.edu.upc.hope.model.repository.CustomerRepository;

public class CustomerDetailsService implements UserDetailsService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Customer customer = customerRepository.findByEmail(username);
        if (customer == null) {
            throw new UsernameNotFoundException("Customer not found");
        }
        return new CustomerDetails(customer);
	}

}
