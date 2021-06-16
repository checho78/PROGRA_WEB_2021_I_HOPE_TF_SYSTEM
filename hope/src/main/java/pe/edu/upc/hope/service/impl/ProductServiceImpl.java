package pe.edu.upc.hope.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.hope.model.entity.Product;
import pe.edu.upc.hope.model.repository.ProductRepository;
import pe.edu.upc.hope.service.ProductService;
// CAMBIAR PANDEMIA POR EL NOMBRE DEL PROYECTO

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public JpaRepository<Product, Integer> getRepository() {
		// TODO Auto-generated method stub
		return productRepository;
	}

}
