package pe.edu.upc.hope.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.hope.model.entity.Brand;
// CAMBIAR PANDEMIA POR NOBMRE DEL PROYECTO

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
