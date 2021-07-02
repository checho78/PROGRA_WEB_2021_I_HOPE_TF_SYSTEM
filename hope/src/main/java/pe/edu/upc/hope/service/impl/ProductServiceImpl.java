package pe.edu.upc.hope.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.hope.model.entity.Product;
import pe.edu.upc.hope.model.entity.Reservation;
import pe.edu.upc.hope.model.repository.ProductRepository;
import pe.edu.upc.hope.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public JpaRepository<Product, Integer> getRepository() {
	
		return productRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Product> findByName(String name) throws Exception {
		return productRepository.findByName(name);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Product> findByPrice(Double price) throws Exception {
		return productRepository.findByPrice(price);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Product> findByDescription(String description) throws Exception {
		return productRepository.findByDescription(description);
	}



	/* @Transactional(readOnly = true)
	@Override
	public List<Product> findProductsByReservationId(Reservation reservation) throws Exception {
		
		return productRepository.findByReservation(reservation);
	}
	*/

}
