package pe.edu.upc.Greencode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.Greencode.model.entity.Category;
import pe.edu.upc.Greencode.model.repository.CategoryRepository;
import pe.edu.upc.Greencode.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public JpaRepository<Category, Integer> getRepository() {
		return categoryRepository;
	}

}
