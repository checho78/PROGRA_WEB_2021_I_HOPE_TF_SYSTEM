package pe.edu.upc.hope.service;

import java.util.List;

import pe.edu.upc.hope.model.entity.Product;
import pe.edu.upc.hope.model.entity.Reservation;


public interface ProductService extends CrudService<Product, Integer>{

	//List<Product> findProductsByReservationId(Reservation reservation) throws Exception;
	
	
	List<Product> findByName(String name) throws Exception;
    List<Product> findByPrice(Double price) throws Exception;
    List<Product> findByDescription(String description) throws Exception;


	    
}
