package pe.edu.upc.hope.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.hope.model.entity.Product;
//CAMBIAR PANDEMIA POR NOMBRE DEL PROYECTO

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
