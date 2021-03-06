package pe.edu.upc.hope.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.hope.model.entity.Category;
import pe.edu.upc.hope.model.repository.CategoryRepository;
import pe.edu.upc.hope.service.CategoryService;


@Service
public class CategoryServiceImpl  implements CategoryService {

	
	@Autowired
	private CategoryRepository  categoryRepository;
	
	
	@Override
	public JpaRepository<Category, Integer> getRepository() {
		return categoryRepository;
	}

}
