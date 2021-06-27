package pe.edu.upc.hope.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.hope.model.entity.Customer;
import pe.edu.upc.hope.model.repository.CustomerRepository;
import pe.edu.upc.hope.service.CustomerService;


@Service
public class CustomerServiceImpl  implements CustomerService {

	
	@Autowired
	private CustomerRepository  customerRepository;
	
	
	@Override
	public JpaRepository<Customer, Integer> getRepository() {
		return customerRepository;
	}

}
