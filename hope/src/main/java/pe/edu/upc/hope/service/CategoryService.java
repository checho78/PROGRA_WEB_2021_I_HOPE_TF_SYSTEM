package pe.edu.upc.hope.service;

import java.util.List;

import pe.edu.upc.hope.model.entity.Category;


public interface CategoryService extends CrudService<Category, Integer>{
	List<Category> findByCategoryName( String nameCategory) throws Exception;
}
