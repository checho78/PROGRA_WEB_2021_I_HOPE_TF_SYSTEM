package pe.edu.upc.hope.service.impl;

import pe.edu.upc.hope.model.entity.Pharmacy;
import pe.edu.upc.hope.model.repository.PharmacyRepository;
import pe.edu.upc.hope.service.PharmacyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PharmacyServiceImpl implements PharmacyService {
    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Override
    public JpaRepository<Pharmacy,Long> getRepository(){
        return pharmacyRepository;
    }
}
