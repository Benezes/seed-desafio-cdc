package br.com.gabriel.cc.autor.service;

import br.com.gabriel.cc.autor.dto.CategoryDTO;
import br.com.gabriel.cc.autor.entity.CategoryEntity;
import br.com.gabriel.cc.autor.repository.CategoryRepository;
import br.com.gabriel.cc.autor.service.exception.ValueDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        if(categoryRepository.findCategoryByNameCategory(categoryDTO.getNameCategory()) != null) {
            throw new ValueDuplicatedException("Category already exist");
        }
        return new CategoryDTO(categoryRepository.save(new CategoryEntity(categoryDTO)));
    }
}
