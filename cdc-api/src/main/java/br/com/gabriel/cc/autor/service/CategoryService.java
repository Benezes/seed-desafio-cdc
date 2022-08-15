package br.com.gabriel.cc.autor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.cc.autor.dto.CategoryDTO;
import br.com.gabriel.cc.autor.entity.CategoryEntity;
import br.com.gabriel.cc.autor.repository.CategoryRepository;
import br.com.gabriel.cc.autor.service.exception.ValueDuplicatedException;

@Service
public class CategoryService {

	private static final String CATEGORY_ALREADY_EXIST = "Category already exist";
	@Autowired
	private CategoryRepository categoryRepository;

	public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
		checkDuplicateCategory(categoryDTO);
		return new CategoryDTO(categoryRepository.save(new CategoryEntity(categoryDTO)));
	}

	private void checkDuplicateCategory(CategoryDTO categoryDTO) {
		if (categoryRepository.findByNameCategory(categoryDTO.getNameCategory()).isPresent()) {
			throw new ValueDuplicatedException(CATEGORY_ALREADY_EXIST);
		}
	}
}
