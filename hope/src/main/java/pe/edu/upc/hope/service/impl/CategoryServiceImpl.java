package pe.edu.upc.hope.service.impl;

import pe.edu.upc.hope.model.entity.Category;

import pe.edu.upc.hope.model.repository.CategoryRepository;
import pe.edu.upc.hope.service.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public JpaRepository<Category, Integer> getRepository() {
		return categoryRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Category> findByCategoryName(String categoryName) throws Exception {
		return categoryRepository.findByCategoryName(categoryName); 
	}

} 