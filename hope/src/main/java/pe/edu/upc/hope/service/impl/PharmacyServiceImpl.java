package pe.edu.upc.hope.service.impl;

import pe.edu.upc.hope.model.entity.Pharmacy;


import pe.edu.upc.hope.model.repository.PharmacyRepository;
import pe.edu.upc.hope.service.PharmacyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PharmacyServiceImpl implements PharmacyService {
    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Override
    public JpaRepository<Pharmacy,Integer> getRepository(){
        return pharmacyRepository;
    
    }
    @Transactional(readOnly = true)
	@Override
	public List<Pharmacy> findByDistrict(String district) throws Exception {
		return pharmacyRepository.findByDistrict(district); 
	}
}
