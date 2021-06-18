package pe.edu.upc.hope.model.repository;

import pe.edu.upc.hope.model.entity.Pharmacy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {
	
	List<Pharmacy> findByDistrict(String district);  

}
