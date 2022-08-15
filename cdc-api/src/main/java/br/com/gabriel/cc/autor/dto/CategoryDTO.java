package br.com.gabriel.cc.autor.dto;

import java.io.Serializable;

import br.com.gabriel.cc.autor.entity.CategoryEntity;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nameCategory;

    public CategoryDTO() {
    }

    public CategoryDTO(CategoryEntity entity) {
        this.id = entity.getId();
        this.nameCategory = entity.getNameCategory();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
