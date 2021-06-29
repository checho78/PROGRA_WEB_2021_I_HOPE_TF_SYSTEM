package pe.edu.upc.hope.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.hope.model.entity.Brand;
import pe.edu.upc.hope.model.repository.BrandRepository;
import pe.edu.upc.hope.service.BrandService;



@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public JpaRepository<Brand, Integer> getRepository() {
	
		return brandRepository;
	}

}
