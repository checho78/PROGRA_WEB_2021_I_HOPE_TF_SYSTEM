package pe.edu.upc.hope.service;

import java.util.List;

import pe.edu.upc.hope.model.entity.Pharmacy;

public interface PharmacyService extends CrudService<Pharmacy, Integer> {
	List<Pharmacy> findByDistrict( String district) throws Exception;
}


